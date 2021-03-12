package com.epsilon.trainig.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDatabaseDriver {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driverClassName = "org.h2.Driver";
		String url = "jdbc:h2:tcp://localhost/~/epsilontraining";
		String username = "root";
		String password = "root@123";
		
		Class.forName(driverClassName);
		
		Connection conn = DriverManager.getConnection(url,username,password);
		System.out.println("Conn is instance of : " + conn.getClass());
		
		conn.close();
	}

}
