package com.epsilon.trainig.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class DBUtil {
	
	private static final String driverClassName;
	private static final String url;
	private static final String username;
	private static final String password;
	
	static {
		ResourceBundle rb = ResourceBundle.getBundle("jdbc-infor");
		driverClassName = rb.getString("jdbc.connection.driverClassName");
		url = rb.getString("jdbc.connection.url");
		username = rb.getString("jdbc.connection.username");
		password = rb.getString("jdbc.connection.password");
	}
	private DBUtil() {
		
	}
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driverClassName);
		return DriverManager.getConnection(url,username,password);
		
	}
}
