package com.jayanath.spring;

import java.util.List;

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
		logger.info("Created the ApplicationContext based on the appconfig.xml file");
		//we can retrieve any bean by name
		Room room = (Room) context.getBean("Room");
		logger.info("Got the Room instance");
		List<String> names = room.getUsedServiceNames();
		String type = room.getRoomType();
		double charge = room.calculateRoomCharge();
		logger.info("Room Type : " + type);
		logger.info("The room charge is " + charge + " with the following services :");
		for (String name : names) {
			logger.info("	" + name);
		}
	}

}
