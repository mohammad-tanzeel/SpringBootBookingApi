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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bookings")
@Setter
@Getter
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
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "passengers")
	private String passengers;
}

