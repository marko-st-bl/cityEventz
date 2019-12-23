package org.unibl.etf.osi.util;

import java.util.Comparator;

import org.unibl.etf.osi.dto.Event;
public enum EventComparator implements Comparator<Event> {
	
	NAME_SORT{
		public int compare(Event e1, Event e2) {
			return e1.getName().compareTo(e2.getName());
		}
	},
	DATE_SORT{
		public int compare(Event e1, Event e2) {
			return e1.getDate().compareTo(e2.getDate());
		}
	},
	CATEGORY_SORT{
		public int compare(Event e1, Event e2) {
			return e1.getCategory().getName().compareTo(e2.getCategory().getName());
		}
	},
	TIME_SORT{
		public int compare(Event e1, Event e2) {
			return e1.getTime().compareTo(e2.getTime());
		}
	};
	
	 public static Comparator<Event> decending(final Comparator<Event> other) {
	        return new Comparator<Event>() {
	            public int compare(Event o1, Event o2) {
	                return -1 * other.compare(o1, o2);
	            }
	        };
	    }
	 

}
