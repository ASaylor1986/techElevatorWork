package com.techelevator.projects.model.jdbc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date FROM employee";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		Employee e = null; 

		String bDate = "1980-03-15";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate firstDate = LocalDate.parse(bDate, formatter);
		String hDate = "2019-01-01";
	    LocalDate secondDate = LocalDate.parse(hDate, formatter);
	    
	    String g = "F";
	    char gender = g.charAt(0);

		while(results.next()) {
			e = new Employee();
			e.setId(results.getLong("employee_id"));
			e.setDepartmentId(results.getLong("department_id"));
			e.setFirstName(results.getString("first_name"));
			e.setLastName(results.getString("last_name"));
			e.setBirthDay(firstDate);
			e.setGender(gender);
			e.setHireDate(secondDate);
			employees.add(e);
		}
		return employees;
	}

	
	
	
	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT first_name, last_name FROM employee WHERE first_name ILIKE ? AND last_name ILIKE ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + firstNameSearch + "%", "%" + lastNameSearch + "%" );
		Employee e = null;
		
		while(results.next()) {
			e = new Employee();
			e.setFirstName(results.getString("first_name"));
			e.setLastName(results.getString("last_name"));
			employees.add(e);
		}
		
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long departmentId) {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT first_name, last_name FROM employee WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, departmentId);
		Employee e = null;
		
		while(results.next()) {
			e = new Employee();
			e.setFirstName(results.getString("first_name"));
			e.setLastName(results.getString("last_name"));
			employees.add(e);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT first_name, last_name\n" + 
				"FROM employee\n" + 
				"WHERE employee_id NOT IN (SELECT employee.employee_id\n" + 
				"FROM employee\n" + 
				"JOIN project_employee ON employee.employee_id = project_employee.employee_id)";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		Employee e = null;
		
		while(results.next()) {
			e = new Employee();
			e.setFirstName(results.getString("first_name"));
			e.setLastName(results.getString("last_name"));
			employees.add(e);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT first_name, last_name\n" + 
				"FROM employee\n" + 
				"WHERE employee_id IN (SELECT employee.employee_id\n" + 
				"FROM employee\n" + 
				"JOIN project_employee ON employee.employee_id = project_employee.employee_id\n" + 
				"WHERE project_employee.project_id = ?);";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		
		Employee e = null;
		
		while(results.next()) {
			e = new Employee();
			e.setFirstName(results.getString("first_name"));
			e.setLastName(results.getString("last_name"));
			employees.add(e);
		}
		return employees;

	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String sql = "UPDATE employee SET department_id = ? WHERE employee_id = ?";
		
		jdbcTemplate.update(sql, departmentId, employeeId);

		
	}


	@Override
	public void createEmployee(Employee newEmployee) {
		String sql = "INSERT INTO employee (department_id, first_name, last_name, birth_date, gender, hire_date) " +
				"VALUES (?, ?, ?, ?, ?, ?) RETURNING employee_id";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, newEmployee.getDepartmentId(), newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getBirthDay(), newEmployee.getGender(), newEmployee.getHireDate());

	    if(results.next()) {
			newEmployee.setId(results.getLong("employee_id"));
//			newEmployee.setDepartmentId(results.getLong("department_id"));	
		}


	}

}
