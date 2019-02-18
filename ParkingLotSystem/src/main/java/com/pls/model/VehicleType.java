package com.pls.model;

public enum VehicleType {
	BIKE(1), CAR(2), BUS(4);

	private final int spotNeeded;

	VehicleType(int spotNeeded) {
		this.spotNeeded = spotNeeded;
	}

	public int getSpotNeeded() {
		return this.spotNeeded;
	}
}