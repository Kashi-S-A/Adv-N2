package com.hotel.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Hotel;
import com.hotel.repo.HotelRepo;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

	private final HotelRepo hotelRepo;

	public HotelController(HotelRepo hotelRepo) {
		this.hotelRepo = hotelRepo;
	}

	@PostMapping
	public ResponseEntity<String> saveHotel(@RequestBody Hotel hotel) {
		return ResponseEntity.status(HttpStatus.CREATED).body("Hotel added with id : " + hotelRepo.save(hotel).getId());
	}

	@GetMapping
	public ResponseEntity<List<Hotel>> getAll(@RequestParam(required = false) String name) {
		if(name==null)
			return ResponseEntity.status(HttpStatus.OK).body(hotelRepo.findAll());
		return ResponseEntity.status(HttpStatus.OK).body(hotelRepo.findByNameContainingAllIgnoreCase(name));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getById(@PathVariable Long id) {
		Hotel hotel = hotelRepo.findById(id).orElseThrow(() -> new RuntimeException("Hotel Not Found"));
		return ResponseEntity.status(HttpStatus.OK).body(hotel);
	}

}
