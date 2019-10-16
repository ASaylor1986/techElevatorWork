package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcOfficeInfoDao implements OfficeInfoDao{
	private JdbcTemplate jdbcTemplate;

@Autowired
public JdbcOfficeInfoDao(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
}

	@Override
	public List<OfficeInfo> getAllOffices() {
		List<OfficeInfo> offices = new ArrayList<OfficeInfo>();
		String sqlSelectAllOffices = "SELECT * FROM office";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllOffices);
		while(results.next()) {
			OfficeInfo office = mapResultToOffice(results);
			offices.add(office);
		}
		
		return offices;
	}
	
	@Override
	public OfficeInfo getOfficeById(int officeId) {
		  String sqlSelectOfficeById = "SELECT * FROM office WHERE officeId = ?";
	        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectOfficeById, officeId);

	        if (results.next()) {
	            return mapResultToOffice(results);
	        } else {
	            return null;
	        }
	    
	}
	@Override
	public OfficeInfo updateOfficeInfo(OfficeInfo officeInfo) {
		String sqlUpdateOfficeInfo = "UPDATE office "
				+ "SET officeName = ?, officeAddress = ?, officeCity = ?, officeState = ?, officeZip = ?, "
				+ "officePhone = ?, visitCost = ?, weekdayhours = ?, sathours = ?, sunhours = ? "
				+ "WHERE officeId = ?";
		jdbcTemplate.update(sqlUpdateOfficeInfo, officeInfo.getOfficeName(), officeInfo.getOfficeAddress(), officeInfo.getCity(), officeInfo.getState(),
				officeInfo.getZip(), officeInfo.getPhone(), officeInfo.getVisitCost(), officeInfo.getWeekdayHours(), officeInfo.getSatHours(), officeInfo.getSunHours(), officeInfo.getOfficeID());
		return officeInfo;
	}
	
	@Override
	public OfficeInfo readOffice(int officeId) {
		String sqlSelectOfficeById = "SELECT * FROM office WHERE officeId = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectOfficeById, officeId);
		if (results.next()) {
			return mapResultToOffice(results);
		} else {
		return null;
		}
	}
	
	private OfficeInfo mapResultToOffice(SqlRowSet results) {
        OfficeInfo office = new OfficeInfo();
        office.setOfficeID(results.getInt("officeid"));
        office.setOfficeName(results.getString("officename"));
        office.setOfficeAddress(results.getString("officeaddress"));
        office.setCity(results.getString("officecity"));
        office.setState(results.getString("officestate"));
        office.setZip(results.getInt("officezip"));
        office.setPhone(results.getString("officephone"));
        office.setVisitCost(results.getInt("visitcost"));
        office.setWeekdayHours(results.getString("weekdayhours"));
        office.setSatHours(results.getString("sathours"));
        office.setSunHours(results.getString("sunhours"));
        
        return office;
    }

}
