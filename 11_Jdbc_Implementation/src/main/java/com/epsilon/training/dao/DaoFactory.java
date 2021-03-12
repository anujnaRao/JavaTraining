package com.epsilon.training.dao;


import java.util.ResourceBundle;

public final class DaoFactory {
	
	private static final String discriminator;
	
	private DaoFactory() {
	}
	
	static {
		// gets executed only oncce
		String envVal = System.getenv("DAO_IMPL");
		if(envVal == null) {
			ResourceBundle rb = ResourceBundle.getBundle("dao");
			discriminator = rb.getString("dao.impl");
		} else {
			discriminator =  "jdbc";
		}
	}
	
	public static ProductDao getProductDao() {
		switch(discriminator.toUpperCase()) {
		case "DUMMY":
			throw new RuntimeException("Please implement the ProductDao");
		case "ARRAY":
			throw new RuntimeException("Please implement the ProductDao");
		case "JDBC":
			return new JdbcProductDao();
		case "MONGODB":
		case "CSV":
			throw new RuntimeException("Please implement the ProductDao");
			default:
				throw new RuntimeException("Please implement the ProductDao");
		}
	}
}
