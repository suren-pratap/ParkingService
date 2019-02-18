
package com.vis.model;

import java.io.Serializable;

public class Vehicle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String number;
	public String vehicleType;
	public String color;
	public String name;

	public Vehicle(String number, String vehicleType, String color, String name) {
		this.number = number;
		this.name = name;
		this.vehicleType = vehicleType;
		this.color = color;

	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vehicle [number=" + number + ", vehicleType=" + vehicleType + ", color=" + color + ", name=" + name
				+ "]";
	}

}