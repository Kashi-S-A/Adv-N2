package com.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.entity.Room;

public interface RoomRepo extends JpaRepository<Room, Long> {

}
