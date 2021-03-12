package com.epsilon.training.programs;

import java.io.FileWriter;
import java.io.IOException;

import com.epsilon.training.annotations.processes.JsonSerializer;
import com.epsilon.training.entity.Person;
import com.epsilon.training.exception.NotJsonSerializableException;

public class CreatePerson {

	public static void main(String[] args) {
		Person p1 = new Person("Anu", "Rao", 22, 5.5);
		p1.setWeight(75);
		System.out.println(p1);
		
		JsonSerializer js = new JsonSerializer();
		String json = js.serializer(p1);
		System.out.println(json);
		
		Person p2 = new Person("Anjali", "Bhat", 46, 5);
		p2.setWeight(56);
		System.out.println(js.serializer(p2));
		FileWriter file = null;
		try {
			file = new FileWriter("p1.json");
		} catch (IOException e) {
			throw new NotJsonSerializableException();
		}
		js.serializer(file, p1);

	}

}
