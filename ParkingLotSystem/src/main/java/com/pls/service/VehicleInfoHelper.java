package com.pls.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.pls.controller.ParkingController;
import com.pls.model.Vehicle;
import com.pls.model.VehicleType;

@Component
public class VehicleInfoHelper {

	private static final Logger LOGGER = LogManager.getLogger(ParkingController.class);

	public Vehicle getVehicleDetails(String vehicleNumber) {

		Vehicle vehicle = DataService.getVehicleInfoFromCache(vehicleNumber);
		if (null != vehicle) {
			LOGGER.info(vehicle + " found in VehicleInfoCache");
			return vehicle;
		} else {
			return getDetailsFromVIS(vehicleNumber);
		}

	}

	private static Vehicle getDetailsFromVIS(String vehicleNumber) {
		String str = vehicleNumber;
		try {
			HttpResponse<String> response = Unirest.post("http://localhost:9999/ws/vis?wsdl=")
					.header("Content-Type", "text/xml")
					.body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://ws.vis.com/\">\r\n   <soapenv:Header/>\r\n   <soapenv:Body>\r\n      <ws:getVehicleDetails>\r\n         <!--Optional:-->\r\n         <arg0>"
							+ str
							+ "</arg0>\r\n      </ws:getVehicleDetails>\r\n   </soapenv:Body>\r\n</soapenv:Envelope>")
					// .body(requestBody)
					.asString();
			LOGGER.debug(response.getBody());
			Vehicle vehicle = parseResponse(response);
			if(null!=vehicle) {
				DataService.saveInVehicleInfoCache(vehicleNumber, vehicle);
			}
			return vehicle;

		} catch (UnirestException e) {

			e.printStackTrace();
		}

		return null;

	}

	private static Vehicle parseResponse(HttpResponse<String> response) {
		try {
			JSONObject data = XML.toJSONObject(response.getBody());
			if (data.getJSONObject("S:Envelope").getJSONObject("S:Body").getJSONObject("ns2:getVehicleDetailsResponse")
					.has("return")) {
				String responseString = (String) data.getJSONObject("S:Envelope").getJSONObject("S:Body")
						.getJSONObject("ns2:getVehicleDetailsResponse").get("return");
				ObjectMapper mapper = new ObjectMapper();
				Vehicle vehicle = mapper.readValue(responseString, Vehicle.class);
				LOGGER.debug(data);
				LOGGER.debug(data.getJSONObject("S:Envelope").getJSONObject("S:Body")
						.getJSONObject("ns2:getVehicleDetailsResponse").get("return"));

				LOGGER.debug(vehicle);
				LOGGER.debug(VehicleType.CAR.equals(vehicle.vehicleType));
				return vehicle;

			}
		} catch (JSONException | IOException e) {
			LOGGER.error("Exception Occurred", e);
			e.printStackTrace();
		}
		return null;
	}

}
