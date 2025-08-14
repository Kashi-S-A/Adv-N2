package com.hotel.service;

import java.time.LocalDate;
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

import jakarta.transaction.Transactional;

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

		User user = userRepo.findById(bookingDto.getUserId()).orElseThrow(() -> new RuntimeException("User Not found"));

		List<Booking> conflicts = bookingRepo.findConflictingBookings(bookingDto.getRoomIds(), bookingDto.getCheckIn(),
				bookingDto.getCheckOut());

		if (!conflicts.isEmpty()) {
			throw new RuntimeException("One or more rooms are already booked for these dates");
		}

		List<Room> rooms = roomRepo.findAllById(bookingDto.getRoomIds());
		double totalPrice = rooms.stream().mapToDouble(Room::getPrice).sum() * days;

		Booking booking = new Booking();
		booking.setUser(user);
		booking.setRooms(rooms);
		booking.setCheckIn(bookingDto.getCheckIn());
		booking.setCheckout(bookingDto.getCheckOut());
		booking.setTotalAmount(totalPrice);
		booking.setStatus("CONFIRMED");

		bookingRepo.save(booking);

		return "Booking Confirmed. Booking_ID: " + booking.getId();
	}

	public Optional<Booking> findById(Long id) {
		return bookingRepo.findById(id);
	}

	@Transactional
	public String cancelBooking(Long bookingId) {
		Booking booking = bookingRepo.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));

		// Check if already canceled
		if ("CANCELLED".equalsIgnoreCase(booking.getStatus())) {
			throw new RuntimeException("Booking is already cancelled");
		}

		// Optional: Prevent canceling if check-in has already started
		if (!LocalDate.now().isBefore(booking.getCheckIn())) {
			throw new RuntimeException("Cannot cancel after check-in date");
		}

		// Update booking status
		booking.setStatus("CANCELLED");
		Booking saved = bookingRepo.save(booking);
		
		Double totalAmount = saved.getTotalAmount();//return this amount back to the customer

		return "Booking ID " + bookingId + " has been cancelled successfully.";
	}

}
