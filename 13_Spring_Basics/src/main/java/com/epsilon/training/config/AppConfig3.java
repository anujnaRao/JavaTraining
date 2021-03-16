package com.epsilon.training.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowire;
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
public class AppConfig3 {

	// dependency injection
	@Value("${jdbc.connection.username}")
	private String username;
	@Value(("${jdbc.connection.password}"))
	private String password;
	@Value(("${jdbc.connection.driverClassName}"))
	private String driverClassName;
	@Value(("${jdbc.connection.url}"))
	private String url;

//	@Bean(autowire = Autowire.BY_NAME)
	@Bean
	public ProductDao dao(DataSource dataSource) {
		log.debug("Inside ProductDao");
		return new JdbcProductDao(dataSource);
	}
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(driverClassName);
		bds.setUrl(url);
		bds.setUsername(username);
		bds.setPassword(password);

		bds.setMaxTotal(50);
		bds.setInitialSize(5);
		bds.setMaxWaitMillis(5);
		bds.setMaxIdle(3000);

		return bds;
	}
}
