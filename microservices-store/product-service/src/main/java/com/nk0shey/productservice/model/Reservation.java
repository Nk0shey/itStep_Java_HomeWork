package com.nk0shey.productservice.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity
public class Reservation {
 @Id public String id;
 @Column(nullable=false) public Long productId;
 @Column(nullable=false) public int quantity;
 @Column(nullable=false) public String productName;
 @Column(nullable=false,precision=19,scale=2) public BigDecimal unitPrice;
}
