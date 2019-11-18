package com.Spring.Boot.Crud.api.service;

import java.util.List;

import com.Spring.Boot.Crud.api.entity.Booking;

public interface BookingService {

	Booking saveBooking(Booking booking);
	
	Booking updateBooking(Booking booking);
	
	List<Booking> getBookingList();
	
	Booking getBooking(Long bookingId);
	
	void deleteBooking(Long bookingId);
		
}
