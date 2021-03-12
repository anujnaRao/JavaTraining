package com.epsilon.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
	private int id;
	private String name;
	private String description;
	private String brand;
	private String category;
	private String quantityPerUnit;
	private double unitPrice;
	private double discount;
	private String picture;
	
	public Product(String[] values) {
		this.id = Integer.parseInt(values[0]);
		this.name = values[1];
		this.description = values[2];
		this.brand = values[3];
		this.category = values[4];
		this.quantityPerUnit = values[5];
		this.unitPrice = Double.parseDouble(values[6]);
		this.discount = Double.parseDouble(values[7]);
		this.picture = values[8];
	}
	
	public void print() {
		System.out.printf("ID           : %d\n", this.id);
		System.out.printf("Name         : %s\n", this.name);
		System.out.printf("Description  : %s\n", this.description);
		System.out.printf("Brand        : %s\n", this.brand);
		System.out.printf("Category     : %s\n", this.category);
		System.out.printf("Quantity/Unit: %s\n", this.quantityPerUnit);
		System.out.printf("Price/unit   : %s\n", this.unitPrice);
		System.out.printf("Picture      : %s\n", this.picture);
		System.out.println();
		
	}
}
