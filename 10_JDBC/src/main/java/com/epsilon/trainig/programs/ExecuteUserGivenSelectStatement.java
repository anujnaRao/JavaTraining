package com.epsilon.trainig.programs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.epsilon.trainig.util.DBUtil;
import com.epsilon.trainig.util.KeyBoardUtil;

public class ExecuteUserGivenSelectStatement {

	public static void main(String[] args) {
		String sql = KeyBoardUtil.getString("Enter the select statement: ");
		
		try(Connection conn = DBUtil.createConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs =  stmt.executeQuery(sql);){
			ResultSetMetaData meta = rs.getMetaData();
			String tname = meta.getTableName(1);
			
			System.out.println("From Table " + tname + "corresponding to query");
			int cc = meta.getColumnCount();
			
			for(int i = 1; i <= cc; i++) {
				System.out.print(meta.getColumnName(i)+ ",");
			}
			System.out.println();
			
			while(rs.next()) {
				for(int i = 1; i <= cc; i++) {
					System.out.print(rs.getString(i) + ",");
				}
				System.out.println();
			}
		}
		catch (Exception e) {
			System.err.println("Error: "+ e.getMessage());
		}

	}

}
