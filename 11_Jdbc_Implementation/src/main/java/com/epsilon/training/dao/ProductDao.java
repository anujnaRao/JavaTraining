package com.epsilon.training.dao;


import java.util.List;

import com.epsilon.training.entity.Product;

public interface ProductDao {
	//CRUD operations
	
	public void createProduct(Product product)throws DaoException, Exception;
	
	public Product getProduct(int id)throws DaoException, Exception;
	
	public void updateProduct(Product product)throws DaoException, Exception;
	
	public void deleteProduct(int id)throws DaoException, Exception;
	
	//Queries
	
	public default List<Product> getAll() throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	public default List<Product> getByPriceRange(double min, double max) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	public default List<Product> getByBrand(String brand) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}

	public default List<Product> getByCategory(String category) throws DaoException {
		throw new DaoException("Method not implemented yet!");
	}
}
