package com.epsilon.training.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epsilon.trainig.utils.DBUtil;
import lombok.extern.slf4j.Slf4j;

import com.epsilon.training.entity.Product;

@Slf4j
public class JdbcProductDao implements ProductDao {

	@Override
	public void createProduct(Product product) throws DaoException, Exception {
		String sql = "insert into products values(null, ?, ?, ?, ?, ?, ?, ?, ?)";

		try(Connection conn = DBUtil.createConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){

			String category = product.getCategory();
			String name = product.getName();
			String brand = product.getBrand();
			String description = product.getDescription();
			String quantityPerUnit = product.getQuantityPerUnit();
			double unitPrice = product.getUnitPrice();
			String picture = product.getPicture();
			double discount = product.getDiscount();

			stmt.setString(1, name);
			stmt.setString(2, brand);
			stmt.setString(3, category);
			stmt.setString(4, quantityPerUnit);
			stmt.setString(5, description);
			stmt.setString(6, picture);
			stmt.setDouble(7, unitPrice);
			stmt.setDouble(8, discount);

			stmt.execute(); // 2nd (multiple) DB roundtrips
			log.debug("1 ({})  record inserted successfully!", name);
		}catch(Exception ex) {
			log.warn("Error - {}", ex.getMessage());
		}
	}

	@Override
	public Product getProduct(int id) throws DaoException, Exception {

		String sql = "select * from products where id = ?";
		Product p = new Product();
		
		try (Connection conn = DBUtil.createConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setInt(1, id);
			
			
			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {
					
					System.out.println("Name    : " + rs.getString("name"));
					System.out.println("QPU     : " + rs.getString("quantity_per_unit"));
					System.out.println("Brand   : " + rs.getString("brand"));
					System.out.println("Category: " + rs.getString("category"));
					System.out.println("Price   : Rs." + rs.getDouble("unit_price"));
					System.out.println("Picture : " + rs.getString("picture"));
					
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
					p.setBrand(rs.getString("brand"));
					p.setCategory(rs.getString("category"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setPicture( rs.getString("picture"));
					p.setDiscount(rs.getDouble("discount"));
					p.setDescription(rs.getString("description"));
					
				} else {
					System.out.println("No data found for id " + id);
				}
			} // rs is closed

		} // conn, stmt are closed
		catch (Exception ex) {
			log.warn("Error - {}", ex);
		}
		return p;
	}

	@Override
	public void updateProduct(Product product) throws DaoException, Exception {
		if(product.getId() != 0) {
			String sqlUpdate = "update products"+" set unitPrice = ?" + "where id = ?";
			try(Connection conn = DBUtil.createConnection();
					PreparedStatement stmt = conn.prepareStatement(sqlUpdate);){
				
				stmt.setDouble(1,product.getUnitPrice() );
				stmt.setInt(2, product.getId());
				log.debug("Updated");
				
			}catch(Exception ex) {
				log.warn("There was an error {}", ex.getMessage());
			}
		}
	}

	@Override
	public void deleteProduct(int id) throws DaoException, Exception {
		if(id != 0) {
			String sqlDelete = "delete from products" + "where id = ?";
			try(Connection conn = DBUtil.createConnection();
					PreparedStatement stmt = conn.prepareStatement(sqlDelete);){
				
				stmt.setInt(1, id);
				log.debug("Record deleted");
				
			}catch(Exception ex) {
				log.warn("There was an error {}", ex.getMessage());
			}

		}
	}

	@Override
	public List<Product> getAll() throws DaoException {
		String sql = "select * from products";
		int rc = 0;
		List<Product> productsList = new ArrayList<>();
		try(
			Connection conn = DBUtil.createConnection();
			Statement stmt = conn.createStatement(); // no db round trip
			ResultSet rs = stmt.executeQuery(sql); // 1st and only db round trip
		){
			
			while(rs.next()) {
				Product p = new Product();
				rc++;
				String name = rs.getString("name");
				String qpu = rs.getString("quantity_per_unit");
				String brand = rs.getString("brand");
				String category = rs.getString("category");
				double price = rs.getDouble("unit_price");
								
				System.out.printf("%-20s %-40s %-10s %-10s %10.2f\n",
						name, qpu, brand, category, price);
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
				p.setBrand(rs.getString("brand"));
				p.setCategory(rs.getString("category"));
				p.setUnitPrice(rs.getDouble("unit_price"));
				p.setPicture( rs.getString("picture"));
				p.setDiscount(rs.getDouble("discount"));
				p.setDescription(rs.getString("description"));
				
				productsList.add(p);

			}
			log.debug("Total no.of rows = {}", rc);
		} // conn, stmt and rs get closed here
		catch(Exception ex) {
			log.warn("Error - {}", ex.getMessage());
		}
		
		return productsList;
	}

	@Override
	public List<Product> getByPriceRange(double min, double max) throws DaoException {
		String sql = "select * from products where unit_price between ? and ? order by unit_price";
		
		List<Product> productsList = new ArrayList<>();
		try(Connection conn = DBUtil.createConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);){
			
			stmt.setDouble(1, min);
			stmt.setDouble(2, max);
			
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					Product p = new Product();
					String name = rs.getString("name");
					String qpu = rs.getString("quantity_per_unit");
					String brand = rs.getString("brand");
					String category = rs.getString("category");
					double price = rs.getDouble("unit_price");
					
					System.out.printf("%-20s %-40s %-10s %-10s %10.2f\n",
							name, qpu, brand, category, price);
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
					p.setBrand(rs.getString("brand"));
					p.setCategory(rs.getString("category"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setPicture( rs.getString("picture"));
					p.setDiscount(rs.getDouble("discount"));
					p.setDescription(rs.getString("description"));
					
					productsList.add(p);

				}
			} // rs is closed
			
		} // conn, stmt are closed
		catch(Exception ex) {
			log.warn("Error - {}", ex);
		}

		return productsList;
	}

