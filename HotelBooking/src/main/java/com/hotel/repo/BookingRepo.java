package com.hotel.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotel.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {

	@Query("SELECT b FROM Booking b JOIN b.rooms r " +
		       "WHERE r.id IN :roomIds " +
		       "AND b.status = 'CONFIRMED' " +
		       "AND (:checkIn < b.checkout AND :checkOut > b.checkIn)")
		List<Booking> findConflictingBookings(
		        @Param("roomIds") List<Long> roomIds,
		        @Param("checkIn") LocalDate checkIn,
		        @Param("checkOut") LocalDate checkOut
		);

}
