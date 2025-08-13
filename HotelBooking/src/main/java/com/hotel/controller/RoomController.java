package com.hotel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Room;
import com.hotel.repo.RoomRepo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/rooms/")
public class RoomController {

	private final RoomRepo roomRepo;

	public RoomController(RoomRepo roomRepo) {
		this.roomRepo = roomRepo;
	}

	@PostMapping
	public ResponseEntity<String> save(@RequestBody Room room) {
		return ResponseEntity.status(HttpStatus.CREATED).body("Room added with id : " + roomRepo.save(room).getId());
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<Room>> getByHotelAvailableRooms(@PathVariable Long hotelId) {
		return ResponseEntity.ok(roomRepo.findByHotelIdAndAvailabilityTrue(hotelId));
	}

}
