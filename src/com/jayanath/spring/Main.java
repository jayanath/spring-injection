package com.jayanath.spring;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jayanath.spring.config.AppConfig;

/**
 * This is the entry point of our application.
 * 
 * @author jayanath.amaranayake
 *
 */
public class Main {
	/** Logger instance for this class */
	static Logger logger = Logger.getLogger(Main.class);
	
	/**
	 * @param args the configuration modes:
	 * Annotation based or XML based
	 */
	public static void main(String[] args) {
		Room room;
		//this is the only place that we have a direct dependency on the Spring API
		//check the configuration mode
		if(args[0].equals("XML")) {
			logger.info("Using XML for application configuration");
			ApplicationContext xmlCtx = new ClassPathXmlApplicationContext("appconfig.xml");
			room = (Room) xmlCtx.getBean(Room.class);
			
		}else {
			logger.info("ZERO XML. Using Annotations for application configuration");
			AnnotationConfigApplicationContext annCtx = new AnnotationConfigApplicationContext();
			annCtx.register(AppConfig.class);
			annCtx.refresh();
			room = (Room) annCtx.getBean(Room.class);
		}
		
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
