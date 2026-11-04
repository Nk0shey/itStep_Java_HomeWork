package com.nk0shey.productservice;
import com.nk0shey.productservice.model.Product;
import com.nk0shey.productservice.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest @AutoConfigureMockMvc
class ProductApiTest {
 @Autowired MockMvc mvc; @Autowired ObjectMapper json; @Autowired ProductRepository products;
 @Autowired ReservationRepository reservations; @Autowired ProductService service;
 @BeforeEach void reset(){reservations.deleteAll();products.deleteAll();}
 Product product(int stock){Product p=new Product();p.name="Book";p.price=new BigDecimal("12.50");p.stock=stock;return products.saveAndFlush(p);}
 @Test void crudAndSearch() throws Exception {
  String body=mvc.perform(post("/products").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"Book\",\"price\":12.50,\"stock\":3}"))
   .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
  long id=json.readTree(body).get("id").asLong();
  mvc.perform(get("/products").param("q","boo")).andExpect(jsonPath("$.totalElements").value(1));
  mvc.perform(get("/products").param("q","%" )).andExpect(jsonPath("$.totalElements").value(0));
  mvc.perform(put("/products/"+id).contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"New book\",\"price\":15,\"stock\":2}"))
   .andExpect(status().isOk()).andExpect(jsonPath("$.stock").value(2));
  mvc.perform(delete("/products/"+id)).andExpect(status().isNoContent());
  mvc.perform(get("/products/"+id)).andExpect(status().isNotFound());
 }
 @Test void rejectsInvalidInput() throws Exception {
  for(String body:List.of("{}","{\"name\":\" \",\"price\":1,\"stock\":1}","{\"name\":\"x\",\"price\":-1,\"stock\":1}","{\"name\":\"x\",\"price\":1.001,\"stock\":1}","{\"name\":\"x\",\"price\":1,\"stock\":-1}"))
   mvc.perform(post("/products").contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(status().isBadRequest());
  mvc.perform(get("/products").param("size","101")).andExpect(status().isBadRequest());
 }
 @Test void reservationsAreIdempotentAndKeepPriceSnapshot() throws Exception {
  Product p=product(3);String key=UUID.randomUUID().toString();String path="/products/reservations/"+key;
  String body="{\"productId\":"+p.id+",\"quantity\":2}";
  mvc.perform(post(path).contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(status().isOk()).andExpect(jsonPath("$.unitPrice").value(12.5));
  Product changed=product(1);changed.name="Changed";changed.price=new BigDecimal("99");service.update(p.id,changed);
  mvc.perform(post(path).contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(status().isOk()).andExpect(jsonPath("$.unitPrice").value(12.5));
  assertEquals(1,products.findById(p.id).orElseThrow().stock);
  mvc.perform(post(path).contentType(MediaType.APPLICATION_JSON).content(body.replace("\"quantity\":2","\"quantity\":1"))).andExpect(status().isConflict());
  mvc.perform(post("/products/reservations/"+UUID.randomUUID()).contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(status().isConflict());
  mvc.perform(post(path).contentType(MediaType.APPLICATION_JSON).content(body.replace("\"quantity\":2","\"quantity\":0"))).andExpect(status().isBadRequest());
 }
 @Test void concurrentReservationsNeverOversell() throws Exception {
  Product p=product(5);ExecutorService pool=Executors.newFixedThreadPool(8);
  try {
   List<Callable<Boolean>> jobs=new ArrayList<>();
   for(int i=0;i<12;i++)jobs.add(()->{try{service.reserve(UUID.randomUUID().toString(),p.id,1);return true;}catch(org.springframework.web.server.ResponseStatusException e){assertEquals(409,e.getStatusCode().value());return false;}});
   int succeeded=0;for(Future<Boolean> f:pool.invokeAll(jobs))if(f.get())succeeded++;
   assertEquals(5,succeeded);assertEquals(0,products.findById(p.id).orElseThrow().stock);assertEquals(5,reservations.count());
  }finally{pool.shutdownNow();}
 }
 @Test void concurrentReplayDeductsOnlyOnce() throws Exception {
  Product p=product(5);String key=UUID.randomUUID().toString();ExecutorService pool=Executors.newFixedThreadPool(4);
  try{List<Callable<String>> jobs=new ArrayList<>();for(int i=0;i<8;i++)jobs.add(()->service.reserve(key,p.id,2).id);
   for(Future<String> f:pool.invokeAll(jobs))assertEquals(key,f.get());
   assertEquals(3,products.findById(p.id).orElseThrow().stock);assertEquals(1,reservations.count());
  }finally{pool.shutdownNow();}
 }
}
