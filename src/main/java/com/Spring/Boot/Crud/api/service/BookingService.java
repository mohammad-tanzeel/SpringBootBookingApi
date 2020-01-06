package com.Spring.Boot.Crud.api.service;

import java.util.List;

import com.Spring.Boot.Crud.api.entity.Booking;
import com.Spring.Boot.Crud.api.entity.BookingDTO;

public interface BookingService {

	Booking saveBooking(Booking booking);
	
	Booking updateBooking(Booking booking);
	
	List<Booking> getBookingList();
	
	Booking getBooking(Long bookingId);
	
	void deleteBooking(Long bookingId);
	
//	List<Booking> findBookingBySource(String source);
	List<Booking> findBookingBySourceStartingWith(String name);
	
	List<Booking> findBySourceAndDestination(String source, String destination);

	List<BookingDTO> getBookingListSpecific();
	
}