	@Override
	public List<Product> getByBrand(String brand) throws DaoException {
		String sql = "select * from products where brand = ?";
		List<Product> productsList = new ArrayList<>();
		
		try (Connection conn = DBUtil.createConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, brand);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {
					Product p = new Product();
					System.out.println("Name    : " + rs.getString("name"));
					System.out.println("QPU     : " + rs.getString("quantity_per_unit"));
					System.out.println("Brand   : " + rs.getString("brand"));
					System.out.println("Category: " + rs.getString("category"));
					System.out.println("Price   : Rs." + rs.getDouble("unit_price"));
					System.out.println("Picture : " + rs.getString("picture"));
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
					p.setBrand(rs.getString("brand"));
					p.setCategory(rs.getString("category"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setPicture( rs.getString("picture"));
					p.setDiscount(rs.getDouble("discount"));
					p.setDescription(rs.getString("description"));
					
					productsList.add(p);
					
				} else {
					System.out.println("No data found for brand " + brand);
				}
			} // rs is closed

		} // conn, stmt are closed
		catch (Exception ex) {
			log.warn("Error - {}", ex);
		}

		return productsList;
	}

	@Override
	public List<Product> getByCategory(String category) throws DaoException {
		String sql = "select * from products where category = ?";
		List<Product> productsList = new ArrayList<>();

		try (Connection conn = DBUtil.createConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, category);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {
					Product p = new Product();
					System.out.println("Name    : " + rs.getString("name"));
					System.out.println("QPU     : " + rs.getString("quantity_per_unit"));
					System.out.println("Brand   : " + rs.getString("brand"));
					System.out.println("Category: " + rs.getString("category"));
					System.out.println("Price   : Rs." + rs.getDouble("unit_price"));
					System.out.println("Picture : " + rs.getString("picture"));
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
					p.setBrand(rs.getString("brand"));
					p.setCategory(rs.getString("category"));
					p.setUnitPrice(rs.getDouble("unit_price"));
					p.setPicture( rs.getString("picture"));
					p.setDiscount(rs.getDouble("discount"));
					p.setDescription(rs.getString("description"));
					
					productsList.add(p);
				} else {
					System.out.println("No data found for category " + category);
				}
			} // rs is closed

		} // conn, stmt are closed
		catch (Exception ex) {
			log.warn("Error - {}", ex);
		}
		return productsList;
	}

}
