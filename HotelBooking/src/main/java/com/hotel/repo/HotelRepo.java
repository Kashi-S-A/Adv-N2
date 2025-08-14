package com.hotel.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Long> {

	List<Hotel> findByNameContainingAllIgnoreCase(String name);

//	List<Hotel> findByLocationContainingAllIgnoreCaseOrNameContainingAllIgnoreCase(String name,String Location);
}
