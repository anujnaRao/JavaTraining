package com.epsilon.trainig.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.epsilon.trainig.util.DBUtil;
import com.epsilon.trainig.util.KeyBoardUtil;

public class GetAuotoGenratePrimaryKey {

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
		
		String sql =  "insert into products values(null, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection conn = DBUtil.createConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
			stmt.setString(1, category);
			stmt.setString(2, name);
			stmt.setString(3, category);
			stmt.setString(4, category);
			stmt.setString(5, category);
			stmt.setString(6, category);
			stmt.setString(7, category);
			stmt.setString(8, category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
