package com.epsilon.assign14;

public class Rectangle extends Shape {
	private double width;
	private double length;
	private double area, perimeter;
	
	public Rectangle() {
		
	}

	public Rectangle(double width, double length) {
		super();
		this.width = width;
		this.length = length;
	}

	public Rectangle(String color, boolean filled, double width, double length) {
		super(color, filled);
		this.width = width;
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	public double getArea() {
		area = width * length;
		return area;
	}
	
	public double getPerimeter() {
		perimeter = 2 * (width + length);
		return perimeter;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", length=" + length + ", toString()=" + super.toString() + "]";
	}
	
	
}
