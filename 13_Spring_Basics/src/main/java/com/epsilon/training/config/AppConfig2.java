package com.epsilon.training.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.epsilon.training.dao.JdbcProductDao;
import com.epsilon.training.dao.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@PropertySource("classpath:jdbc-info.properties")
public class AppConfig2 {
	
	//dependency injection
	@Value("${jdbc.connection.username}")
	private String username;
	@Value(("${jdbc.connection.password}"))
	private String password;
	@Value(("${jdbc.connection.driverClassName}"))
	private String driverClassName;
	@Value(("${jdbc.connection.url}"))
	private String url;
	
	@Bean(name= {"dao", "jdbcProductDao" })
	public ProductDao jdbcDao() {
		JdbcProductDao dao = new JdbcProductDao();
		
		//setter injection in XML
		
		dao.setDriverClassName("org.h2.Driver");
		dao.setUrl("jdbc:h2:tcp://localhost/~/epsilontraining");
		dao.setUsername("root");
		dao.setPassword("root@123");
		
		return dao;
	}
}
