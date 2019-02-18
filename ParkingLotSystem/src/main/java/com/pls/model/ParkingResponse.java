package com.pls.model;

import java.io.Serializable;

public class ParkingResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String vehicleNumber;
	private ParkingStatus parkingStatus;
	private String parkingLocation;
	private String message;

	

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public ParkingStatus getParkingStatus() {
		return parkingStatus;
	}

	public void setParkingStatus(ParkingStatus parkingStatus) {
		this.parkingStatus = parkingStatus;
	}

	public String getParkingLocation() {
		return parkingLocation;
	}

	public void setParkingLocation(String parkingLocation) {
		this.parkingLocation = parkingLocation;
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ParkingResponse [vehicleNumber=" + vehicleNumber + ", parkingStatus=" + parkingStatus.getStatus() + ", parkingLocation="
				+ parkingLocation + ", message=" + message + "]";
	}

	

}
