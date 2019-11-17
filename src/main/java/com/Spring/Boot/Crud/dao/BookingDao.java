package com.Spring.Boot.Crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.Boot.Crud.entity.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, Long> {

}
