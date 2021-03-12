package com.epsilon.trainig.programs;

import java.sql.Connection;
import java.sql.Statement;

import com.epsilon.trainig.util.DBUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateTable {

	public static void main(String[] args) {
		String sqlCmd = "create table products(\r\n"
				+ "    id int primary key auto_increment,\r\n"
				+ "    name varchar(50) not null,\r\n"
				+ "    brand varchar(50) not null,\r\n"
				+ "    category varchar(50) not null,\r\n"
				+ "    quantity_per_unit varchar(255) not null,\r\n"
				+ "    description varchar(255) not null,\r\n"
				+ "    picture varchar(255) not null,\r\n"
				+ "    unit_price double,\r\n"
				+ "    discount double\r\n"
				+ ");\r\n"
				+ "";
		try(Connection conn = DBUtil.createConnection();
				Statement stmt = conn.createStatement();){
			stmt.execute(sqlCmd);
			log.debug("SQL Command executed");
		}catch(Exception ex) {
			log.warn("There was an error {}", ex.getMessage());
		}
	}

}
