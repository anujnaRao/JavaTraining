package com.epsilon.training.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epsilon.training.entity.Product;
import com.epsilon.training.utils.KeyBoardUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvProductDao implements ProductDao {
private static final String FILENAME = "products.csv";
	
	private Map<Integer, Product> products;

	public CsvProductDao() {
		this.products = new HashMap<>();

		File file = new File(FILENAME);
		if (file.exists()) {
			try (FileReader reader = new FileReader(file); BufferedReader in = new BufferedReader(reader);) {

				// skip header
				in.readLine();
				String line;
				while ((line = in.readLine()) != null) {
					// convert one line into one product and add to the map
					Product p = addProduct(line);
					if (p != null) {
						products.put(p.getId(), p);
					}

				}
			} catch (Exception ex) {
				// exception ducking; ignoring the runtime error
				log.warn("There was an error - {}", ex.getMessage());
			}
		}
	}
	
	private Product addProduct(String line) {
		try {
			String[] vals = line.split(",");
			Product p = new Product();
			p.setId(Integer.parseInt(vals[0]));
			p.setCategory(vals[1]);
			p.setName(vals[2]);
			p.setBrand(vals[3]);
			p.setDescription(vals[4]);
			p.setQuantityPerUnit(vals[5]);
			p.setUnitPrice(Double.parseDouble(vals[6]));
			p.setPicture(vals[7]);
			p.setDiscount(Double.parseDouble(vals[8]));
			return p;
		} catch (NumberFormatException e) {
			log.warn("Error - {}", e.getMessage());
			return null;
		}

	}

	@Override
	public void createProduct(Product product) throws DaoException, FileNotFoundException, IOException{
		
		FileWriter writer = null;
		PrintWriter out = null;

		try {
			File file = new File(FILENAME);

			if (file.exists()) {
				// open the file for appending
				writer = new FileWriter(file, true);
				out = new PrintWriter(writer);
			} else {
				// create a new file and add header line
				String header = "id,name,description,brand,category,quantityPerUnit,unitPrice,discount,picture";
				writer = new FileWriter(file);
				out = new PrintWriter(writer);
				out.println(header);
			}

			int id = KeyBoardUtil.getInt("Enter id       : ");
			String name = KeyBoardUtil.getString("Enter firstname: ");
			String description = KeyBoardUtil.getString("Enter lastname : ");
			String brand = KeyBoardUtil.getString("Enter gender   : ");
			String category = KeyBoardUtil.getString("Enter phone    : ");
			String quantityPerUnit = KeyBoardUtil.getString("Enter email    : ");
			double unitPrice = KeyBoardUtil.getDouble("Enter the price");
			double discount = KeyBoardUtil.getDouble("Enter the price");
			String picture = KeyBoardUtil.getString("Enter city     : ");

			out.printf("%d,%s,%s,%s,%s, %f, %f,%s\n", id, name, description, brand, category, quantityPerUnit, unitPrice, discount, picture);
			System.out.println("Data written to the file.");
			
		} finally {
			if (out != null) {
				out.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
		
	}

	@Override
	public Product getProduct(int id)throws DaoException, FileNotFoundException, IOException {

		try (FileReader file = new FileReader(FILENAME);
				BufferedReader in = new BufferedReader(file);) {

			String line;
			// skip the header
			in.readLine(); // ignore the return value
			List<Product> prod = new ArrayList<>();
			while ((line = in.readLine()) != null) {
				String[] values = line.split(",");
				Product p = new Product(values);
				prod.add(p);
			}
		}
		return null;
	}

	@Override
	public void updateProduct(Product product)throws DaoException, FileNotFoundException, IOException {
		this.createProduct(product);
		
	}

	@Override
	public void deleteProduct(int id)throws DaoException{
		
		
	}

	@Override
	public List<Product> getAll() throws DaoException {
		return ProductDao.super.getAll();
	}

	@Override
	public List<Product> getByPriceRange(double min, double max) throws DaoException {
		return ProductDao.super.getByPriceRange(min, max);
	}

	@Override
	public List<Product> getByBrand(String brand) throws DaoException {
		return ProductDao.super.getByBrand(brand);
	}

	@Override
	public List<Product> getByCategory(String category) throws DaoException {
		return ProductDao.super.getByCategory(category);
	}
	
}
