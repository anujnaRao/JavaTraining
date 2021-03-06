package com.epsilon.training.entity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Person {
	
	private String name;
	private String email;
	private String city;
	
	public Person() {
		log.debug("Person() called");
	}

	public Person(String name, String email, String city) {
		this.name = name;
		this.email = email;
		this.city = city;
		log.debug("Person() with parameters called");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", city=" + city + ", toString()=" + super.toString()
				+ "]";
	}
	
	public void print() {
		System.out.println("Name: "+ name);
		System.out.println("Email: "+ email);
		System.out.println("City: "+ city);
	}
	
	
}
