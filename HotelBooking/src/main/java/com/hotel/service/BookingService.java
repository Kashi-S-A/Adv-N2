package com.hotel.service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.dto.BookingRequestDTO;
import com.hotel.entity.Booking;
import com.hotel.entity.Room;
import com.hotel.entity.User;
import com.hotel.repo.BookingRepo;
import com.hotel.repo.RoomRepo;
import com.hotel.repo.UserRepo;

@Service
public class BookingService {

	private final BookingRepo bookingRepo;

	private final RoomRepo roomRepo;

	private final UserRepo userRepo;

	public BookingService(BookingRepo bookingRepo, RoomRepo roomRepo, UserRepo userRepo) {
		this.bookingRepo = bookingRepo;
		this.roomRepo = roomRepo;
		this.userRepo = userRepo;
	}

	public String createBooking(BookingRequestDTO bookingDto) {
		long days = ChronoUnit.DAYS.between(bookingDto.getCheckIn(), bookingDto.getCheckOut());

		if (days <= 0)
			throw new RuntimeException("Enter valid date");
		// check for user
		User user = userRepo.findById(bookingDto.getUserId()).orElseThrow(() -> new RuntimeException("Use Not found"));
		// Rooms available
		double priceOfAllRooms = 0;

		List<Room> rooms = roomRepo.findAllById(bookingDto.getRoomIds());

		for (Room room : rooms) {
			if (!room.getAvailability()) {
				throw new RuntimeException("Room with id : " + room.getId() + " is not available");
			}
		}

//		for (Room room : rooms) {
//			if ((room.getAvail().getAvailable()
//					&& room.getAvail().getDate().toString().equals(bookingDto.getCheckIn().toString()))) {
//				Stream<LocalDate> dates = bookingDto.getCheckIn().datesUntil(bookingDto.getCheckOut());
//				throw new RuntimeException("Room with id : " + room.getId() + " is not available");
//			}
//			priceOfAllRooms += room.getPrice();
//		}
		// Days

		// totalAmount

		Double totalPrice = priceOfAllRooms * days;

		// service for payment

		// if pay is succ save booking -> confirmed
		for (Room room : rooms) {
			room.setAvailability(false);
			roomRepo.save(room);
		}

		Booking booking = new Booking();
		booking.setUser(user);
		booking.setRooms(rooms);
		booking.setCheckIn(bookingDto.getCheckIn());
		booking.setCheckout(bookingDto.getCheckOut());
		booking.setTotalAmount(totalPrice);
		booking.setStatus("CONFIRMED");

		return "Booking Confirmed Your Booking Id is : " + bookingRepo.save(booking).getId();

	}

	public Optional<Booking> findById(Long id) {
		return bookingRepo.findById(id);
	}

	public void cancelBooking(Long id) {
		Booking booking = bookingRepo.findById(id).orElseThrow(() -> new RuntimeException("Booking Not Found"));
		if (!booking.getStatus().equals("CONFIRMED")) {
			throw new RuntimeException("Already Canceled");
		} else {
			booking.setStatus("CANCELED");
		}
		List<Room> rooms = booking.getRooms();
		for (Room room : rooms) {
			room.setAvailability(true);
			roomRepo.save(room);
		}
		// repay the money
		Double totalAmount = booking.getTotalAmount();
		bookingRepo.save(booking);
	}

}
