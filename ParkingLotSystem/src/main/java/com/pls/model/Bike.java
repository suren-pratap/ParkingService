
package com.pls.model;

public class Bike extends Vehicle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Bike(String vehicleNumber) {
		vehicleType = VehicleType.BIKE;
		this.number = vehicleNumber;

	}

	public boolean canFitInSpot(ParkingSpot parkingSpot) {
		// checks if the spot is a compact, motorcycle or a large

		return parkingSpot.getVehicleType() == VehicleType.CAR || parkingSpot.getVehicleType() == VehicleType.BIKE;

	}

	@Override
	public String toString() {
		return "Bike [number=" + number + ", vehicleType=" + vehicleType + ", color=" + color + ", name=" + name + "]";
	}
	
	
}
