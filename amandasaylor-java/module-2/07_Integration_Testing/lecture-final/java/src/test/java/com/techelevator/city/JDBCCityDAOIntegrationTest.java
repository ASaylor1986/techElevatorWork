package com.techelevator.city;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JDBCCityDAOIntegrationTest {

	private static final String TEST_COUNTRY = "XYZ";
	private static final String TEST_COUNTRY_2 = "WTF";
	private static final String TEST_DISTRICT = "Test District";
	
	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private JDBCCityDAO dao;
	
	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername("postgres");
		/* The following line disables autocommit for connections 
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}
	
	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL, 'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);
		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY_2);
		
		dao = new JDBCCityDAO(dataSource);
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	
	private City createTestCity() {
		City c = new City();
		c.setName("Test City");
		c.setDistrict(TEST_DISTRICT);
		c.setCountryCode(TEST_COUNTRY);
		c.setPopulation(1);
		return c;
	}
	
	
	private void assertCityMatchesTestData(City c) {
		assertEquals("Test City", c.getName());
		assertEquals(TEST_DISTRICT, c.getDistrict());
		assertEquals(TEST_COUNTRY, c.getCountryCode());
		assertEquals(1, c.getPopulation());
	}
	

	@Test
	public void create_new_city_and_read_it_back() {
		//Arrange
		City newCity = createTestCity();
		//Act
		dao.create(newCity);
		City testCity = dao.findCityById(newCity.getId());
		//Assert
		assertNotNull(newCity.getId());
		assertEquals(newCity.getId(), testCity.getId());
		assertCityMatchesTestData(testCity);
	}
	
	@Test
	public void finds_a_city_by_country_code() {
		City newCity = createTestCity();
		dao.create(newCity);
		
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);
		
		assertNotNull(results);
		assertEquals(1, results.size());
		City testCity = results.get(0);
		assertCityMatchesTestData(testCity);
	}
	
	@Test
	public void finds_multiple_cities_by_country_code() {
		for (int i = 0; i < 100; i++) {
			City newCity = createTestCity();
			newCity.setName(newCity.getName() + i);
			dao.create(newCity);
		}
		
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);
		
		assertNotNull(results);
		assertEquals(100, results.size());		
	}
	
	@Test
	public void finds_a_city_by_district() {
		City newCity = createTestCity();
		dao.create(newCity);
		
		List<City> results = dao.findCityByDistrict(TEST_DISTRICT);
		
		assertNotNull(results);
		assertEquals(1, results.size());
		City testCity = results.get(0);
		assertCityMatchesTestData(testCity);
	}
	
	@Test
	public void delete_city_for_id() {
		City newCity = createTestCity();
		dao.create(newCity);
		
		dao.delete(newCity.getId());
		
		City testCity = dao.findCityById(newCity.getId());
		assertNull(testCity);
	}
	
	
	@Test
	public void updates_city_to_match_object() {		
		City newCity = createTestCity();
		dao.create(newCity);
		
		newCity.setName("Updated City");
		newCity.setDistrict("Updated District");
		newCity.setCountryCode(TEST_COUNTRY_2);
		newCity.setPopulation(2);
		dao.update(newCity);
		
		City c = dao.findCityById(newCity.getId());
		assertNotNull(c);
		assertEquals("Updated City", c.getName());
		assertEquals("Updated District", c.getDistrict());
		assertEquals(TEST_COUNTRY_2, c.getCountryCode());
		assertEquals(2, c.getPopulation());		
	}
	
	
}
