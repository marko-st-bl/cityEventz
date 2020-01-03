package org.unibl.etf.osi.beans;

import org.unibl.etf.osi.dao.CityDAO;
import org.unibl.etf.osi.dto.City;

public class CityBean {
	
	private City city=new City();

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	public void updateCity() {
		CityDAO.updateCity(city);
	}
	
	public City getCityInfo() {
		return CityDAO.getCity();
	}

}
