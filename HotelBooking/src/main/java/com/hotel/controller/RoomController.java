package com.hotel.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dto.RoomDTO;
import com.hotel.entity.Hotel;
import com.hotel.entity.Room;
import com.hotel.repo.HotelRepo;
import com.hotel.repo.RoomRepo;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

	private final RoomRepo roomRepo;

	private final HotelRepo hotelRepo;

	public RoomController(RoomRepo roomRepo, HotelRepo hotelRepo) {
		this.roomRepo = roomRepo;
		this.hotelRepo = hotelRepo;
	}

	@PostMapping("/{hotelId}")
	public ResponseEntity<String> save(@PathVariable Long hotelId, @RequestBody RoomDTO roomDTO) {
		Hotel hotel = hotelRepo.findById(hotelId).orElseThrow(()->new RuntimeException("Hotel Not Found"));
		Room room = new  Room();
		room.setHotel(hotel);
		room.setPrice(roomDTO.getPrice());
		room.setRoomType(roomDTO.getRoomType());
		return ResponseEntity.status(HttpStatus.CREATED).body("Room added with id : " + roomRepo.save(room).getId());
	}

	@GetMapping("/{hotelId}")
	public ResponseEntity<List<Room>> getByHotelAvailableRooms(@PathVariable Long hotelId) {
		return ResponseEntity.ok(roomRepo.findByHotelId(hotelId));
	}

}
