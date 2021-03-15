package com.epsilon.training.dao;

import java.util.ResourceBundle;

public final class DaoFactory {
	
	private static final String discriminator;
	
	private DaoFactory() {
	}
	
	static {
		// gets executed only once
		String envVal = System.getenv("DAO_IMPL");
		if(envVal == null) {
			ResourceBundle rb = ResourceBundle.getBundle("dao");
			discriminator = rb.getString("dao.impl");
		} else {
			discriminator =  envVal;
		}
	}
	
	public static ProductDao getProductDao() {
		switch(discriminator.toUpperCase()) {
		case "DUMMY":
			return new DefaultProfuctDao();
		case "ARRAY":
			return new ArrayProductDao();
		case "ARRAYLIST":
			return new ArrayListProductDao();
		case "JDBC":
			return new JdbcProductDao();
		case "MONGODB":
			throw new RuntimeException("Please implement the ProductDao");
		case "CSV":
			return new CsvProductDao();
			default:
				throw new RuntimeException("Please implement the ProductDao");
		}
	}
}
