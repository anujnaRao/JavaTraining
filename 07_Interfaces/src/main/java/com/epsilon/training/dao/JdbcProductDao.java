package com.epsilon.training.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import com.epsilon.training.utils.DBUtil;
import com.epsilon.training.utils.KeyBoardUtil;

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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return ProductDao.super.getAll();
	}

	@Override
	public List<Product> getByPriceRange(double min, double max) throws DaoException {
		// TODO Auto-generated method stub
		return ProductDao.super.getByPriceRange(min, max);
	}

	@Override
	public List<Product> getByBrand(String brand) throws DaoException {
		// TODO Auto-generated method stub
		return ProductDao.super.getByBrand(brand);
	}

	@Override
	public List<Product> getByCategory(String category) throws DaoException {
		// TODO Auto-generated method stub
		return ProductDao.super.getByCategory(category);
	}

}
