package com.epsilon.training.programs;

import java.io.FileWriter;
import java.io.IOException;

import com.epsilon.training.annotations.processes.JsonSerializer;
import com.epsilon.training.annotations.processes.XmlSerialize;
import com.epsilon.training.entity.Address;
import com.epsilon.training.entity.Customer;
import com.epsilon.training.exception.NotJsonSerializableException;
import com.epsilon.training.exception.NotXmlSerializableException;

public class CreateCustomer {

	public static void main(String[] args) {
		Address ad = new Address("Ramco Layout", "Banglore", "Karnataka", "India");
		Customer c1 = new Customer("Anu", "anu@gmail.com", "8787656598", ad);
		System.out.println(c1);
		
		JsonSerializer js = new JsonSerializer();
		String json = js.serializer(c1);
		System.out.println(json);
		
		XmlSerialize xs = new XmlSerialize();
		String xml = xs.xSerialize(c1);
		System.out.println(xml);
//		Customer c2 = new Customer("Sam", "sam@gmail.com", "9857656598",address);
//		c1.getAddress().setStreet("Nazarbad");
//		c1.getAddress().setCity("Mysore");
//		c1.getAddress().setState("Karnataka");
//		c1.getAddress().setCountry("India");
//		System.out.println(js.serializer(c2));
		
		FileWriter file = null;
		try {
			file = new FileWriter("cust.json");
		} catch (IOException e) {
			throw new NotJsonSerializableException();
		}
		js.serializer(file,c1);
		
		FileWriter file2 = null;
		try {
			file2 = new FileWriter("cust.xml");
		} catch (IOException e) {
			throw new NotXmlSerializableException();
		}
		xs.xSerialize(file2,c1);
		
	}

}
