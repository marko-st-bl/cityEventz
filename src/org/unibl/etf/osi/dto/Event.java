package org.unibl.etf.osi.dto;

import java.util.Date;
import java.util.List;

public class Event {
	
	private int id;
	private String name;
	private String description;
	private Date date;
	private List<Category> categories;
	
	public Event(int id, String name, String description, Date date, List<Category> categories) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.categories=categories;
	}
	
	public Event() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}	

}
