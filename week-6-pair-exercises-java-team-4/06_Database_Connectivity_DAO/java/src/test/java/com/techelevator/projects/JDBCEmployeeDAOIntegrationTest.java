package com.techelevator.projects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;


public class JDBCEmployeeDAOIntegrationTest {
	
	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private JDBCEmployeeDAO dao;
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

		dao = new JDBCEmployeeDAO(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);

	}
	
	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	
	
	@Test
	public void test_get_all_employees() {

		
		List<Employee> results = dao.getAllEmployees();
		
		int i = 0;
		for(Employee employee: results) {
			i++;
		}
		assertNotNull(results);
		assertEquals(i, results.size());

		}
	
	
	@Test
	public void test_search_employees_by_name() {
		//Arrange
		String bDate = "1980-03-15";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate firstDate = LocalDate.parse(bDate, formatter);
		String hDate = "2019-01-01";
	    LocalDate secondDate = LocalDate.parse(hDate, formatter);
	    String g = "F";
	    char gender = g.charAt(0);
	    
	    
		Employee newEmp = new Employee();
		newEmp.setDepartmentId(new Long(1));
		newEmp.setFirstName("Cinder");
		newEmp.setLastName("Ella");
		newEmp.setBirthDay(firstDate);
		newEmp.setGender(gender);
		newEmp.setHireDate(secondDate);
		newEmp.toString();
		dao.createEmployee(newEmp);
		
		//Act 
		List<Employee> results = dao.searchEmployeesByName("Cinder", "Ella");
		
		assertNotNull(results);
		Employee testEmp = results.get(0);
		assertEquals(1, results.size());
		assertEquals("Cinder", testEmp.getFirstName());
		assertEquals("Ella", testEmp.getLastName());
	}
	 
	
	@Test
	public void test_get_employee_by_department_id() {
		


		List<Employee> empList = dao.getEmployeesByDepartmentId(new Long(1));
		
		int i = 0;
		for(Employee employee: empList) {
			i++;
		}
		
		assertNotNull(empList);
		assertEquals(i, empList.size());
	}
	
	@Test
	public void test_get_employees_without_a_project() {
		List <Employee> projEmp = dao.getEmployeesWithoutProjects();
		int i = 0;
		for(Employee employee: projEmp) {
			i++;
		}
		assertNotNull(projEmp);
		assertEquals(i, projEmp.size());
		
	}
	
	@Test
	public void test_get_employee_by_project_id() {
	
		List<Employee> projList = dao.getEmployeesByProjectId(new Long(1));
		int i = 0;
		for(Employee employee: projList) {
			i++;
		}
		assertNotNull(projList);
		assertEquals(i, projList.size());
	}
	
	@Test
	public void test_change_employee_department() {

//		jdbcTemplate.update("DELETE FROM employee");
//		jdbcTemplate.update("DELETE FROM department");
//		Employee newEmp = new Employee();
//		newEmp.setDepartmentId(new Long(22));
//		dao.createEmployee(newEmp);
//		newEmp.setDepartmentId(new Long(45));
//		dao.update(newEmp);
//		
//		List<Employee> deptEmp = dao.getEmployeesByDepartmentId(newEmp.getDepartmentId());
//		dao.changeEmployeeDepartment(newEmp.getId(), newEmp.getDepartmentId());
//		assertEquals(new Long(45), newEmp.getDepartmentId());
	}
}


	


