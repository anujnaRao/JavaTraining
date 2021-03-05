package com.epsilon.training.programs;

import com.epsilon.training.entity.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreatePersons {

	public static void main(String[] args) {
		Customer c1 = new Customer();
		c1.setId(1);
		c1.setName("Anu");
		c1.setPhone("234235");
		c1.setEmail("anu@gmail.com");
		
		//c1.setAddress(new Address());
		
		c1.getAddress().setHouseNo("#1");
		c1.getAddress().setArea("Some");
		c1.getAddress().setCity("Banglore");
		c1.getAddress().setStreet("Layout");
		c1.getAddress().setState("Karnataka");
		c1.getAddress().setCountry("India");
		
		//If pointing to same address
		/*
		 * Address addr = new Address()
		 * addr.setHouseNo()...
		 * c1.setAddress(addr)
		 * c2.setAddress(addr)
		 */
		
		log.info("c1 {}" ,c1);
	}

}
