package org.unibl.etf.osi.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.unibl.etf.osi.dto.Event;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class EventDAO {

	public static final String PATH = "C:\\Users\\Marko\\eclipse-workspace\\cityEventz\\json\\events.json";

	public static List<Event> getAllEvents() {
		List<Event> retVal = new ArrayList<>();
		Type EVENT_TYPE = new TypeToken<List<Event>>() {
		}.getType();
		Gson gson = new Gson();
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			retVal = gson.fromJson(reader, EVENT_TYPE);
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	public static void createEvent(Event event) {
		List<Event> events = getAllEvents();
		event.setId(events.size());
		events.add(event);

		try {
			Gson gson = new Gson();
			FileWriter writer = new FileWriter(PATH);
			gson.toJson(events, writer);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void updateEvent(Event event) {
		List<Event> events = getAllEvents();
		int i=-1;
		for(Event e:events) {
			if(e.getId()==event.getId()) {
				i=events.indexOf(e);
				break;
			}
		}
		if(i!= -1) {
			events.remove(i);
		}
		
		try {
			Gson gson = new Gson();
			FileWriter writer = new FileWriter(PATH);
			gson.toJson(events, writer);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Event> getTodaysEvent(){
		List<Event> events= getAllEvents();
		List<Event> todays=new ArrayList<>();
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String today=sdf.format(date);
		for(Event e:events) {
			if(e.getDate().equals(today)) {
				todays.add(e);
			}
		}
		return todays;
	}

	public static List<Event> getUpcomingEvents() {
		List<Event> events= getAllEvents();
		List<Event> upcoming=new ArrayList<>();
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String today=sdf.format(date);
		String[] todaysParams=today.split("-");
		int todayYear = Integer.parseInt(todaysParams[0]);
		int todayDate = Integer.parseInt(todaysParams[1].concat(todaysParams[2]));
		for(Event e:events) {
			String[] dateParams=e.getDate().split("-");
			int eYear = Integer.parseInt(dateParams[0]);
			int eDate = Integer.parseInt(dateParams[1].concat(dateParams[2]));
			if(eYear >= todayYear && eDate > todayDate) {
				upcoming.add(e);
			}
		}
		return upcoming;
	}
	
	public static List<Event> getPastEvents(){
		List<Event> events= getAllEvents();
		List<Event> past=new ArrayList<>();
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String today=sdf.format(date);
		String[] todaysParams=today.split("-");
		int todayYear = Integer.parseInt(todaysParams[0]);
		int todayDate = Integer.parseInt(todaysParams[1].concat(todaysParams[2]));
		for(Event e:events) {
			String[] dateParams=e.getDate().split("-");
			int eYear = Integer.parseInt(dateParams[0]);
			int eDate = Integer.parseInt(dateParams[1].concat(dateParams[2]));
			if(eYear <= todayYear && eDate < todayDate) {
				past.add(e);
			}
		}
		return past;
	}

	public static List<Event> getByCategory(String name) {
		List<Event> all= getAllEvents();
		List<Event> events=new ArrayList<>();
		for(Event e:all) {
			if(e.getCategory().getName().equals(name)) {
				events.add(e);
			}
		}
		return events;
	}
}
