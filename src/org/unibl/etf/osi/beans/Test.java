package org.unibl.etf.osi.beans;

import java.util.List;

import org.unibl.etf.osi.dto.Event;

public class Test {

	public static void main(String[] args) {
		EventBean bean=new EventBean();
		
		List<Event> events = bean.getAllEvents();
		for(Event e:events) {
			System.out.println(e.getName());
		}
		
		System.out.println("------------------");

		List<Event> todays = bean.getTodaysEvents();
		for(Event e:todays) {
			System.out.println(e.getDate());
		}
		
		
		System.out.println("------------------");
		
		List<Event> upcoming = bean.getUpcomingEvents();
		for(Event e:upcoming) {
			System.out.println(e.getDate());
		}
		
		System.out.println("------------------");
		
		List<Event> past = bean.getPastEvents();
		for(Event e:past) {
			System.out.println(e.getDate());
	}
	}

}
