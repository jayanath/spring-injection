package com.jayanath.spring;

import java.util.List;

import org.apache.log4j.Logger;

import com.jayanath.spring.services.Service;

/**
 * Class to represent a hotel room
 * @author jayanath.amaranayake
 *
 */
public class Room {
	
	/** Logger instance for this class */
	static Logger logger = Logger.getLogger(Room.class);
	
	/** List of services*/
	private List<Service> serviceList;
	
	
	/**
	 * Calculate the room charges
	 * @return the room charge
	 */
	public double calculateRoomCharge() {
		double total = 0;
		for (Service service : serviceList) {
			total = total + service.calculateServiceCharge();
		}
		
		return total;
	}
	
	/**
	 * Returns a string of used service names
	 * @return a list of services
	 */
	public String getUsedServiceNames() {
		StringBuffer sb = new StringBuffer();
		
		for (Service service : serviceList) {
			sb.append(service.printServiceInfo());
			sb.append("  ");
		}
		
		return sb.toString();
	}

	/**
	 * Sets the service list
	 * @param serviceList
	 */
	public void setServiceList(List<Service> serviceList) {
		this.serviceList = serviceList;
		logger.info("INJECTED the list of services in to the Room");
	}

	
}
