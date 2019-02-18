package com.vis.ws;
 
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vis.repo.VehicleRepository;
 
@WebService(endpointInterface = "com.vis.ws.VehicleInfoService")
public class VehicleInfoServiceImpl implements VehicleInfoService{
 
	
	
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}

	public String getVehicleDetails(String vehicleNumber) {
		
		return VehicleRepository.getVehicleDetails(vehicleNumber);
	}
 
}