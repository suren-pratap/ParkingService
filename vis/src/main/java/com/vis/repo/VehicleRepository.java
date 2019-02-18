package com.vis.repo;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vis.model.Vehicle;

public class VehicleRepository {
	
	private static Map<String, String> repository=new HashMap<String, String>();
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	
	static {
		
		Vehicle car1=new Vehicle("CAR-0001","CAR", "BLUE","MARUTI SWIFT");		
		Vehicle car2=new Vehicle("CAR-0002","CAR", "RED","HONDA CITY");
		Vehicle car3=new Vehicle("CAR-0003","CAR", "YELLO","HYUNDAI VERNA");
		Vehicle car4=new Vehicle("CAR-0004","CAR", "GREEN","JEEP COMPASS");
		Vehicle car5=new Vehicle("CAR-0005","CAR", "WHITE","RENAULT DUSTER");
		
		
		Vehicle bike1=new Vehicle("BIKE-0001","BIKE", "BLUE","TVS START");
		Vehicle bike2=new Vehicle("BIKE-0002","BIKE", "GREEN","HONDA ACTIVA");
		Vehicle bike3=new Vehicle("BIKE-0003","BIKE", "RED","ROYAL ENFIELD");
		Vehicle bike4=new Vehicle("BIKE-0004","BIKE", "BLUE","YAMAHA RX100");
		Vehicle bike5=new Vehicle("BIKE-0005","BIKE", "BLACK","HERO SPLENDER");
		
		try {
			System.out.println(objectMapper.writeValueAsString(car1));
			repository.put(car1.number, objectMapper.writeValueAsString(car1));
			repository.put(car2.number, objectMapper.writeValueAsString(car2));
			repository.put(car3.number, objectMapper.writeValueAsString(car3));
			repository.put(car4.number, objectMapper.writeValueAsString(car4));
			repository.put(car5.number, objectMapper.writeValueAsString(car5));
			repository.put(bike1.number, objectMapper.writeValueAsString(bike1));
			repository.put(bike2.number, objectMapper.writeValueAsString(bike2));
			repository.put(bike3.number, objectMapper.writeValueAsString(bike3));
			repository.put(bike4.number, objectMapper.writeValueAsString(bike4));
			repository.put(bike5.number, objectMapper.writeValueAsString(bike5));
			System.out.println(repository);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getVehicleDetails(String vehicleNumber) {
		return repository.get(vehicleNumber);
	}
}
