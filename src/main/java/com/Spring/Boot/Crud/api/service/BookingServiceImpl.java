package com.Spring.Boot.Crud.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Boot.Crud.api.dao.BookingDao;
import com.Spring.Boot.Crud.api.entity.Booking;
import com.Spring.Boot.Crud.api.entity.BookingDTO;

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
	public List<BookingDTO> getBookingListSpecific() {
		// TODO Auto-generated method stub
		List<Booking> bookingList= bookingdao.findAll();
		List<BookingDTO>  bookingDtoList = new ArrayList<> ();
		
		bookingList.forEach(data -> {
			BookingDTO dto = new BookingDTO();
			dto.setBookingId(data.getBookingId());
			dto.setSource("tanzeel"+ data.getSource());
			bookingDtoList.add(dto);
			
		} );
		return bookingDtoList;
		
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

	@Override
	public List<Booking> findBookingBySourceStartingWith(String name) {
		// TODO Auto-generated method stub
		
		return bookingdao.findBookingBySourceStartingWith(name);
	}

	@Override
	public List<Booking> findBySourceAndDestination(String source, String destination) {
		// TODO Auto-generated method stub
		return bookingdao.findBySourceAndDestination(source, destination);
	}

//	@Override
//	public List<Booking> findBookingBySource(String source) {
//		// TODO Auto-generated method stub
//		return bookingdao.findBookingBySource(source);
//	}
}
