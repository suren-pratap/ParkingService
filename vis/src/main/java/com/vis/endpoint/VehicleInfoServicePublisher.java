package com.vis.endpoint;
 
import javax.xml.ws.Endpoint;

import com.vis.ws.VehicleInfoServiceImpl;
 
public class VehicleInfoServicePublisher{
 
	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:9999/ws/vis", new VehicleInfoServiceImpl());
	   System.out.println("VehicleInfoService Published!");
    }
 
}