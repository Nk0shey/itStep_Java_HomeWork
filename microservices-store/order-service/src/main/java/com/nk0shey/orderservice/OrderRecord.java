package com.nk0shey.orderservice;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
@Entity
public class OrderRecord {
 @Id public String id;
 @Column(nullable=false) public Long productId;
 @Column(nullable=false) public int quantity;
 @Column(nullable=false) public String productName;
 @Column(nullable=false,precision=19,scale=2) public BigDecimal unitPrice;
 @Column(nullable=false,precision=29,scale=2) public BigDecimal total;
 @Column(nullable=false) public Instant createdAt;
}
