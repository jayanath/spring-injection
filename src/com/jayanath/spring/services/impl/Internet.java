package com.jayanath.spring.services.impl;

import org.apache.log4j.Logger;

import com.jayanath.spring.services.Service;

/**
 * Class to handle Internet services
 * @author jayanath.amaranayake
 *
 */
public class Internet implements Service {

	/** Logger instance for this class */
	static Logger logger = Logger.getLogger(Internet.class);
	
	/** The name of the service*/
	private String serviceName;
	
	@Override
	public double calculateServiceCharge() {
		// Let's return some value for the time being
		return 10.19;
	}

	@Override
	public String printServiceInfo() {
		// we could have service specific info here
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
		logger.info("INJECTED the service name to Internet service");
	}
	
}
