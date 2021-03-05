package com.epsilon.assign12;

public class Cylinder extends Circle {

	private double height;
	public static double PI;
	private double volume;
	
	public Cylinder() {
		
	}
	
	public Cylinder(double radius) {
		super(radius);
	}
	
	
	public Cylinder(double radius, double height) {
		super(radius);
		this.height = height;
	}

	public Cylinder(double radius, double height, String color) {
		super(radius, color);
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getVolume() {
		volume = super.getArea() * height;
		return volume;
	}
	
	@Override
	public String toString() {
		return "Cylinder [height=" + height + ", volume=" + volume + " ]";
	}

	@Override
	public void print() {
		System.out.println("Height: "+ height);
		super.print();
		System.out.println("Volume: "+ volume);
	}
}
