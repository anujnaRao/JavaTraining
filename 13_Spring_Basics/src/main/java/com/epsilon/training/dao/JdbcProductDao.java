package com.epsilon.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("dao") // @Service @Repository @Component @Controller @RestController
public class JdbcProductDao implements ProductDao {
	
	private String url;
	private String username;
	private String password;
	private String driverClassName;
	
	@Autowired(required=false)
	private DataSource dataSource;
	
	
	public JdbcProductDao() {
		log.debug("From JDBCProduct Dao");
	}
	
	public JdbcProductDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public JdbcProductDao(String url, String username, String password, String driverClassName) {
		log.debug("Creating instance of parameterized JdbcProductDao constructor");
		this.url = url;
		this.username = username;
		this.password = password;
		this.driverClassName = driverClassName;
	}

	public void setUrl(String url) {
		log.debug("Invoking setUrl function with param {} ",url);
		this.url = url;
	}

	public void setUsername(String username) {
		log.debug("Invoking setUsername function with param {} ",username);
		this.username = username;
	}

	public void setPassword(String password) {
		log.debug("Invoking setPassword function with param {} ",password);
		this.password = password;
	}

	public void setDriverClassName(String driverClassName) {
		log.debug("Invoking setDriverClassname function with param {} ",driverClassName);
		this.driverClassName = driverClassName;
	}
	
	public void setDataSource(DataSource dataSource) {
		log.debug("Inside dataSource, instanceof {} class", dataSource.getClass());
		this.dataSource = dataSource;
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		//check if the datasource is not null, then return a connection from the same
		if(this.dataSource != null) {
			return this.dataSource.getConnection();
		}
		Class.forName(this.driverClassName);
		return DriverManager.getConnection(url, username, password);
	}

	@Override
	public long count() {
		
		String sql = "select count(*) as cnt from products";
		try(Connection conn = this.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);){
			
			rs.next();
			return rs.getLong("cnt");
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
