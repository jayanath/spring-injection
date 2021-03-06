package com.jayanath.spring.services.impl;

import org.apache.log4j.Logger;

import com.jayanath.spring.services.Service;

/**
 * Class to handle Food services.
 * @author jayanath.amaranayake
 *
 */
public class Food implements Service {
	
	/** Logger instance for this class */
	static Logger logger = Logger.getLogger(Food.class);	
	
	/** The name of the service*/
	private String serviceName;
	
	@Override
	public double calculateServiceCharge() {
		// Let's return some value for the time being
		return 40;
	}

	@Override
	public String printServiceInfo() {
		// we could have service specific info here
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
		logger.info("***Setter Injection: Service name to food service instance.");
	}
	
}
