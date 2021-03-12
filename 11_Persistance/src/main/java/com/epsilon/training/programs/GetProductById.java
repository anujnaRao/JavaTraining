package com.epsilon.training.programs;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetProductById {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("epsilon");
		System.out.println("Gor Entity manager of type: "+ emf.getClass().getName());

	}

}
