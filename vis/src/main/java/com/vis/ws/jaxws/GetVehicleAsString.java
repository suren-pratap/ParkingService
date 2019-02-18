
package com.vis.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getVehicleAsString", namespace = "http://ws.vis.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getVehicleAsString", namespace = "http://ws.vis.com/")
public class GetVehicleAsString {

	@XmlElement(name = "arg0", namespace = "")
	private String arg0;

	public String getArg0() {
		return this.arg0;
	}

	public void setArg0(String arg0) {
		this.arg0 = arg0;
	}

}
