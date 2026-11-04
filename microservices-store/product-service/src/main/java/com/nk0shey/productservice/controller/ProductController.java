package com.nk0shey.productservice.controller;
import com.nk0shey.productservice.*;
import com.nk0shey.productservice.model.*;
import com.nk0shey.productservice.repository.ProductRepository;
import com.nk0shey.productservice.spec.ProductSpecification;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.math.BigDecimal;
import java.util.UUID;
@RestController
@RequestMapping("/products")
public class ProductController {
 public record Input(@NotBlank @Size(max=200) String name,@NotNull @DecimalMin("0.01") @Digits(integer=17,fraction=2) BigDecimal price,@Min(0) int stock){
  Product product(){Product p=new Product();p.name=name.trim();p.price=price;p.stock=stock;return p;}
 }
 public record Reserve(@NotNull @Positive Long productId,@Min(1) int quantity){}
 private final ProductRepository products;private final ProductService service;
 public ProductController(ProductRepository p,ProductService s){products=p;service=s;}
 @GetMapping public Page<Product> list(@RequestParam(required=false) String q,@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="20") int size){
  if(page<0||size<1||size>100)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid page or size");
  return products.findAll(ProductSpecification.named(q),PageRequest.of(page,size,Sort.by("id")));
 }
 @GetMapping("/{id}") public Product get(@PathVariable Long id){return products.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Product create(@Valid @RequestBody Input input){return products.save(input.product());}
 @PutMapping("/{id}") public Product update(@PathVariable Long id,@Valid @RequestBody Input input){return service.update(id,input.product());}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){service.delete(id);}
 @PostMapping("/reservations/{key}") public Reservation reserve(@PathVariable UUID key,@Valid @RequestBody Reserve input){return service.reserve(key.toString(),input.productId(),input.quantity());}
}
