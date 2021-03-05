package com.epsilon.assign14;

public class CreateShape {

	public static void main(String[] args) {
		Circle c1;
		Rectangle r1;
		Square s1;
		
		Shape[] shapes = {
				new Circle(12.34),
				new Rectangle(12.34, 10.0),
				new Square(10.0),
				new Circle("Black",true,12.34),
				new Circle(10.0),
				new Rectangle("blue",true,12.34, 10.0),
				new Square(12.34),
				new Square("Brown",false, 10.0),
				new Rectangle(4, 5.0),
				new Circle("blue",false,3.45),
			};
		
		Shape t1;
		for(int i = 0; i < shapes.length; i++) {
			t1 = shapes[i];
			if(t1 instanceof Circle) {
				c1 = (Circle) t1;
				System.out.println(c1);
				System.out.println(c1.getArea());
				System.out.println(c1.getPerimeter());
			}
			else if(t1 instanceof Rectangle) {
				r1 = (Rectangle) t1;
				System.out.println(r1);
				System.out.println(r1.getArea());
				System.out.println(r1.getPerimeter());
			}
			else if(t1 instanceof Square) {
				s1 = (Square) t1;
				System.out.println(s1);
			}
		}
		

	}

}
