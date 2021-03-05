package com.epsilon.assign14;

public class Square extends Rectangle {
	
	private double side;
	
	public Square() {
		
	}

	public Square(double side) {
		super();
		this.side = side;
	}

	public Square(String color, boolean filled, double side) {
		super();
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}
	
	public void setWidth(double side) {
		this.side = side;
	}
	
	public void setLength(double side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return "Square [side=" + side + ", toString()=" + super.toString() + "]";
	}
	
	
}
