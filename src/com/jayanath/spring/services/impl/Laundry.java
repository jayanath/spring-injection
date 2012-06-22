package com.jayanath.spring.services.impl;

import org.apache.log4j.Logger;

import com.jayanath.spring.services.Service;

/**
 * Class to handle Laundry services
 * @author jayanath.amaranayake
 *
 */
public class Laundry implements Service {

	/** Logger instance for this class */
	static Logger logger = Logger.getLogger(Laundry.class);

	/** The name of the service*/
	private String serviceName;
	
	@Override
	public double calculateServiceCharge() {
		// Let's return some value for the time being
		return 8.00;
	}

	@Override
	public String printServiceInfo() {
		// we could have service specific info here
		return serviceName;
	}
	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
		logger.info("***Setter Injection: Service name to laundry service instance");
	}
	

}
