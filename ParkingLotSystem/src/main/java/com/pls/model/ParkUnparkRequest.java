package com.pls.model;

import java.io.Serializable;

public class ParkUnparkRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String vehicleNumber;

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	@Override
	public String toString() {
		return "ParkUnparkRequest [vehicleNumber=" + vehicleNumber + "]";
	}
	
	

}
