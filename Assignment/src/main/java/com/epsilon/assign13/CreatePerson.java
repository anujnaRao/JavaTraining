package com.epsilon.assign13;


public class CreatePerson {

	public static void main(String[] args) {
		Student s1, s2, s3;
		Staff ss1, ss2;
		
		Person[] people = {
				new Student("Shyam", "Bangalore, Karnataka", "Java fundamentals", 2010, 4500.0),
				new Staff("Anand", "Bangalore, Karnataka", "Delhi Public school", 35000.0), 
				new Staff("Umesh", "Bangalore, Karnataka", "National Public school", 42000.0), 
				new Student("Suresh", "Hassan, Karnataka", "Java fundamentals", 2012, 4750.0),
				new Student("Kiran", "Vasco, Goa", "Reactjs", 2017, 12500.0)
			};
		
		Person p1;
		
		System.out.println();
		s1 = (Student) people[0];
		p1 = s1;
		System.out.println(p1);
		
		System.out.println();
		s2 = (Student) people[3];
		p1 = s2;
		System.out.println(p1);
		
		System.out.println();
		s3 = (Student) people[4];
		p1 = s3;
		System.out.println(p1);
		
		System.out.println();
		ss1 = (Staff) people[1];
		p1 = ss1;
		System.out.println(p1);
		
		System.out.println();
		ss2 = (Staff) people[2];
		p1 = ss2;
		System.out.println(p1);
		
		

	}

}
