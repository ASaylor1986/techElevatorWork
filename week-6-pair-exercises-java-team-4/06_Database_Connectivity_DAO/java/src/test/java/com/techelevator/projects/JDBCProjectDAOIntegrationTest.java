package com.techelevator.projects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;

public class JDBCProjectDAOIntegrationTest {

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private JDBCProjectDAO dao;
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

		dao = new JDBCProjectDAO(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);

	}
	
	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void test_get_all_active_projects() {
		// Arrange
//		jdbcTemplate.update("DELETE FROM project_employee");
//		jdbcTemplate.update("DELETE FROM employee");
//		jdbcTemplate.update("DELETE FROM department");
//		jdbcTemplate.update("DELETE FROM project");
		
		
		
		String startDate = "2015-03-15";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate firstDate = LocalDate.parse(startDate, formatter);
		
	    String endDate = "2016-05-18";
	    formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate secondDate = LocalDate.parse(endDate, formatter);
	    
	    String secondStartDate = "2017-03-15";
	    formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate thirdDate = LocalDate.parse(secondStartDate, formatter);
		
	    String secondEndDate = "2020-05-18";
	    formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate fourthDate = LocalDate.parse(secondEndDate, formatter);
	    
	    String firstQuery = "INSERT INTO project (name, from_date, to_date) VALUES (?, ?, ?)";
	    jdbcTemplate.update(firstQuery, "Test Project B", thirdDate, firstDate);
	    
	    // Act
	    List<Project> returnedProjects = new ArrayList();
	    returnedProjects = dao.getAllActiveProjects();
	    System.out.println(returnedProjects.size());
	    boolean projectInList = false;
	    for (Project project : returnedProjects) {
	    	System.out.println(project.getName());
	    }
	    
	    // Assert
	    assertEquals(2, returnedProjects.size());
	  

	}
	
	
	@Test 
	public void removing_employee_from_a_project() {
		// Arrange
		dao.addEmployeeToProject(new Long(5), new Long(3));

		// Act
		dao.removeEmployeeFromProject(new Long(5), new Long(3));
		
		String myQuery = "SELECT project_id, employee_id FROM project_employee WHERE project_id = 5";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(myQuery);
		
		boolean isInTable = false;
		while(results.next()) {
			if (results.getLong("employee_id") == 3) {
				isInTable = true;
				break;
			}	
		}
		
		// Assert
		assertFalse(isInTable);
	}
	
	
	@Test
	public void adding_an_employee_to_a_project() {
		//Arrange
		jdbcTemplate.update("DELETE FROM project_employee");
		jdbcTemplate.update("DELETE FROM employee");
		jdbcTemplate.update("DELETE FROM department");
		jdbcTemplate.update("DELETE FROM project");
		
		
		String bstr = "1993-06-05";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate birthDate = LocalDate.parse(bstr, formatter);
  
		Employee newEmployee = new Employee();
		newEmployee.setFirstName("Adam");
		newEmployee.setLastName("Smith");
		newEmployee.setBirthDay(birthDate);
		newEmployee.setGender('M');
		newEmployee.setHireDate(birthDate);
		
		String sstr = "2015-06-05";
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDate = LocalDate.parse(sstr, formatter);
		
		String estr = "2020-06-05";
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate endDate = LocalDate.parse(estr, formatter);
		
		Project newProject = new Project();
		newProject.setName("Test Project");
		newProject.setStartDate(startDate);
		newProject.setEndDate(endDate);
		
		
	    String myQuery = ("INSERT INTO project (name, from_date, to_date) VALUES (?, ?, ?) RETURNING project_id");
	    
	    SqlRowSet projectResults = jdbcTemplate.queryForRowSet(myQuery, newProject.getName(), newProject.getStartDate(), newProject.getEndDate());
	    
	    if (projectResults.next()) {
	    	newProject.setId(projectResults.getLong("project_id"));
	    }

	    String myNewQuery = ("INSERT INTO employee (first_name, last_name, birth_date, gender, hire_date) "
	    		+ "VALUES (?, ?, ?, ?, ?) RETURNING employee_id");
	    
	    SqlRowSet employeeResults = jdbcTemplate.queryForRowSet(myNewQuery, newEmployee.getFirstName(), newEmployee.getLastName(), 
	    		newEmployee.getBirthDay(), newEmployee.getGender(), newEmployee.getHireDate());
	    Long employeeId = null;
	    if (employeeResults.next()) {
	    	employeeId = employeeResults.getLong("employee_id");
	    }
		//Act
		dao.addEmployeeToProject(newProject.getId(), employeeId);
		String finalQuery = "SELECT employee_id FROM project_employee WHERE project_id = ? AND employee_id = ?";
	    SqlRowSet results = jdbcTemplate.queryForRowSet(finalQuery, newProject.getId(), employeeId);
	    Long testEmployeeId = null;

	    if (results.next()) {
	    	testEmployeeId = results.getLong("employee_id");
	    }	    
	    
	    //Assert
		assertEquals((long) testEmployeeId, (long) employeeId);
		
		
	}
}
