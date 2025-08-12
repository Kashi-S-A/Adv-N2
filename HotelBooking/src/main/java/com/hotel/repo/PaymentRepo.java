package com.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long> {

}
