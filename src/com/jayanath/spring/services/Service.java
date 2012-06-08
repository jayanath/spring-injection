package com.jayanath.spring.services;

/**
 * All the services should implement this interface.
 * @author jayanath.amaranayake
 *
 */
public interface Service {
	/**
	 * Calculates the service charge.
	 * This could depend on various factors of the service itself.
	 * @return the service charge value
	 */
	double calculateServiceCharge();
	
	/**
	 * Returns the service information
	 * @return
	 */
	String printServiceInfo();
}
