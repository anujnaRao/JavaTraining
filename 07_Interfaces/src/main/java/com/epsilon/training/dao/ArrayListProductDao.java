package com.epsilon.training.dao;

import java.util.ArrayList;
import java.util.List;

import com.epsilon.training.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayListProductDao implements ProductDao{
	List<Product> products = new ArrayList<>(); 
	int[] list;
	int index = 0, count = 0, c = 0, d = 0;
	static final int MAX_PRODUCTS = 100;
	
	public ArrayListProductDao() {
		log.debug("ArrayProductDao instantiated");
	}
	
	@Override
	public List<Product> getAll() {
		return null;
	}


	@Override
	public List<Product> getByPriceRange(double min, double max) {
		return null;
	}


	@Override
	public List<Product> getByBrand(String brand) {
		return null;
	}


	@Override
	public List<Product> getByCategory(String category) {
		return null;
	}

	@Override
	public void createProduct(Product product) {
		
		
	}

	@Override
	public Product getProduct(int id) {
		
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		
		
	}

	@Override
	public void deleteProduct(int id) {
		
		
	}

}
