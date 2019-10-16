package com.techelevator.model;

import java.util.List;

public interface OfficeInfoDao {
	//get list of offices
	public List<OfficeInfo> getAllOffices();
	
	public OfficeInfo getOfficeById(int officeId);
	
	public OfficeInfo updateOfficeInfo(OfficeInfo officeInfo);
	
	public OfficeInfo readOffice(int officeId);
}