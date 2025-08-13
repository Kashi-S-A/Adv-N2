package com.hotel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dto.BookingRequestDTO;
import com.hotel.entity.Booking;
import com.hotel.entity.Hotel;
import com.hotel.repo.HotelRepo;
import com.hotel.service.BookingService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	private final BookingService bookingService;

	private final HotelRepo hotelRepo;

	public BookingController(BookingService bookingService, HotelRepo hotelRepo) {
		this.bookingService = bookingService;
		this.hotelRepo = hotelRepo;
	}

	@PostMapping
	public ResponseEntity<String> book(@RequestBody BookingRequestDTO bookingDto) {
		String message = bookingService.createBooking(bookingDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}

	@GetMapping
	public ResponseEntity<List<Hotel>> search(@RequestParam String nameOrLocation) {
		return ResponseEntity.ok(hotelRepo.findByLocationOrNameContainingAllIgnoreCase(nameOrLocation));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Booking> getById(@PathVariable Long id) {
		return ResponseEntity
				.ok(bookingService.findById(id).orElseThrow(() -> new RuntimeException("Booking Not Found")));
	}

	@GetMapping("/cancel/{id}")
	public String getMethodName(@PathVariable Long	id) {
		bookingService.cancelBooking(id);
		return new String();
	}
	
}
