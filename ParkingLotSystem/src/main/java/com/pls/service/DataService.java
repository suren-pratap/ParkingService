package com.pls.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pls.model.ParkingSpot;
import com.pls.model.Vehicle;

public class DataService {

	/*
	 * private static final int NUM_LEVELS = Constants.NUM_OF_PARKING_LEVELS;
	 * private static final int NUM_OF_ROW_PER_LEVEL = 2; private static final int
	 * NUM_OF_SPOT_PER_ROW = Constants.NUM_OF_SPOT_PER_ROW;
	 */

	// Level wise parking detail
	private static Map<String, List<ParkingSpot>> levelWiseParkingMap = new HashMap<String, List<ParkingSpot>>();

	// Vehicle wise parking detail
	private static Map<String, ParkingSpot> vehiclWiseParkingMap = new HashMap<String, ParkingSpot>();

	private static Map<String, List<ParkingSpot>> vehiclWiseParkingDetails = new HashMap<>();

	private static Map<String, Vehicle> vehicleInfoCache = new HashMap<>();

	/*
	 * static { List<ParkingSpot> parkingSpotList = null; for (int level = 0; level
	 * < NUM_LEVELS; level++) { parkingSpotList = new ArrayList<ParkingSpot>(); int
	 * largeSpots = NUM_OF_SPOT_PER_ROW / 4; int bikeSpots = NUM_OF_SPOT_PER_ROW /
	 * 4; int compactSpots = NUM_OF_SPOT_PER_ROW - largeSpots - bikeSpots;
	 * 
	 * for (int row = 0; row < NUM_OF_ROW_PER_LEVEL; row++) { for (int spot = 0;
	 * spot < NUM_OF_SPOT_PER_ROW; spot++) { VehicleType vehicleType =
	 * VehicleType.BIKE; // Default if (spot < largeSpots + compactSpots) {
	 * vehicleType = VehicleType.CAR; } parkingSpotList.add(new ParkingSpot("L" +
	 * level, "R" + row, "S" + spot, vehicleType)); } } levelWiseParkingMap.put("L"
	 * + level, parkingSpotList); } }
	 */

	public static Map<String, List<ParkingSpot>> getLevelWiseParkingDetail() {
		return levelWiseParkingMap;
	}

	public static ParkingSpot getVehiclewiseParkingDetails(String vehicleNumber) {

		return vehiclWiseParkingMap.get(vehicleNumber);

	}

	public static List<ParkingSpot> getVehiclewiseParkingDetail(String vehicleNumber) {

		return vehiclWiseParkingDetails.get(vehicleNumber);

	}

	public static ParkingSpot saveVehicleParkingDetails(ParkingSpot parkingSpot, Vehicle vehicle) {
		String vehicleId = vehicle.getNumber();
		parkingSpot.setVehicle(vehicle);
		parkingSpot.setFree(false);
		return vehiclWiseParkingMap.put(vehicleId, parkingSpot);

	}

	public static List<ParkingSpot> saveVehicleParkingDetails(Vehicle vehicle, List<ParkingSpot> parkingSpotList) {
		String vehicleId = vehicle.getNumber();

		return vehiclWiseParkingDetails.put(vehicleId, parkingSpotList);

	}

	public static void resetParkingSpotDetails(ParkingSpot parkingSpot, Vehicle vehicle) {
		String vehicleId = vehicle.getNumber();
		parkingSpot.setVehicle(null);
		parkingSpot.setFree(true);
		vehiclWiseParkingMap.remove(vehicleId);

	}

	public static void resetParkingSpotDetails(String vehicleNumber) {
		vehiclWiseParkingDetails.remove(vehicleNumber);

	}

	public static void saveInVehicleInfoCache(String vehicleNumber, Vehicle vehicle) {
		vehicleInfoCache.put(vehicleNumber, vehicle);
	}

	public static Vehicle getVehicleInfoFromCache(String vehicleNumber) {
		return vehicleInfoCache.get(vehicleNumber);
	}

}
