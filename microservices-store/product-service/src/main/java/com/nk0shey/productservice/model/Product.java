package com.nk0shey.productservice.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 @Column(nullable=false) public String name;
 @Column(nullable=false,precision=19,scale=2) public BigDecimal price;
 @Column(nullable=false) public int stock;
}
