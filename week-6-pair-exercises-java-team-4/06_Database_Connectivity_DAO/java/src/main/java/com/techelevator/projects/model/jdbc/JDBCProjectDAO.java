package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {
		List<Project> projects = new ArrayList<Project>();
		String sql = "SELECT name FROM project WHERE from_date IS NOT NULL AND (to_date > CURRENT_DATE OR to_date ISNULL);";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		Project p = null;
		
		while(results.next()) {
			p = new Project();
			p.setName(results.getString("name"));
			projects.add(p);
		}
		return projects;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sqlCreateEmployee = "INSERT INTO project_employee (project_id, employee_id) VALUES (?, ?)";
		jdbcTemplate.update(sqlCreateEmployee, projectId, employeeId);
	}

}
