package com.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.entity.Room;
import java.util.List;

public interface RoomRepo extends JpaRepository<Room, Long> {

	List<Room> findByHotelIdAndAvailabilityTrue(Long hotelId);
}
