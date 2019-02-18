
package com.pls.model;

import com.pls.model.Vehicle;
import com.pls.model.VehicleType;

public class ParkingSpot {
	private Vehicle vehicle;
	private VehicleType vehicleType;
	private String rowId;
	private String spotId;
	private String levelId;
	private boolean isFree;

	public ParkingSpot(String levelId, String rowId, String spotId, VehicleType vehicleType) {
		this.levelId = levelId;
		this.rowId = rowId;
		this.spotId = spotId;
		this.vehicleType = vehicleType;
		this.isFree = true;
	}

	public ParkingSpot(String levelId, String rowId, String spotId) {
		this.levelId = levelId;
		this.rowId = rowId;
		this.spotId = spotId;
		this.isFree = true;
	}

	public boolean isAvailable() {
		return vehicle == null;
	}

	public boolean isFree() {
		return isFree;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getSpotId() {
		return spotId;
	}

	public void setSpotId(String spotId) {
		this.spotId = spotId;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

}