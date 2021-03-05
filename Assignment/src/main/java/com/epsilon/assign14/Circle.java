package com.epsilon.assign14;

public class Circle extends Shape {
	private double radius;
	private double area, perimeter;
	private static double PI = 3.14;
	
	public Circle() {
		
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle(String color, boolean filled, double radius) {
		super(color, filled);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		area = PI * radius * radius;
		return area;
	}
	
	public double getPerimeter() {
		perimeter = 2 * PI * radius;
		return perimeter;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", toString()=" + super.toString() + "]";
	}
	
}
