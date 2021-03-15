package com.epsilon.training.programs;

import java.util.InputMismatchException;
import java.util.List;

import com.epsilon.training.dao.DaoFactory;
import com.epsilon.training.dao.ProductDao;
import com.epsilon.training.entity.Product;
import com.epsilon.training.utils.KeyBoardUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductManagerApplication {

	ProductDao dao;

	void start() {
		//Tight coupling should be avoided
		//dao = new DefaultProfuctDao(); // avoid
		dao = DaoFactory.getProductDao();

		while (true) {
			menu();
			try {
				int choice = KeyBoardUtil.getInt("Enter your choice: ");
				if (choice == 0) {
					System.out.println("Thank you and have a nice day.");
					break;
				}

				switch (choice) {
				case 1:
					acceptAndAddProductDetails();
					break;
				case 2:
					acceptAndRetrieveProductDetails();
					break;
				case 3:
					acceptAndUpdateProductDetails();
					break;
				case 4:
					acceptAndDeleteProductDetails();
					break;
				case 5:
					acceptAndGetAll();
					break;
				case 6:
					acceptAndGetByBrand();
					break;
				case 7:
					acceptAndgetByCategory();
					break;
				case 8:
					acceptAndGetByPriceRange();
					break;
				default:
					System.out.println("Invalid choice! Please try again.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid choice! Please try again.");
			}
		}

	}

	void acceptAndGetByPriceRange() {
		try {
			double min = KeyBoardUtil.getDouble("Enter the minimum value: ");
			double max = KeyBoardUtil.getDouble("Enter the maximum value: ");
			List<Product> pro = dao.getByPriceRange(min, max);

			for(Product p: pro ) {
				System.out.println(p);
			}
			System.out.println("");
		}
		catch(Exception ex) {
			log.warn("There was an error while trying to add a product");
			log.warn(ex.getMessage());
		}


	}

	void acceptAndgetByCategory() {
		try {
			String category = KeyBoardUtil.getString("Enter the category: ");
			List<Product> pro = dao.getByCategory(category);

			for(Product p: pro ) {
				System.out.println(p);
			}
			System.out.println("");
		}
		catch(Exception ex) {
			log.warn("There was an error while trying to add a product");
			log.warn(ex.getMessage());
		}

	}

	void acceptAndGetByBrand() {
		try {
			String brand = KeyBoardUtil.getString("Enter the brand: ");
			List<Product> pro = dao.getByBrand(brand);

			for(Product p: pro ) {
				System.out.println(p);
			}
			System.out.println("");
		}
		catch(Exception ex) {
			log.warn("There was an error while trying to add a product");
			log.warn(ex.getMessage());
		}

	}

	void acceptAndGetAll() {
		try {

			List<Product> pro = dao.getAll();

			for(Product p: pro ) {
				System.out.println(p);
			}
			System.out.println("");
		}
		catch(Exception ex) {
			log.warn("There was an error while trying to add a product");
			log.warn(ex.getMessage());
		}

	}

	void acceptAndDeleteProductDetails() {
		try {
			int id = KeyBoardUtil.getInt("Enter id: ");

			dao.getProduct(id);
			System.out.println("Product deleted successfully");
		}
		catch(Exception ex) {
			log.warn("There was an error while trying to add a product");
			log.warn(ex.getMessage());
		}
	}

	void acceptAndUpdateProductDetails() {
		try {
			int id = KeyBoardUtil.getInt("Enter the id: ");
			double unitPrice = KeyBoardUtil.getDouble("Enter the price per unit: ");

			Product p = new Product();
			p.setId(id);
			p.setUnitPrice(unitPrice);
			
			dao.updateProduct(p);
			System.out.println("Producr details updated");
		}
		catch(Exception ex) {
			log.warn("There was an error while trying to add a product");
			log.warn(ex.getMessage());
		}
	}

	void acceptAndRetrieveProductDetails() {
		try {
			int id = KeyBoardUtil.getInt("Enter id: ");

			Product p = dao.getProduct(id);

			System.out.println("ID: " +  p.getId());
			System.out.println("Name: " +  p.getName());
			System.out.println("Description: " +  p.getDescription());
			System.out.println("Brand: "+ p.getBrand());
			System.out.println("Category: " +  p.getCategory());
			System.out.println("Quantity per unit: " +  p.getQuantityPerUnit());
			System.out.println("Price per unit: " +  p.getUnitPrice());
			System.out.println("Discount: " +  p.getDiscount());
			System.out.println("Picture: " +  p.getPicture());
			System.out.println("");
		}
		catch(Exception ex) {
			log.warn("There was an error while trying to retrieve the product");
			log.warn(ex.getMessage());
		}
	}

	void acceptAndAddProductDetails() {

		try {
			// create variables for all product fields
			// accept value for each variable from the user
			int id = KeyBoardUtil.getInt("Enter id: ");
			String name = KeyBoardUtil.getString("Enter product name: ");
			String description = KeyBoardUtil.getString("Enter product description: ");
			String brand = KeyBoardUtil.getString("Enter the brand: ");
			String category = KeyBoardUtil.getString("Enter the category it belongs to: ");
			String quantityPerUnit = KeyBoardUtil.getString("Enter the quantity of the product: ");
			double unitPrice = KeyBoardUtil.getDouble("Enter the price per unit: ");
			double discount = KeyBoardUtil.getDouble("Enter the discount price: ");
			String picture = KeyBoardUtil.getString("Enter product picture for it: ");

			Product p = new Product();
			p.setId(id);
			p.setName(name);
			p.setDescription(description);
			p.setCategory(category);
			p.setBrand(brand);
			p.setQuantityPerUnit(quantityPerUnit);
			p.setUnitPrice(unitPrice);
			p.setDiscount(discount);
			p.setPicture(picture);

			dao.createProduct(p);
			System.out.println("New product details added to successfully!");
		}
		catch(Exception ex) {
			log.warn("There was an error while trying to add a product");
			log.warn(ex.getMessage());
		}
	}


	void menu() {
		System.out.println("-------------- Main Menu -----------");
		System.out.println("0. Exit");
		System.out.println("1. Add a new product");
		System.out.println("2. Retrieve a product by id");
		System.out.println("3. Modify details of a product");
		System.out.println("4. Remove product details");
		System.out.println("5. Get all products");
		System.out.println("6. Get products by brand");
		System.out.println("7. Get products by category");
		System.out.println("8. Get products by price range");
	}
	public static void main(String[] args) {

		new ProductManagerApplication().start();

	}

}
