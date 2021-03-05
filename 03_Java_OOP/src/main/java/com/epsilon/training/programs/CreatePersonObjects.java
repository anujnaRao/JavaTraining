package com.epsilon.training.programs;

import com.epsilon.training.entity.Person;

public class CreatePersonObjects {

	public static void main(String[] args) {
		Person p1= new Person();
		p1.setFirstname("Anu");
		p1.setLastname("Rao");
		p1.setEmail("anu@gmail.com");
		p1.setAddress("Banglore");
		
		Person p2= new Person();
		p1.setFirstname("Anu");
		p1.setLastname("Rao");
		p1.setEmail("anu@gmail.com");
		p1.setAddress("Banglore");
		
		System.out.println(p1);
		
	}

}
