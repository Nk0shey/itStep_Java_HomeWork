package com.nk0shey.orderservice;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.web.client.MockServerRestTemplateCustomizer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.http.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.UUID;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;
import static org.junit.jupiter.api.Assertions.*;
class ProductClientTest {
 @Test void mapsRemoteFailures() {
  for(int code:new int[]{404,409,500}){
   var customizer=new MockServerRestTemplateCustomizer();var client=new ProductClient(new RestTemplateBuilder(customizer),"http://products.test");var server=customizer.getServer();String key=UUID.randomUUID().toString();
   server.expect(requestTo("http://products.test/products/reservations/"+key)).andExpect(method(HttpMethod.POST)).andRespond(withStatus(HttpStatus.valueOf(code)));
   var e=assertThrows(ResponseStatusException.class,()->client.reserve(key,1L,1));assertEquals(code==500?503:code,e.getStatusCode().value());server.verify();
  }
 }
 @Test void rejectsEmptyRemoteResponse() {
  var customizer=new MockServerRestTemplateCustomizer();var client=new ProductClient(new RestTemplateBuilder(customizer),"http://products.test");var server=customizer.getServer();String key=UUID.randomUUID().toString();
  server.expect(requestTo("http://products.test/products/reservations/"+key)).andRespond(withSuccess("",MediaType.APPLICATION_JSON));
  assertEquals(502,assertThrows(ResponseStatusException.class,()->client.reserve(key,1L,1)).getStatusCode().value());server.verify();
 }
}
