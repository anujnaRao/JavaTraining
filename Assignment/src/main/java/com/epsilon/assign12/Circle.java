package com.epsilon.assign12;


public class Circle {
	
	private double radius;
	private String color;
	private static double PI = 3.14;
	private double area;
	
	public Circle() {
		
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public Circle(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}

	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getArea() {
		area = PI * radius * radius;
		return area;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", color=" + color + "]";
	}
	
	public void print() {
		System.out.println("Radius: "+ radius);
		System.out.println("Color: "+color);
		System.out.println("Area: "+ area);
	}
}
