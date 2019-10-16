package com.techelevator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class JDBCTransactionExample {

	public static void main(String[] args) throws SQLException {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dataSource.setUsername("postgres");
		
		Connection conn = dataSource.getConnection();
		
		Statement stmt = conn.createStatement();
		
		conn.setAutoCommit(false);
					
		stmt.execute("INSERT INTO actor (first_name, last_name) VALUES ('KEANU', 'REEVES')");
		
		String lastActorsQuery = "SELECT first_name || ' ' || last_name AS full_name FROM actor WHERE actor_id > 190";
		
		ResultSet results = stmt.executeQuery(lastActorsQuery);
		
		while (results.next()) {			
			System.out.println(results.getString("full_name"));			
		}
			
		conn.rollback();
		
		System.out.println("*****************");

		results = stmt.executeQuery(lastActorsQuery);
		
		while (results.next()) {			
			System.out.println(results.getString("full_name"));			
		}
		
		dataSource.close();
	}

}
