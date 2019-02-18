package com.pls.model;

public class Car extends Vehicle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Car(String number) {
		vehicleType = VehicleType.CAR;
		this.number = number;
	}

	public boolean canFitInSpot(ParkingSpot parkingSpot) {
		// checks if the spot is for a car
		return parkingSpot.getVehicleType() == VehicleType.CAR|| parkingSpot.getVehicleType() == VehicleType.BUS;
	}

	@Override
	public String toString() {
		return "Car [number=" + number + ", vehicleType=" + vehicleType + ", color=" + color + ", name=" + name + "]";
	}
	
}
