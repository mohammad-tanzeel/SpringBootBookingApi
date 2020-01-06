package com.Spring.Boot.Crud.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Spring.Boot.Crud.api.entity.Booking;
import com.Spring.Boot.Crud.api.service.BookingService;

@RestController
public class TestController {
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(value="/testparam/{source}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Booking>> method7(@PathVariable("source") String source){
		List<Booking> booking = bookingService.findBookingBySourceStartingWith(source);
        if (booking.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Booking>>(booking, HttpStatus.OK);
	}
	
	@RequestMapping(value="/testparam/{source}/{destination}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Booking>> method8(@PathVariable("source") String source, @PathVariable("destination") String destination){
		List<Booking> booking = bookingService.findBySourceAndDestination(source, destination);
        if (booking.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Booking>>(booking, HttpStatus.OK);
	}
	
	@RequestMapping("/callapi")
	public String getUsers()
	{
	    final String uri = "http://localhost:3000/user/1";

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    return result;
//	    System.out.println("Api Result="+result);
	}

}
