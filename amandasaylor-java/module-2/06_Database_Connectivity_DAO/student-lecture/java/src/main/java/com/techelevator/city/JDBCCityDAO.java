package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCCityDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void save(City newCity) {

		String sql = "INSERT INTO city (name, countrycode, district, population) " +
						"VALUES (?, ?, ?, ?) RETURNING id";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, newCity.getName(), newCity.getCountryCode(), 
				newCity.getDistrict(), newCity.getPopulation());
		
		if (results.next()) {
			
		}
		
	}

	@Override
	public City findCityById(long id) {

		City foundCity = null;
		
		String sqlFindCityById = "SELECT id, name, countrycode, district, population " + 
		"FROM city " +
		"WHERE id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById, id);
		
		if (results.next()) {
			foundCity = new City();
			foundCity.setId(results.getLong("id"));
			foundCity.setName(results.getString("name"));
			foundCity.setCountryCode(results.getString("countrycode"));
			foundCity.setDistrict(results.getString("district"));
			foundCity.setPopulation(results.getInt("population"));
		}
		
		
		return foundCity;
	}

	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		List<City> cities = new ArrayList<City>();
		
		String sql = "SELECT id, name, countrycode, district, population " + 
		"FROM city " +
		"WHERE countrycode = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, countryCode);
		
		City c = null;
		while (results.next()) {
			c = new City();
			c.setId(results.getLong("id"));
			c.setName(results.getString("name"));
			c.setCountryCode(results.getString("countrycode"));
			c.setDistrict(results.getString("district"));
			c.setPopulation(results.getInt("population"));
			cities.add(c);
			
		}
		return cities;
	}

	@Override
	public List<City> findCityByDistrict(String district) {
		
		List<City> districts = new ArrayList<City>();
		
		String sql = "SELECT id, name, countrycode, district, population " + 
		"FROM city " +
		"WHERE district = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, districts);
		
		City c = null;
		while(results.next()) {
			c = mapRowToCity(results);
			districts.add(c);
		}

		return districts;
	}

	@Override
	public void update(City city) {

		String sql = "UPDATE city " + 
		"SET name = ?, countrycode = ?, district = ?, population = ? " +
		"WHERE id = ?";
		
		jdbcTemplate.update(sql, city.getName(), city.getCountryCode(), city.getDistrict(), city.getPopulation());
	}

	@Override
	public void delete(long id) {

		
	}

	
	private City mapRowToCity(SqlRowSet rows) {
		City c = new City();
		c.setId(rows.getLong("id"));
		c.setName(rows.getString("name"));
		c.setCountryCode(rows.getString("countrycode"));
		c.setDistrict(rows.getString("district"));
		c.setPopulation(rows.getInt("population"));
		return c;
	}
	
	
	
}
