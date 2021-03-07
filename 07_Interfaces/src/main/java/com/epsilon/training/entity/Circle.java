package com.epsilon.training.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//a class implementing an interface is equivalent to
// a class extending to abstract class
//By implementing an interface, the class abides by the
// rules defined by interface
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Circle implements Shape {


	private double radius;
	
	@Override
	public double getArea() {
		return Shape.PI * this.radius * this.radius;
	}
	

}
