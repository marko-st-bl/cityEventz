package org.unibl.etf.osi.dto;

public class City {
	
	private int id;
	private String name;
	private String country;
	private String region;
	private int population;
	private int area;
	
	public City(String name, String country, String region, int population, int area) {
		super();
		this.name = name;
		this.country = country;
		this.region = region;
		this.population = population;
		this.area = area;
	}
	public City(int id, String name, String country, String region, int population, int area) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.region = region;
		this.population = population;
		this.area = area;
	}
	public City() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}

}
