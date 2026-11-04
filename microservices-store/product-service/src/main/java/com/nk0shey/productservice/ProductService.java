package com.nk0shey.productservice;
import com.nk0shey.productservice.model.*;
import com.nk0shey.productservice.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.*;
@Service
public class ProductService {
 private final ProductRepository products; private final ReservationRepository reservations;
 public ProductService(ProductRepository p,ReservationRepository r){products=p;reservations=r;}
 @Transactional public Product update(Long id, Product input) {
  Product p=products.locked(id).orElseThrow(()->new ResponseStatusException(NOT_FOUND,"Product not found"));
  p.name=input.name;p.price=input.price;p.stock=input.stock;return p;
 }
 @Transactional public void delete(Long id){
  Product p=products.locked(id).orElseThrow(()->new ResponseStatusException(NOT_FOUND,"Product not found")); products.delete(p);
 }
 @Transactional public Reservation reserve(String key, Long productId,int quantity){
  Reservation previous=reservations.findById(key).orElse(null);
  if(previous!=null)return check(previous,productId,quantity);
  Product p=products.locked(productId).orElseThrow(()->new ResponseStatusException(NOT_FOUND,"Product not found"));
  previous=reservations.findById(key).orElse(null);
  if(previous!=null)return check(previous,productId,quantity);
  if(p.stock<quantity)throw new ResponseStatusException(CONFLICT,"Insufficient stock");
  p.stock-=quantity;
  Reservation r=new Reservation();r.id=key;r.productId=productId;r.quantity=quantity;r.productName=p.name;r.unitPrice=p.price;
  return reservations.saveAndFlush(r);
 }
 private Reservation check(Reservation r,Long productId,int quantity){
  if(!r.productId.equals(productId)||r.quantity!=quantity)throw new ResponseStatusException(CONFLICT,"Idempotency key reused with different request");return r;
 }
}
