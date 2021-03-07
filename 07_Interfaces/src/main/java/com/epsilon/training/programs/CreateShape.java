package com.epsilon.training.programs;

import com.epsilon.training.entity.Circle;
import com.epsilon.training.entity.Shape;
import com.epsilon.training.entity.Triangle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateShape {
	
	static void printShapeData(Shape shape) {
		double area = shape.getArea();
		log.debug("Area of the shape {} is {} ", shape.getClass().getName(), shape.getArea());
		
		if(shape instanceof Circle) {
			Circle c = (Circle) shape;
			log.debug("Radius is {}", c.getRadius());
		} else if(shape instanceof Triangle) {
			Triangle t = (Triangle) shape;
			log.debug("Base is {}, Height is {}", t.getBase(), t.getHeight());
		}
	}
	public static void main(String[] args) {
		
		Circle c1 = new Circle(1.1);
		Triangle t1 = new Triangle(2.4, 5.6);
		//Shape s1,;
		//s1 =  new Shape(); // Shape is abstract; cannot bee instantiated;
		//s1 = new Circle(); // instance of Circle, Shape, Object
		
		printShapeData(c1);
		printShapeData(t1);
		//anonymous class anonymous method
		printShapeData(new Shape() {

			@Override
			public double getArea() {
				return 22.34;
			}
			
		});
		// Replacement of above
		//lambda or arrow function
		printShapeData(() -> 6.98);
		
	}

}
