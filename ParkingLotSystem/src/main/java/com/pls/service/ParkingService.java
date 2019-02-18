package com.pls.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pls.exceptions.VehicleNotFoundException;
import com.pls.helper.Level;
import com.pls.model.ParkingResponse;
import com.pls.model.ParkingSpot;
import com.pls.model.ParkingStatus;
import com.pls.model.Vehicle;
import com.pls.utils.Constants;
import com.pls.utils.ConversionUtils;

@Component
public class ParkingService {
	private List<Level> parkingLevelList;

	@Autowired
	private VehicleInfoHelper vehicleInfoHelper;

	private static final Logger LOGGER = LogManager.getLogger(ParkingService.class);

	public ParkingService() {

		parkingLevelList = new ArrayList<>(Constants.NUM_OF_PARKING_LEVELS);

		for (int i = 0; i < Constants.NUM_OF_PARKING_LEVELS; i++) {

			Level level = new Level(String.valueOf(i));
			parkingLevelList.add(level);
			System.out.println("Level " + i + " created with " + level.getAvailableSpots() + " " + "spots");
		}

	}

	public List<Level> getParkingLevelList() {
		return parkingLevelList;
	}

	private List<ParkingSpot> parkVehicle(Vehicle vehicle) {

		boolean parked = false;

		for (int level = 0; level < parkingLevelList.size(); level++) {

			if (!parked
					&& parkingLevelList.get(level).getAvailableSpots() >= vehicle.getVehicleType().getSpotNeeded()) {

				List<ParkingSpot> allotedParkingSlots = parkingLevelList.get(level)
						.allocateParkingSpots(parkingLevelList.get(level), vehicle);

				DataService.saveVehicleParkingDetails(vehicle, allotedParkingSlots);

				String str = "";

				for (int i = 0; i < allotedParkingSlots.size(); i++) {
					str = str + allotedParkingSlots.get(i).getLevelId() + allotedParkingSlots.get(i).getRowId()
							+ allotedParkingSlots.get(i).getSpotId();
					if (i + 1 != allotedParkingSlots.size()) {
						str = str + "|";
					}

				}

				System.out.println("Vehicle :" + vehicle.number + " parked at :" + str);
				// +
				// allotedParkingSlots.stream().map(ParkingSpot::getSpotId,).collect(Collectors.joining(",
				// ")));
				parkingLevelList.get(level).setAvailableSpots();
				return allotedParkingSlots;
			}
		}
		System.out.println("PARKING FULL");
		return null;
	}

	private List<ParkingSpot> unparkVehicle(String vehicleNumber) {

		List<ParkingSpot> parkingSpotList = DataService.getVehiclewiseParkingDetail(vehicleNumber);

		String levelId = null;
		String[] spotIds = new String[parkingSpotList.size()];
		String[] rowIds = new String[parkingSpotList.size()];
		for (int i = 0; i < parkingSpotList.size(); i++) {
			levelId = parkingSpotList.get(i).getLevelId();
			spotIds[i] = parkingSpotList.get(i).getSpotId();
			rowIds[i] = parkingSpotList.get(i).getRowId();
			parkingSpotList.get(i).setFree(true);
			parkingSpotList.get(i).setVehicle(null);
		}

		System.out.println("Vehicle: " + vehicleNumber + " unparked from level" + levelId + " rowId:"
				+ Arrays.toString(rowIds) + " spotId:" + Arrays.toString(spotIds));

		return parkingSpotList;
	}

	public String park(String vehicleNumber) throws VehicleNotFoundException {

		// VehicleInfoHelper vehicleInfoHelper2 =new VehicleInfoHelper();
		Vehicle vehicle = vehicleInfoHelper.getVehicleDetails(vehicleNumber);
		if (null == vehicle) {
			throw new VehicleNotFoundException();
		}
		List<ParkingSpot> parkingDetails = parkVehicle(vehicle);

		return createParkingResponse(vehicleNumber, parkingDetails);

	}

	private String createParkingResponse(String vehicleNumber, List<ParkingSpot> parkingDetails) {
		ParkingResponse parkingResponse = new ParkingResponse();
		parkingResponse.setVehicleNumber(vehicleNumber);
		if (!CollectionUtils.isEmpty(parkingDetails) && parkingDetails.size() > 0) {
			parkingResponse.setParkingStatus(ParkingStatus.P);
			parkingResponse.setMessage("Successfuly parked!");

			String parkingLocation = "";

			for (int i = 0; i < parkingDetails.size(); i++) {
				parkingLocation = parkingLocation + parkingDetails.get(i).getLevelId()
						+ parkingDetails.get(i).getRowId() + parkingDetails.get(i).getSpotId();
				if (i + 1 != parkingDetails.size()) {
					parkingLocation = parkingLocation + "|";
				}

			}
			parkingResponse.setParkingLocation(parkingLocation);
		} else {
			parkingResponse.setParkingStatus(ParkingStatus.FTP);
			parkingResponse.setMessage("Unable to park!");
		}
		try {
			String responseString = ConversionUtils.getJsonString(parkingResponse);
			return responseString;
		} catch (JsonProcessingException e) {
			LOGGER.error("Unable to parse object into json format", e);
		}
		return null;
	}

	public String unPark(String vehicleNumber) {
		List<ParkingSpot> parkingDetails = DataService.getVehiclewiseParkingDetail(vehicleNumber);
		ParkingStatus parkingStatus = ParkingStatus.VNA;
		if (!CollectionUtils.isEmpty(parkingDetails)) {
			int spotSize = parkingDetails.size();

			List<ParkingSpot> unParkDetails = unparkVehicle(vehicleNumber);

			int freeCount = (int) unParkDetails.stream().filter(obj -> obj.isFree()).count();

			parkingStatus = freeCount == spotSize ? ParkingStatus.UNP : ParkingStatus.FTUNP;
			DataService.resetParkingSpotDetails(vehicleNumber);

		}
		String responseEntity = createUnparkResponse(vehicleNumber, parkingStatus);
		return responseEntity;
	}

	private String createUnparkResponse(String vehicleNumber, ParkingStatus parkingStatus) {
		ParkingResponse parkingResponse = new ParkingResponse();
		parkingResponse.setVehicleNumber(vehicleNumber);
		parkingResponse.setParkingStatus(parkingStatus);
		if (parkingStatus.equals(ParkingStatus.VNA)) {
			parkingResponse.setMessage(parkingStatus.getStatus());
		} else {
			parkingResponse.setMessage("Successfuly unparked!");
		}
		try {
			String responseString = ConversionUtils.getJsonString(parkingResponse);
			return responseString;
		} catch (JsonProcessingException e) {
			LOGGER.error("Unable to parse object into json format", e);
		}
		return null;

	}

}
