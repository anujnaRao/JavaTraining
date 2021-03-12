package com.epsilon.trainig.programs;

import java.sql.Connection;
import java.sql.Statement;

import com.epsilon.trainig.util.DBUtil;
import com.epsilon.trainig.util.KeyBoardUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InsertUsingStatement {

	public static void main(String[] args) {
		System.out.println("Enter new product details: ");
		int id = KeyBoardUtil.getInt("ID             : ");
		String name = KeyBoardUtil.getString("Name           : ");
		String brand = KeyBoardUtil.getString("Brand          : ");
		String category = KeyBoardUtil.getString("Category       : ");
		String quantityPerUnit = KeyBoardUtil.getString("QPU            : ");
		String description = KeyBoardUtil.getString("Description    : ");
		String picture = KeyBoardUtil.getString("Picture        : ");
		double unitPrice = KeyBoardUtil.getDouble("Unit price     : ");
		double discount = KeyBoardUtil.getDouble("Discount       : ");
		
		String sql = String.format(
				"insert into products values(null, '%s', '%s','%s', '%s', '%s', '%s', %f, %f)",
				name, brand, category, quantityPerUnit, description, picture, unitPrice, discount);
		
		try(Connection conn = DBUtil.createConnection();
				Statement stmt = conn.createStatement();){
			
			conn.setAutoCommit(false);
			stmt.execute(sql);
			conn.commit();
			
			log.debug("Done");
		}catch(Exception ex) {
			log.warn("There was an error {}", ex.getMessage());
		}
	}

}
