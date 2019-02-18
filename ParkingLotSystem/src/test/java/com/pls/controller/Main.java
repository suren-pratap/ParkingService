package com.pls.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pls.exceptions.VehicleNotFoundException;
import com.pls.model.Bike;
import com.pls.model.Car;
import com.pls.model.ParkUnparkRequest;
import com.pls.model.ParkingResponse;
import com.pls.model.ParkingStatus;
import com.pls.service.ParkingService;
import com.pls.utils.ConversionUtils;

public class Main {

	public static void main(String[] args) throws JsonProcessingException, VehicleNotFoundException {

		/*
		 * ParkingService parkingLot = new ParkingService();
		 * 
		 * Car c1 = new Car("CAR1234"); Bike c2 = new Bike("BIKE4556"); Car c3 = new
		 * Car("CAR1680"); Bike c4 = new Bike("BIKE0789"); Car c5 = new Car("CAR1789");
		 * 
		 * parkingLot.park("CAR-0001"); parkingLot.parkVehicle(c2);
		 * parkingLot.parkVehicle(c3);
		 * 
		 * //parkingLot.unpark(c2); parkingLot.parkVehicle(c4);
		 * parkingLot.parkVehicle(c5);
		 * 
		 * 
		 * ParkingResponse parkingResponse=new ParkingResponse();
		 * parkingResponse.setMessage("Hi");
		 * parkingResponse.setParkingStatus(ParkingStatus.P);
		 * 
		 * System.out.println(ParkingStatus.P.getStatus());
		 * 
		 * System.out.println(ConversionUtils.getJsonString(parkingResponse));
		 */
		ParkUnparkRequest parkUnparkRequest = new ParkUnparkRequest();
		parkUnparkRequest.setVehicleNumber("CAR-0001");
		System.out.println(ConversionUtils.getJsonString(parkUnparkRequest));
	}
}
