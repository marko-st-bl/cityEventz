package org.unibl.etf.osi.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.osi.dto.Category;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class CategoryDAO {
	
	public static final String PATH="C:\\Users\\Marko\\eclipse-workspace\\cityEventz\\json\\categories.json";
	
	public static List<Category> getAllCategories(){
		List<Category> retVal=new ArrayList<>();
		
		Type CATEGORY_TYPE = new TypeToken<List<Category>>() {
		}.getType();
		Gson gson=new Gson();
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			retVal=gson.fromJson(reader, CATEGORY_TYPE);
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public static void addCategory(String name) {
		List<Category> categories;
		try {
			categories = getAllCategories();
			Category category=new Category(categories.size(), name);
			categories.add(category);
			Gson gson = new Gson();
			FileWriter writer = new FileWriter(PATH);
			gson.toJson(categories,writer);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void removeCategory(String name){
		List<Category> categories;
		try {
			categories = getAllCategories();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
