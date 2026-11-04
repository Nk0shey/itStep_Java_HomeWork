package com.nk0shey.orderservice;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<OrderRecord,String>{}
