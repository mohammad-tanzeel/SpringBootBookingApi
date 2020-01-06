package com.Spring.Boot.Crud.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Spring.Boot.Crud.api.entity.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, Long> {
	
	
	List<Booking> findBookingBySourceStartingWith(String name);
	
	List<Booking> findBySourceAndDestination(String source, String destination);
}
