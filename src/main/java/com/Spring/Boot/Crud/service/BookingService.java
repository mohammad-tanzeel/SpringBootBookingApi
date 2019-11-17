package com.Spring.Boot.Crud.service;

import java.util.List;
import com.Spring.Boot.Crud.entity.Booking;

public interface BookingService {

	Booking saveBooking(Booking booking);
	
	Booking updateBooking(Booking booking);
	
	List<Booking> getBookingList();
	
	Booking getBooking(Long bookingId);
	
	void deleteBooking(Long bookingId);
		
}
