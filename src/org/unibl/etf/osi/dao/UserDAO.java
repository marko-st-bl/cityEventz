package org.unibl.etf.osi.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.unibl.etf.osi.dto.User;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.lang.reflect.Type;

public class UserDAO {
	
	public static final String PATH="C:\\Users\\Marko\\eclipse-workspace\\cityEventz\\json\\users.json";
	
	public static User getUserByUsernamePassword(String username, String password){
		User retVal;
		
		List<User> users;
		Type USER_TYPE = new TypeToken<List<User>>() {
		}.getType();
		Gson gson=new Gson();
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			users=gson.fromJson(reader, USER_TYPE);
			reader.close();
			
			for(User user:users) {
				if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
					retVal = user;
					return retVal;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	
}
