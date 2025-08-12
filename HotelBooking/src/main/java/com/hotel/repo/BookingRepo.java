package com.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {

}
