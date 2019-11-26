package com.Spring.Boot.Crud.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Boot.Crud.api.entity.Booking;
import com.Spring.Boot.Crud.api.service.BookingService;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@RequestMapping("/getdata")
	public String getData() {
		return "Test Data";
	}
	
	@PostMapping("/customer")
	@ResponseBody
    public ResponseEntity<?> createCustomer(@Valid @RequestBody Booking booking){

        HttpHeaders responseHeader = new HttpHeaders();
        return new ResponseEntity<>(booking, responseHeader, HttpStatus.CREATED);
    }
	
	@PostMapping("/save")
	public Booking save(@RequestBody Booking booking) {
		
		return bookingService.saveBooking(booking);
	}
	
	@PutMapping("/update")
	public Booking update(@RequestBody Booking booking) {
	
		return bookingService.updateBooking(booking);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Booking>> getAllBooking() {
		List<Booking> booking = bookingService.getBookingList();
        if (booking.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
 
        return new ResponseEntity<List<Booking>>(booking, HttpStatus.OK);
 
//		return bookingService.getBookingList();
	}
	
	@GetMapping("/by/bookingId")
	public Booking getBooking(@PathVariable(name = "bookingId") Long bookingId) {
		return bookingService.getBooking(bookingId);
	}
	
	@DeleteMapping("/delete/{bookingId}")
	public void deleteBooking(@PathVariable(name="BookingId") Long bookingId) {
		bookingService.deleteBooking(bookingId);
	}
	
}
