package com.nk0shey.orderservice;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.*;
import java.util.UUID;
@RestController
@RequestMapping("/orders")
public class OrderController {
 public record Input(@NotNull @Positive Long productId,@Min(1) int quantity){}
 private final OrderService service;private final OrderRepository orders;
 public OrderController(OrderService s,OrderRepository o){service=s;orders=o;}
 @PostMapping public OrderRecord create(@RequestHeader("Idempotency-Key") UUID key,@Valid @RequestBody Input input){return service.create(key.toString(),input.productId(),input.quantity());}
 @GetMapping("/{id}") public OrderRecord get(@PathVariable UUID id){return orders.findById(id.toString()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Order not found"));}
 @GetMapping public Page<OrderRecord> list(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="20") int size){
  if(page<0||size<1||size>100)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid page or size");
  return orders.findAll(PageRequest.of(page,size,Sort.by("createdAt").descending()));
 }
}
