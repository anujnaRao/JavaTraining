package com.epsilon.training.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Triangle implements Shape {
	
	private double base;
	private double height;
	
	@Override
	public double getArea() {
		return  0.5 *  base * height;
	}

	
	// Implementation needs to be done
}
