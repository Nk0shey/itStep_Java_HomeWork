package com.nk0shey.productservice.repository;
import com.nk0shey.productservice.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReservationRepository extends JpaRepository<Reservation,String> {}
