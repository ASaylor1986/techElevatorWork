package com.techelevator.projects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;


import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;

public class JDBCDepartmentDAOIntegrationTest {
	
	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private JDBCDepartmentDAO dao;
	private JdbcTemplate jdbcTemplate;

	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
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

		dao = new JDBCDepartmentDAO(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);

	}
	
	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void test_get_all_departments() {
		// Arrange
		jdbcTemplate.update("DELETE FROM project_employee");
		jdbcTemplate.update("DELETE FROM employee");
		jdbcTemplate.update("DELETE FROM department");
		

		
		Department newDepartment;
		int i;
		for (i = 1; i < 4; i++) {
			newDepartment = new Department();
			newDepartment.setName("Test Department " + i);
			dao.createDepartment(newDepartment);
			
		}
		
		
		//Act
		List<Department> results = dao.getAllDepartments();
		
		//Assert
		
		assertNotNull(results);
		assertEquals(i-1, results.size());
		
	}
	
	@Test
	public void test_finds_department_by_name() {
		//Arrange
			Department newDept = new Department();
			newDept.setName("Test Department");
			
			
			dao.createDepartment(newDept);
			
			//Act 
			List<Department> results = dao.searchDepartmentsByName("Test Department");
			
			assertNotNull(results);
			assertEquals(1, results.size());
			Department testDept = results.get(0);
			assertEquals("Test Department", testDept.getName());
	}
	
	@Test
	public void test_saves_the_department_name() {
		//Arrange 
		Department newDept = new Department();
		newDept.setName("Test Department");
		dao.createDepartment(newDept);
		
		newDept.setName("Updated Department");
		
		dao.saveDepartment(newDept);
		
		Department d = dao.getDepartmentById(newDept.getId());
		
		assertNotNull(d);
		assertEquals("Updated Department", d.getName());
	}
	
	
	
}
