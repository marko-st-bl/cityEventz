package org.unibl.etf.osi.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

import org.unibl.etf.osi.dto.City;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class CityDAO {

	public static final String PATH = "C:\\Users\\Marko\\eclipse-workspace\\cityEventz\\json\\categories.json";

	public static City getCity() {
		City retVal = new City();
		Type CITY_TYPE = new TypeToken<City>() {
		}.getType();
		Gson gson = new Gson();
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			retVal = gson.fromJson(reader, CITY_TYPE);
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	public static void updateCity(City city) {
		try {
			Gson gson = new Gson();
			FileWriter writer = new FileWriter(PATH);
			gson.toJson(city, writer);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
