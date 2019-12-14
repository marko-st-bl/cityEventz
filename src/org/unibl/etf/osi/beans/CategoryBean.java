package org.unibl.etf.osi.beans;

import java.util.List;

import org.unibl.etf.osi.dao.CategoryDAO;
import org.unibl.etf.osi.dto.Category;

public class CategoryBean {
	
	private Category category=new Category();

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public List<Category> getAllCategories(){
		return CategoryDAO.getAllCategories();
	}
	
	public void addCategory(String name) {
		CategoryDAO.addCategory(name);
	}
	
	public void removeCategory(String name) {
		CategoryDAO.removeCategory(name);
	}

}
