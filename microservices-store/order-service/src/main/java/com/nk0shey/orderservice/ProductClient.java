package com.nk0shey.orderservice;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Map;
@Component
public class ProductClient {
 public record Reservation(String id,Long productId,int quantity,String productName,BigDecimal unitPrice){}
 private final RestTemplate client;private final String url;
 public ProductClient(RestTemplateBuilder builder,@Value("${products.url:http://localhost:8081}") String url){
  this.client=builder.connectTimeout(Duration.ofSeconds(3)).readTimeout(Duration.ofSeconds(5)).build();this.url=url;
 }
 public Reservation reserve(String key,Long productId,int quantity){
  try {
   Reservation r=client.postForObject(url+"/products/reservations/"+key,Map.of("productId",productId,"quantity",quantity),Reservation.class);
   if(r==null||!key.equals(r.id())||!productId.equals(r.productId())||quantity!=r.quantity()||r.unitPrice()==null||r.productName()==null)
    throw new ResponseStatusException(HttpStatus.BAD_GATEWAY,"Invalid product-service response");
   return r;
  }catch(HttpClientErrorException e){
   if(e.getStatusCode().value()==404)throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found");
   if(e.getStatusCode().value()==409)throw new ResponseStatusException(HttpStatus.CONFLICT,"Insufficient stock or conflicting idempotency key");
   throw new ResponseStatusException(HttpStatus.BAD_GATEWAY,"Product service rejected the request");
  }catch(RestClientException e){throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,"Product service unavailable; retry with the same Idempotency-Key");}
 }
}
