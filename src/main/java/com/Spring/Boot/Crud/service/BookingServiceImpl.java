package com.Spring.Boot.Crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Boot.Crud.dao.BookingDao;
import com.Spring.Boot.Crud.entity.Booking;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingdao;
	
	@Override
	public Booking saveBooking(Booking booking) {
		// TODO Auto-generated method stub		
		return bookingdao.save(booking);
	}

	@Override
	public Booking updateBooking(Booking booking) {
		// TODO Auto-generated method stub
		return bookingdao.saveAndFlush(booking);
	}

	@Override
	public List<Booking> getBookingList() {
		// TODO Auto-generated method stub
		return bookingdao.findAll();
	}

	@Override
	public Booking getBooking(Long bookingId) {
		// TODO Auto-generated method stub
		return bookingdao.findById(bookingId).get();
	}

	@Override
	public void deleteBooking(Long bookingId) {
		// TODO Auto-generated method stub
		bookingdao.deleteById(bookingId);
	}

}
