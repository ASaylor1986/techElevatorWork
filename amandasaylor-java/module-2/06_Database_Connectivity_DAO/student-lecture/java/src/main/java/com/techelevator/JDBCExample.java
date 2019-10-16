package com.techelevator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class JDBCExample {

	public static void main(String[] args) throws SQLException {
		
		/* This datasource will be used for creating connections to the database.
		 * Below, we provide the information required to make database connections */
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dataSource.setUsername("postgres");
		
		Connection conn = dataSource.getConnection();
		
		/* Create a Statement object so that we can execute a SQL Query */
		Statement stmt = conn.createStatement();
		
		String filmsUnder90Min = "SELECT title, length FROM film WHERE length < 90;";
		
		ResultSet results = stmt.executeQuery(filmsUnder90Min);
		
		while (results.next()) {
			String title = results.getString("title");
			int length = results.getInt("length");
			
//			System.out.format("%-25s%-10d\n", title, length);
			
		}
//		System.out.print("Enter a length: ");
		
		int timeEnteredByUser = 120;
		
		String filmsQuery = "SELECT title, length FROM film WHERE length < 90;" + timeEnteredByUser;
		
		
		results = stmt.executeQuery(filmsUnder90Min);
		
		while (results.next()) {
			String title = results.getString("title");
			int length = results.getInt("length");
			
//			System.out.format("%-25s%-10d\n", title, length);
		}
		
		String firstName = "Zero";
		String lastName = "Cage";
		String filmStarringActor = "SELECT title " +
				"FROM film " +
				"JOIN film_actor ON film_actor.film_id = film.film_id " +
				"JOIN actor ON actor.actor_id = film_actor.actor_id " +
				"WHERE first_name = ? AND last_name = ?;";
		
		PreparedStatement filmStarringActorStmt = conn.prepareStatement(filmStarringActor);
		filmStarringActorStmt.setString(1, firstName.toUpperCase());
		filmStarringActorStmt.setString(2, lastName.toUpperCase());
		
		results = filmStarringActorStmt.executeQuery();
		
		while (results.next()) {
			System.out.println(results.getString("title"));
		}
		dataSource.close();
	}
}
