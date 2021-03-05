package com.epsilon.training.entity;

import lombok.Data;

@Data
public class Customer {
	
	private int id;
	private String name;
	private Address address;// = new Address(); // aggregation eager
	private String phone;
	private String email;
	
	public Customer() {
		this.address = new Address();
	}

}
