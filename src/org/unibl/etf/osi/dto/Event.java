package org.unibl.etf.osi.dto;


public class Event {
	
	private int id;
	private String name;
	private String description;
	private String date;
	private String time;
	private String address;
	private Category category;
	
	public Event(int id, String name, String description, String date, String time, String address, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.address=address;
		this.time=time;
		this.category=category;
	}
	
	public Event(String name, String description, String date, String time, String address, String category) {
		super();
		this.name=name;
		this.description=description;
		this.date=date;
		this.time=time;
		this.address=address;
		this.category=new Category();
		this.category.setName(category);
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
