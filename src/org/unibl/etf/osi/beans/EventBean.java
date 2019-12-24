package org.unibl.etf.osi.beans;

import java.util.List;

import org.unibl.etf.osi.dao.EventDAO;
import org.unibl.etf.osi.dto.Event;

public class EventBean {

	private Event event=new Event();
	
	public EventBean() {
		super();
	}
	
	public EventBean(int id) {
		this.event=EventDAO.getEventById(id);
	}
	
	public void setEvent(Event event) {
		this.event=event;
	}
	public Event getEvent() {
		return this.event;
	}
	
	public void addEvent() {
		EventDAO.createEvent(event);
	}
	public void updateEvent() {
		EventDAO.updateEvent(event);
	}
	public void removeEvent() {
		EventDAO.removeEvent(event);
	}
	public List<Event> getAllEvents() {
		return EventDAO.getAllEvents();
	}
	public List<Event> getTodaysEvents(){
		return EventDAO.getTodaysEvent();
	}
	public List<Event> getUpcomingEvents(){
		return EventDAO.getUpcomingEvents();
	}
	public List<Event> getPastEvents(){
		return EventDAO.getPastEvents();
	}
	public List<Event> getByCategory(String name){
		return EventDAO.getByCategory(name);
	}
}
