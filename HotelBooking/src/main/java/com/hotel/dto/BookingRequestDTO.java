package com.hotel.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class BookingRequestDTO {

	private Long userId;
	private List<Long> roomIds;
	private LocalDate checkIn;
	private LocalDate checkOut;

}
