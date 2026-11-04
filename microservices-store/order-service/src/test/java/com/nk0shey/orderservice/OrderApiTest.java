package com.nk0shey.orderservice;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.math.BigDecimal;
import java.util.UUID;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest @AutoConfigureMockMvc
class OrderApiTest {
 @Autowired MockMvc mvc; @Autowired OrderRepository orders; @MockitoBean ProductClient products;
 @BeforeEach void reset(){orders.deleteAll();}
 @Test void createsSnapshotsAndReplaysOrder() throws Exception {
  String key=UUID.randomUUID().toString();when(products.reserve(key,1L,2)).thenReturn(new ProductClient.Reservation(key,1L,2,"Book",new BigDecimal("12.50")));
  String original=null;
  for(int i=0;i<2;i++){String response=mvc.perform(post("/orders").header("Idempotency-Key",key).contentType(MediaType.APPLICATION_JSON).content("{\"productId\":1,\"quantity\":2}"))
   .andExpect(status().isOk()).andExpect(jsonPath("$.total").value(25)).andExpect(jsonPath("$.productName").value("Book")).andReturn().getResponse().getContentAsString();
   if(original!=null)assertEquals(original,response);original=response;
  }
  verify(products,times(1)).reserve(key,1L,2);assertEquals(1,orders.count());
  mvc.perform(get("/orders/"+key)).andExpect(status().isOk());
  mvc.perform(get("/orders")).andExpect(jsonPath("$.totalElements").value(1));
  mvc.perform(post("/orders").header("Idempotency-Key",key).contentType(MediaType.APPLICATION_JSON).content("{\"productId\":1,\"quantity\":3}")).andExpect(status().isConflict());
 }
 @Test void invalidRequestsNeverReserveStock() throws Exception {
  for(String body:new String[]{"{}","{\"productId\":1,\"quantity\":0}"})
   mvc.perform(post("/orders").header("Idempotency-Key",UUID.randomUUID()).contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(status().isBadRequest());
  mvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON).content("{\"productId\":1,\"quantity\":1}")).andExpect(status().isBadRequest());
  mvc.perform(get("/orders/"+UUID.randomUUID())).andExpect(status().isNotFound());verifyNoInteractions(products);
 }
 @Test void downstreamFailureDoesNotCreateOrderAndCanRetry() throws Exception {
  String key=UUID.randomUUID().toString();when(products.reserve(key,1L,2)).thenThrow(new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE)).thenReturn(new ProductClient.Reservation(key,1L,2,"Book",new BigDecimal("10")));
  mvc.perform(post("/orders").header("Idempotency-Key",key).contentType(MediaType.APPLICATION_JSON).content("{\"productId\":1,\"quantity\":2}")).andExpect(status().isServiceUnavailable());assertEquals(0,orders.count());
  mvc.perform(post("/orders").header("Idempotency-Key",key).contentType(MediaType.APPLICATION_JSON).content("{\"productId\":1,\"quantity\":2}")).andExpect(status().isOk());assertEquals(1,orders.count());
 }
}
