package org.unibl.etf.osi.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

import org.unibl.etf.osi.dto.Category;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class CategoryDAO {
	
	public static final String PATH="C:\\Users\\Marko\\eclipse-workspace\\cityEventz\\json\\categories.json";
	
	public static List<Category> getAllCategories() throws Exception{
		List<Category> retVal;
		
		Type CATEGORY_TYPE = new TypeToken<List<Category>>() {
		}.getType();
		Gson gson=new Gson();
		JsonReader reader = new JsonReader(new FileReader(PATH));
		retVal=gson.fromJson(reader, CATEGORY_TYPE);
		reader.close();
		
		return retVal;
	}
	
	public static void addCategory(String name) throws Exception {
		List<Category> categories=getAllCategories();
		Category category=new Category(categories.size(), name);
		categories.add(category);
		Gson gson = new Gson();
		FileWriter writer = new FileWriter(PATH);
		gson.toJson(categories,writer);
		writer.close();
	}
	
	public static void removeCategory(String name) throws Exception{
		List<Category> categories=getAllCategories();
		Category cat=new Category();
		for(Category c:categories) {
			if(c.getName().equals(name)) {
				cat=c;
			}
		}
		categories.remove(cat);
		Gson gson = new Gson();
		FileWriter writer = new FileWriter(PATH);
		gson.toJson(categories, writer);
		writer.close();
	}
	
	public static void main(String[] args) throws Exception {
		removeCategory("Game");
	}

}
