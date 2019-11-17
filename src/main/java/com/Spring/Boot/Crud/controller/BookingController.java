package com.Spring.Boot.Crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Boot.Crud.entity.Booking;
import com.Spring.Boot.Crud.service.BookingServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/tour")
public class BookingController {

//	@Autowired
//	private BookingServiceImpl bookingService;
	
	@RequestMapping("/getdata")
	public String getData() {
		return "Test Data";
	}
	
//	@PostMapping("/save")
//	public Booking save(@RequestBody Booking booking) {
//		
//		return bookingService.saveBooking(booking);
//	}
//	
//	@PutMapping("/update")
//	public Booking update(@RequestBody Booking booking) {
//	
//		return bookingService.updateBooking(booking);
//	}
//	
//	@GetMapping("/all")
//	public List<Booking> getAllBooking() {
//		return bookingService.getBookingList();
//	}
//	
//	@DeleteMapping("/delete/{bookingId}")
//	public void deleteBooking(@PathVariable(name="BookingId") Long bookingId) {
//		bookingService.deleteBooking(bookingId);
//	}
	
}
