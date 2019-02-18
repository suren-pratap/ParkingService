package com.pls.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pls.exceptions.VehicleNotFoundException;
import com.pls.model.ParkUnparkRequest;
import com.pls.service.ParkingService;

@RestController
@RequestMapping("/pls")
public class ParkingController {

	@Autowired
	private ParkingService parkingService;

	private static final Logger LOGGER = LogManager.getLogger(ParkingController.class);

	@PostMapping("/park")
	public ResponseEntity<String> parkVehicle(@RequestBody ParkUnparkRequest parkkRequest) {
		String responseEntity;
		try {
			if (null != parkkRequest && parkkRequest.getVehicleNumber() != null) {
				responseEntity = parkingService.park(parkkRequest.getVehicleNumber());
				return ResponseEntity.accepted().body(responseEntity);
			}

		} catch (VehicleNotFoundException e) {
			LOGGER.error("Vehcile details are not available :", e);
		}

		return null;
	}

	@PostMapping("/unpark")
	public ResponseEntity<String> unParkVehicle(@RequestBody ParkUnparkRequest unParkRequest) {

		String responseEntity;
		if (null != unParkRequest && unParkRequest.getVehicleNumber() != null) {
			responseEntity = parkingService.unPark(unParkRequest.getVehicleNumber());
			return ResponseEntity.accepted().body(responseEntity);
		}

		return ResponseEntity.accepted().body(null);
	}

}
