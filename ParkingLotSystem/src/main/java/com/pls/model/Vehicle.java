
package com.pls.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Vehicle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	public String number;
	public VehicleType vehicleType;
	public String color;
	public String name;

	
	
	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public String getColor() {
		return color;
	}

	public ArrayList<ParkingSpot> getParkingSpots() {
		return parkingSpots;
	}

	public void setParkingSpots(ArrayList<ParkingSpot> parkingSpots) {
		this.parkingSpots = parkingSpots;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void parkInSpot(ParkingSpot s) {
		parkingSpots.add(s);
	}

	@Override
	public String toString() {
		return "Vehicle [number=" + number + ", vehicleType=" + vehicleType
				+ ", color=" + color + ", name=" + name + "]";
	}

}