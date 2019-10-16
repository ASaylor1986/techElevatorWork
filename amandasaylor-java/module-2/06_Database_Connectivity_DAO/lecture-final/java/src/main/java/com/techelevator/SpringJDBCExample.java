package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/* Working with JDBC entails a lot of boilerplate code which can become 
 * tedious and error prone. The Spring JBDC framework can help eliminate 
 * much of the boilerplate code, and limit the tedium and mistakes. */
public class SpringJDBCExample {

	public static void main(String[] args) {
		
		/* This datasource will be used for creating connections to the database.
		 * Below, we provide the information required to make database connections */
		BasicDataSource dvdstoreDataSource = new BasicDataSource();
		dvdstoreDataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dvdstoreDataSource.setUsername("postgres");
		
		/* The JdbcTemplate is the main interface we use to interact with databases using
		 * Spring JDBC. */
		JdbcTemplate dvdstoreJdbcTemplate = new JdbcTemplate(dvdstoreDataSource);
		
		String filmsUnder90Min = "SELECT title, length FROM film WHERE length < 90;";
		
		SqlRowSet results = dvdstoreJdbcTemplate.queryForRowSet(filmsUnder90Min);
		
		while (results.next()) {
			
			String title = results.getString("title");
			int length = results.getInt("length");
			
			//System.out.format("%-25s %-10d\n", title, length);
			
		}
		
		
		String firstName = "Zero";
		String lastName = "Cage";
		
		String filmsStarringActor = "SELECT title " + 
				"FROM film " + 
				"JOIN film_actor ON film_actor.film_id = film.film_id " + 
				"JOIN actor ON actor.actor_id = film_actor.actor_id " + 
				"WHERE actor.first_name = ? AND actor.last_name = ?;";
		
		results = dvdstoreJdbcTemplate.queryForRowSet(filmsStarringActor, firstName.toUpperCase(), lastName.toUpperCase());
		
		while (results.next()) {
			//System.out.println(results.getString("title"));
		}
		
		String sqlCreateActor = "INSERT INTO actor (first_name, last_name) VALUES (?, ?)";
		
		firstName = "Davy";
		lastName = "Jones";
		int rowCount = dvdstoreJdbcTemplate.update(sqlCreateActor, firstName.toUpperCase(), lastName.toUpperCase());
		System.out.println(rowCount);
		
		String sqlDeleteActor = "DELETE FROM actor WHERE first_name = ? AND last_name = ?";
		rowCount = dvdstoreJdbcTemplate.update(sqlDeleteActor, firstName.toUpperCase(), lastName.toUpperCase());
		System.out.println(rowCount);

		
	}
}
