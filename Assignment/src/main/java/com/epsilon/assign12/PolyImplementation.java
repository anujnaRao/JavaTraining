package com.epsilon.assign12;


public class PolyImplementation {

	public static void main(String[] args) {
		
		Cylinder c1, c2, c3;
		Circle s;
		Circle[] circles = {
				new Cylinder(12.34),
				new Cylinder(12.34, 10.0),
				new Cylinder(12.34, 10.0, "blue")
			};
		
		c1 = (Cylinder) circles[0];
		c2 = (Cylinder) circles[1];
		c3 = (Cylinder) circles[2];
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		System.out.println();
		s = c1;
		s.print();
		
		System.out.println();
		s =c2;
		s.print();
		
		System.out.println();
		s = c3;
		s.print();

	}

}
