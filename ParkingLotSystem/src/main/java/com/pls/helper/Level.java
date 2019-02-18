
package com.pls.helper;

import java.util.ArrayList;
import java.util.List;

import com.pls.model.ParkingSpot;
import com.pls.model.Vehicle;
import com.pls.utils.Constants;

public class Level {
	private String levelId;
	private String rowId;
	private List<ParkingSpot> parkingSpotList; // number of spots in each level, including large, compact and motorcycle
												// size
	private int availableSpots = 0; // number of free spots
	private int occupiedSpots = 0;
	private static final int NUM_OF_ROW_PER_LEVEL = 2;
	private static final int NUM_OF_SPOT_PER_ROW = Constants.NUM_OF_SPOT_PER_ROW;

	public Level(String levelId) {
		this.levelId = levelId;
		parkingSpotList = new ArrayList<>();
		for (int row = 0; row < NUM_OF_ROW_PER_LEVEL; row++) {
			for (int spot = 0; spot < NUM_OF_SPOT_PER_ROW; spot++) {
				parkingSpotList.add(new ParkingSpot("L" + levelId, "R" + row, "S" + spot));
			}
		}
		this.availableSpots = (int) parkingSpotList.stream().filter(o -> o.isFree()).count();
		this.occupiedSpots = (int) parkingSpotList.stream().filter(o -> !o.isFree()).count();
		;
	}

	public List<ParkingSpot> getParkingSpotList() {
		return parkingSpotList;
	}

	public int getAvailableSpots() {
		return availableSpots;
	}

	public void setAvailableSpots() {
		this.availableSpots = (int) parkingSpotList.stream().filter(o -> o.isFree()).count();
	}

	public int getOccupiedSpots() {
		return occupiedSpots;
	}

	public void setOccupiedSpots() {
		this.occupiedSpots = (int) parkingSpotList.stream().filter(o -> !o.isFree()).count();
		;
	}

	public List<ParkingSpot> allocateParkingSpots(Level level, Vehicle vehicle) {

		List<ParkingSpot> parkingSpotList = level.getParkingSpotList();
		int spotRequired = vehicle.getVehicleType().getSpotNeeded();
		int count = 0;
		List<ParkingSpot> allocatedParkingSpotList = new ArrayList<>(spotRequired);
		for (int j = 0; j < parkingSpotList.size(); j++) {
			if (count < spotRequired && parkingSpotList.get(j).isFree()) {
				parkingSpotList.get(j).setVehicle(vehicle);
				parkingSpotList.get(j).setFree(false);
				allocatedParkingSpotList.add(parkingSpotList.get(j));
				count++;
			}
		}
		return allocatedParkingSpotList;

	}

}
