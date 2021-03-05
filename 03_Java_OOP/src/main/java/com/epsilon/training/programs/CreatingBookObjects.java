package com.epsilon.training.programs;

import com.epsilon.training.entity.Book;

public class CreatingBookObjects {
	
	public static void main(String[] args) {
		Book b1;
		// b1 = null;
		b1 = new Book(); 
		// 1. new keyword allocates some memory for book ob in heap
		// 2. a unique ref number is generated using a ref#
		// 3. The constructor of the object is called
		
		System.out.println("Book object: " + b1);
		
		b1.setId(111);
		b1.setTitle("Some Book");
		b1.setAuthor("XYZ");
		b1.setPublisher("ABC");
		b1.setPrice(112.2);
		b1.print(); // Reference to the book ob is invoking and ref as this
		
		//Some other object
	}
	//Picture, memory allocation, prem-gen, old-gen, young-gen ---- EDEN
	//Younger-gen gc - SS0,SS! Eden
	//

}
