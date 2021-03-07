package com.epsilon.training.dao;


public final class DaoFactory {
	
	private static final String discriminator = "ARRAY";
	
	private DaoFactory() {
	}
	
	public static ProductDao getProductDao() {
		switch(discriminator.toUpperCase()) {
		case "DUMMY":
			return new DefaultProfuctDao();
		case "ARRAY":
			return new ArrayProductDao();
		case "JDBC":
		case "MONGODB":
		case "CSV":
			throw new RuntimeException("Please implement the ProductDao");
			default:
				throw new RuntimeException("Please implement the ProductDao");
		}
	}
}
