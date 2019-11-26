package com.Spring.Boot.Crud.api.service;

public class BookingServiceException extends Exception {

	private static final long serialVersionUID = -470180507998010368L;

	public BookingServiceException() {
		super();
	}

	public BookingServiceException(final String message) {
		super(message);
	}
}