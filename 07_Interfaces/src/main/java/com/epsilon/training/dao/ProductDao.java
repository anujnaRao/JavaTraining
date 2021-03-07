package com.epsilon.training.dao;

import com.epsilon.training.entity.Product;

public interface ProductDao {
	//CRUD operations
	
	public void createProduct(Product product);
	
	public Product getProduct(int id);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(int id);
	
	//Queries
}
