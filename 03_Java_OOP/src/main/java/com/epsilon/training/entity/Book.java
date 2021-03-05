package com.epsilon.training.entity;

public class Book {
	private int id;
	private String title;
	private String author;
	private String publisher;
	private double price;
	
	// Writers and Readers or mutators or setters and getters
	
	//For Good practice
	public Book() {
		
	}
	//Constructors diff type
	
	public void print() {
		System.out.println("ID: " + this.id);
		System.out.println("ID: " + title);
		System.out.println("ID: " + author);
		System.out.println("ID: " + publisher);
		System.out.println("ID: " + price);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
