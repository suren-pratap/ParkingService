package com.pls.model;

public class Bus extends Vehicle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Bus(String number) {
		vehicleType = VehicleType.BUS;
		this.number = number;
	}

	public boolean canFitInSpot(ParkingSpot parkingSpot) {
		// checks if the spot is for a car
		return parkingSpot.getVehicleType() == VehicleType.CAR;
	}

	@Override
	public String toString() {
		return "Bus [number=" + number + ", vehicleType=" + vehicleType + ", color=" + color + ", name=" + name + "]";
	}
	
}
