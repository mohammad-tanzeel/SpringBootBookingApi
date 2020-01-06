package com.Spring.Boot.Crud.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.Spring.Boot.Crud.api.entity.BookingDTO;
//import com.Spring.Boot.Crud.api.exception.FieldNotFoundException1;
import com.Spring.Boot.Crud.api.service.BookingService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
	
	// Save
    @PostMapping("/savebooking")
    Booking savebooking(@Valid @RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }
	
//	@PostMapping("/getbooking")
//	@ResponseBody
//    public Booking getBooking() throws FieldNotFoundException{
//
//		try {
//			Booking book = (Booking) bookingService.getBookingList();
//			if (emp == null) {
//				throw new FieldNotFoundException("Employee not found");
//			}
//			return emp;
//		} catch (FieldNotFoundException e) {
//			throw new FieldNotFoundException("Internal Server Exception while getting exception");
//		}
//    }
    //@CrossOrigin(origins = "http://localhost:4200")
   @CrossOrigin
	@PostMapping("/save")
	public Booking save(@RequestBody Booking booking, HttpServletRequest request) {
		System.out.println(booking);
		String userAgent = request.getHeader("user-agent");
		System.out.println("Headers values"+userAgent);
//		logger.info("whatever you want "+userAgent);
		return bookingService.saveBooking(booking);
	}
	
	@PutMapping("/update")
	public Booking update(@RequestBody Booking booking) {
	
		return bookingService.updateBooking(booking);
	}
	
//	@CrossOrigin(origins = "http://localhost:9091")
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
	
	@GetMapping("/getspecific")
	public ResponseEntity<List<BookingDTO>> getSpecificBooking() {
		List<BookingDTO> bookingdto = bookingService.getBookingListSpecific();
        if (bookingdto.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
 
        return new ResponseEntity<List<BookingDTO>>(bookingdto, HttpStatus.OK);
 
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
