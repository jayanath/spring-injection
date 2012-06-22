package com.jayanath.spring;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jayanath.spring.services.Service;

/**
 * Class to represent a hotel room.
 * @author jayanath.amaranayake
 *
 */
public class Room {
	
	/** Logger instance for this class */
	static Logger logger = Logger.getLogger(Room.class);
	
	/** List of services*/
	private List<Service> serviceList;
	
	/** Type of the room*/
	private String roomType;
	
	/**
	 * NOTE: we use @ConstructorProperties annotation to tell
	 * Spring Framework to better identify the constructor argument
	 * names when we compile the code with debugging off
	 * @param roomType
	 */
	@ConstructorProperties({"roomType"})
	public Room(String roomType) {
		this.roomType = roomType;
		logger.info("***Constructor Injection: Room type in to the room instance");
	}

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
	public List<String> getUsedServiceNames() {
		List<String> names = new ArrayList<String>();
		for (Service service : serviceList) {
			names.add(service.printServiceInfo());
		}
		
		return names;
	}

	/**
	 * Sets the service list
	 * @param serviceList
	 */
	public void setServiceList(List<Service> serviceList) {
		this.serviceList = serviceList;
		logger.info("***Setter Injection: List of services in to the room instance");
	}

	public String getRoomType() {
		return roomType;
	}
	
}
