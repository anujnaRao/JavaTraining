package com.epsilon.training.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.epsilon.training.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayListProductDao implements ProductDao{
	List<Product> products = new ArrayList<>(); 
	int index = 0, count = 0, c = 0, d = 0;
	static final int MAX_PRODUCTS = 100;
	
	public ArrayListProductDao() {
		log.debug("ArrayProductDao instantiated");
	}
	
	@Override
	public List<Product> getAll() {
		if (products == null) { 
			throw new RuntimeException("No item is present in the list");
		} 
		return products;
	}


	@Override
	public List<Product> getByPriceRange(double min, double max) {
		List<Product> p1 = null;
		if (products == null) { 
			throw new RuntimeException("No item is present in the list");
		} 
		for(Product p: products) {
			if(p.getUnitPrice() > min && p.getUnitPrice() < max) {
				p1 = Arrays.asList(p);
			} else {
				throw new RuntimeException("Id does not exists");
			}
		}
		return p1;
	}


	@Override
	public List<Product> getByBrand(String brand) {
		List<Product> p1 = null;
		if (products == null) { 
			throw new RuntimeException("No item is present in the list");
		} 
		for(Product p: products) {
			if(p.getBrand() == brand) {
				p1 = Arrays.asList(p);
			} else {
				throw new RuntimeException("Id does not exists");
			}
		}
		return p1;
	}


	@Override
	public List<Product> getByCategory(String category) {
		List<Product> p1 = null;
		if (products == null) { 
			throw new RuntimeException("No item is present in the list");
		} 
		for(Product p: products) {
			if(p.getCategory() == category) {
				p1 = Arrays.asList(p);
			} else {
				throw new RuntimeException("Id does not exists");
			}
		}
		return p1;
	}

	@Override
	public void createProduct(Product product) {
		log.debug("ArrayProductDao.createProduct() called with {}", product);

		if(product.getId() < 0 || product.getId() > 99999) {
			throw new RuntimeException("Please enter valid ID");
		} 
		else {
//			for(int i = 0; i< list.length;i++) {
//				if(list[i] ==  product.getId()) {
//					throw new RuntimeException("Id already exists");
//				} else {
//					list[count++] = product.getId();
//				}
//			}

			if(product.getName() == null || product.getName().length() >15 || product.getName().length() <3) {
				throw new RuntimeException("Name cannot be null or less than 3 letters or more than 15 letters");
			}
			else if(product.getDescription() == null ) {
				throw new RuntimeException("Description cannot be null ");
			}else if(product.getBrand() == null) {
				throw new RuntimeException("Band cannot be null");
			}
//			else if(product.getCategory() == null) {
//				throw new RuntimeException("Category cannot be null");
//			} else if(product.getQuantityPerUnit() == null) {
//				throw new RuntimeException("Quantity cannot be null");
//			} else if(product.getUnitPrice() < 0 || product.getUnitPrice() > 200) {
//				throw new RuntimeException("Unit price cannot be negative or more than 200");
//			} else if(product.getDiscount() < 0 || product.getUnitPrice() > (Integer.parseInt(product.getQuantityPerUnit()) * product.getUnitPrice() ) ) {
//				throw new RuntimeException("Discount cannot be negative or it cannot be greater than the amount of the product");
//			}
		}
		if (index < MAX_PRODUCTS - 1) {
			products = Arrays.asList(product);
		}
		else {
			throw new RuntimeException("Exceeded the maximum allowed products");
		}

	}

	@Override
	public Product getProduct(int id) {
		Product p1 = null;
		if (products == null) { 
			throw new RuntimeException("No item is present in the list");
		} 
		for(Product p: products) {
			if(p.getId() ==  id) {
				log.debug("The product exisits");
				p1 = p;
			} else {
				throw new RuntimeException("Id does not exists");
			}
		}
		return p1;
	}

	@Override
	public void updateProduct(Product product) {
		log.debug("ArrayProductDao.updateProduct() called with {}", product);

		for(Product p : products) {
			if(p.getId() ==  product.getId()) {
				p.setUnitPrice(product.getUnitPrice());
				log.debug("Updated");
//				this.getProduct(product.getId());
			}
		}
		
	}

	@Override
	public void deleteProduct(int id) {
		int index = 0;
		if (products == null) { 
			throw new RuntimeException("No item is present in the list");
		} 
		for(Product p: products) {
			if(p.getId() ==  id) {
				products.remove(index);
				log.debug("The product is deleted");
			}
			index++;
		}
		if(index == MAX_PRODUCTS) {
			throw new RuntimeException("Id does not exists");
		}
		
	}

}
