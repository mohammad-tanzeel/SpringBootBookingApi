package com.Spring.Boot.Crud.api.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.Spring.Boot.Crud.api.DateHandler.CheckDateFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bookings")
//@Setter
//@Getter
public class Booking {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
	
	@Column(name = "source")
	@NotEmpty(message = "Please provide a source")
	private String source;
	
	@Column(name = "destination")
	@NotEmpty(message = "Please provide a destination")
	private String destination;
	
//	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@CheckDateFormat(pattern="dd/MM/yyyy")
	private String startDate = null;
	
	@Column(name = "end_date")
	private String endDate;
	
	@Column(name = "passengers")
	private String passengers;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPassengers() {
		return passengers;
	}

	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}
	
}

