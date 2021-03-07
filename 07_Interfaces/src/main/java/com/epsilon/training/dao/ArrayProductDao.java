package com.epsilon.training.dao;

import com.epsilon.training.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayProductDao implements ProductDao{

	Product[] products;
	int[] list;
	int index = 0, count = 0, c = 0, d = 0;
	static final int MAX_PRODUCTS = 100;

	public ArrayProductDao() {
		log.debug("ArrayProductDao instantiated");
		this.products = new Product[MAX_PRODUCTS]; // this is the accepted boundary
	}


	@Override
	public void createProduct(Product product) {
		log.debug("ArrayProductDao.addProduct() called with {}", product);

		if(product.getId() < 0 || product.getId() > 99999) {
			throw new RuntimeException("Please enter valid ID");
		} else {
			for(int i = 0; i< list.length;i++) {
				if(list[i] ==  product.getId()) {
					throw new RuntimeException("Id already exists");
				} else {
					list[count++] = product.getId();
				}
			}

			if(product.getName() == null || product.getName().length() >15 || product.getName().length() <3) {
				throw new RuntimeException("Name cannot be null or less than 3 letters or more than 15 letters");
			}
			else if(product.getDescription() == null ) {
				throw new RuntimeException("Description cannot be null ");
			}else if(product.getBrand() == null) {
				throw new RuntimeException("Band cannot be null");
			} else if(product.getCategory() == null) {
				throw new RuntimeException("Category cannot be null");
			} else if(product.getQuantityPerUnit() == null) {
				throw new RuntimeException("Quantity cannot be null");
			} else if(product.getUnitPrice() < 0 || product.getUnitPrice() > 200) {
				throw new RuntimeException("Unit price cannot be negative or more than 200");
			} else if(product.getDiscount() < 0 || product.getUnitPrice() > (Integer.parseInt(product.getQuantityPerUnit()) * product.getUnitPrice() ) ) {
				throw new RuntimeException("Discount cannot be negative or it cannot be greater than the amount of the product");
			}
		}
		if (index < MAX_PRODUCTS - 1) {
			this.products[index++] = product;
		}
		else {
			throw new RuntimeException("Exceeded the maximum allowed products");
		}
	}

	@Override
	public Product getProduct(int id) {
		//		log.debug("ArrayProductDao.addProduct() called with {}", product);
		int position = 0;
		for(int i = 0; i < index;i++) {
			if(products[i].getId() ==  id) {
				log.debug("The product exisits: ");
				position = i;

			} else {
				throw new RuntimeException("Id does not exists");
			}
		}
		return products[position];
	}

	@Override
	public void updateProduct(Product product) {
		log.debug("ArrayProductDao.addProduct() called with {}", product);

		for(int i = 0; i < index;i++, c++) {
			if(products[i].getId() ==  product.getId()) {
				log.debug("Updated details: ");
				this.getProduct(product.getId());

			}
		}
		if(c == index) {
			throw new RuntimeException("Id does not exists");
		}
		c=0;
	}

	@Override
	public void deleteProduct(int id) {

		Product[] copy = new Product[index - 1];

		if (products == null || index <= 0 || index >= index) { 
			throw new RuntimeException("No item is present in the list");
		} 
		for(int i = 0; i < index;i++, d++) {
			if(products[i].getId() ==  id) {
				for (int n = 0, j = 0; n < index; n++) {
					if (n != i) {
						copy[j++] = products[n];
					}
				}
			} else {
				throw new RuntimeException("Id does not exists");
			}
		}
		if(d == products.length) {
			throw new RuntimeException("Id does not exists");
		}
		d=0;
	}

}
