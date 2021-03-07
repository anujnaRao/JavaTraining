package com.epsilon.training.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Since the interface is equivalent to abstract class with or without abstract method

public interface Shape {
	
	double PI = 3.14159;
	Logger log = LoggerFactory.getLogger(Shape.class);
	double getArea();
	
	default void info() {
		log.debug("Something to print");
	}
// Functional interface -- only one abstract method implemented
// Marker interface -- no method to implement
	
	static void details() {
		log.debug("Details from Shape");
	}
}
