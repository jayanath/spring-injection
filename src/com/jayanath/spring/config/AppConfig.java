/**
 * 
 */
package com.jayanath.spring.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.jayanath.spring.Room;
import com.jayanath.spring.services.Service;
import com.jayanath.spring.services.impl.Food;
import com.jayanath.spring.services.impl.Internet;
import com.jayanath.spring.services.impl.Laundry;
import com.jayanath.spring.services.impl.Telephone;

/**
 * The Application Configuration class. This is the replacement
 * to the XML based Spring configuration files.
 * Refer to :
 * http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/beans.html#beans-java
 * http://static.springsource.org/spring/docs/3.1.x/javadoc-api/org/springframework/context/annotation/Configuration.html
 * 
 * @author jayanath.amaranayake
 *
 */
@Configuration
@PropertySource("classpath:appconfig.properties")
public class AppConfig {
	
	@Autowired Environment env;
	
	@Bean
	public Internet internet() {
		Internet i = new Internet();
		i.setServiceName(env.getProperty("internet.service"));
		return i;
	}
	
	@Bean
	public Food food() {
		Food f = new Food();
		f.setServiceName(env.getProperty("food.service"));
		return f;
	}
	
	@Bean
	public Laundry laundry() {
		Laundry l = new Laundry();
		l.setServiceName(env.getProperty("laundry.service"));
		return l;
	}
	
	@Bean
	public Telephone telephone() {
		Telephone t = new Telephone();
		t.setServiceName(env.getProperty("telephone.service"));
		return t;
	}
	
	@Bean
	public Room room() {
		Room r = new Room("Monte Carlo");
		List<Service> list = new ArrayList<Service>();
		list.add(internet());
		list.add(food());
		list.add(laundry());
		list.add(telephone());
		r.setServiceList(list);
		return r;
	}
}
