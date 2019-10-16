package com.techelevator;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExample {

	public static void main(String[] args) throws SQLException {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername("postgres");
		
		
		CityDAO dao = new JDBCCityDAO(dataSource);
		
		City myCity = dao.findCityById(500);
		
		System.out.println(myCity.getName());
		System.out.println(myCity.getCountryCode());
		
		
		List<City> citiesInUSA = dao.findCityByCountryCode("USA");
		
		for (City currentCity : citiesInUSA) {
			System.out.println(currentCity.getName());
		}
		
		
		System.out.println(citiesInUSA.size());
		
		
		City canton = new City();
		canton.setName("Canton");
		canton.setDistrict("Ohio");
		canton.setCountryCode("USA");
		canton.setPopulation(100000);
		
		
		dao.save(canton);
		
		
		System.out.println(canton.getId());
		
		
		dao.delete(canton.getId());
		
		dataSource.close();

	}

}
