package com.pls.model;

public enum ParkingStatus {
	P("PARKED"), UNP("UNPARKED"),FTP("FAILED TO PARK"),FTUNP("FAILED TO UNPARK"),VNA("Vehicle Not Available");

	private final String status;

	ParkingStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}
}