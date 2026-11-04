package com.nk0shey.orderservice;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.time.Instant;
import java.math.BigDecimal;
@Service
public class OrderService {
 private final OrderRepository orders;private final ProductClient products;
 public OrderService(OrderRepository o,ProductClient p){orders=o;products=p;}
 // One order-service instance in this exercise. The product reservation also deduplicates retries across restarts.
 public synchronized OrderRecord create(String key,Long productId,int quantity){
  OrderRecord existing=orders.findById(key).orElse(null);
  if(existing!=null){
   if(!existing.productId.equals(productId)||existing.quantity!=quantity)throw new ResponseStatusException(HttpStatus.CONFLICT,"Idempotency key reused with different request");return existing;
  }
  var r=products.reserve(key,productId,quantity);
  OrderRecord o=new OrderRecord();o.id=key;o.productId=productId;o.quantity=quantity;o.productName=r.productName();o.unitPrice=r.unitPrice();
  o.total=r.unitPrice().multiply(BigDecimal.valueOf(quantity));o.createdAt=Instant.now().truncatedTo(java.time.temporal.ChronoUnit.MICROS);
  return orders.saveAndFlush(o);
 }
}
