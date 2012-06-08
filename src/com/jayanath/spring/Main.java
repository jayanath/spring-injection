package com.jayanath.spring;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This is the entry point of our application
 * @author jayanath.amaranayake
 *
 */
public class Main {
	/** Logger instance for this class */
	static Logger logger = Logger.getLogger(Main.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//this is one way of loading the spring configuration and obtain a spring context
		//this is the only place that we have a direct dependency on the Spring API
		ApplicationContext context = new ClassPathXmlApplicationContext("appconfig.xml");
		//we can retrieve any bean by name
		Room room = (Room) context.getBean("Room");
		String names = room.getUsedServiceNames();
		double charge = room.calculateRoomCharge();
		
		logger.info("The room charge is " + charge + " with " + names);

	}

}
