package com.epsilon.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epsilon.training.dao.DummyProductDao;
import com.epsilon.training.dao.ProductDao;

import lombok.extern.slf4j.Slf4j;

//Substitution for context.xml
@Slf4j
@Configuration //<beans>.... </beans>
public class AppConfig1 {
	
	public AppConfig1() {
		log.debug("Constructor instantiated");
	}
	
	//to represent a bean, create a function which returns a bean
	// and annotate the function with @bean
	@Bean
	@Scope("prototype")
	public ProductDao dummy() {
		log.debug("AppConfig1.dummy() called");
		return new DummyProductDao();
	}

}
