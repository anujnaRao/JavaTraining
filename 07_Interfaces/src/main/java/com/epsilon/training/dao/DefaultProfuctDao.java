package com.epsilon.training.dao;

import com.epsilon.training.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultProfuctDao implements ProductDao {

	@Override
	public void createProduct(Product product) {
		log.debug("Adding a product");

	}

	@Override
	public Product getProduct(int id) {
		log.debug("Retreiving a product");
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		log.debug("Update");

	}

	@Override
	public void deleteProduct(int id) {
		log.debug("Delete");

	}

}
