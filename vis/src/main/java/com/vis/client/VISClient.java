package com.vis.client;
 
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.vis.ws.VehicleInfoService;
 
public class VISClient{
 
	public static void main(String[] args) throws Exception {
 
		URL url = new URL("http://localhost:9999/ws/vis?wsdl");
 
        QName qname = new QName("http://ws.vis.com/", "VehicleInfoServiceImplService");
 
        Service service = Service.create(url, qname);
 
        VehicleInfoService hello = service.getPort(VehicleInfoService.class);
        
 
        System.out.println(hello.getVehicleDetails("CAR-0001"));
        
        
        
        
 
    }
 
}