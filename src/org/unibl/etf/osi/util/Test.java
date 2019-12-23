package org.unibl.etf.osi.util;

import java.util.Collections;
import java.util.List;

import org.unibl.etf.osi.dao.EventDAO;
import org.unibl.etf.osi.dto.Event;

public class Test {

	public static void main(String[] args) {
		List<Event> list= EventDAO.getAllEvents();
		Collections.sort(list, EventComparator.NAME_SORT);
		for(Event e:list) {
			System.out.println(e.getName());
		}
		
		Collections.sort(list, EventComparator.TIME_SORT);
		for(Event e:list) {
			System.out.println(e.getTime());
		}
		Collections.sort(list, EventComparator.DATE_SORT);
		for(Event e:list) {
			System.out.println(e.getDate());
		}
		Collections.sort(list, EventComparator.decending(EventComparator.CATEGORY_SORT));
		for(Event e:list) {
			System.out.println(e.getCategory().getName());
		}
	}

}
