package org.unibl.etf.osi.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.unibl.etf.osi.beans.CategoryBean;
import org.unibl.etf.osi.beans.EventBean;
import org.unibl.etf.osi.beans.UserBean;
import org.unibl.etf.osi.dao.CategoryDAO;
import org.unibl.etf.osi.dto.Category;
import org.unibl.etf.osi.dto.Event;
import org.unibl.etf.osi.util.EventComparator;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String address = "/WEB-INF/pages/index.jsp";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if(action == null || action.equals("")) {
			address="/WEB-INF/pages/index.jsp";
		}else if(action.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserBean userBean = new UserBean();
			if(userBean.login(username, password)) {
				session.setAttribute("userBean", userBean);
				address="/WEB-INF/pages/admin.jsp";
			}
		}else if(action.equals("createevent")){
			address="/WEB-INF/pages/createEvent.jsp";
		}else if(action.equals("addevent")) {
			address="/WEB-INF/pages/admin.jsp";
			String name=request.getParameter("name");
			String description=request.getParameter("description");
			String category=request.getParameter("category");					//getCategoryByName(name)
			String date=request.getParameter("date");
			String time=request.getParameter("time");
			String location=request.getParameter("address");
			EventBean eventBean=new EventBean();
			Event event=new Event(name, description, date, time, location, category);
			eventBean.setEvent(event);
			eventBean.addEvent();
		}else if(action.equals("addcategory")) {
			address="/WEB-INF/pages/admin.jsp";
			String name=request.getParameter("name");
			Category category=new Category(name);
			CategoryDAO.addCategory(category);
		}else if(action.equals("createcategory")) {
			address="/WEB-INF/pages/createcategory.jsp";
		}else if(action.equals("logout")) {
			session.invalidate();
			address = "/WEB-INF/pages/index.jsp";
		}else if(action.equals("showcategories")) {
			address="/WEB-INF/pages/showcategories.jsp";
		}else if(action.equals("deletecategory")) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			CategoryBean category= new CategoryBean();
			category.setCategory(new Category(Integer.parseInt(id), name));
			category.removeCategory();
		}else if(action.equals("showtodays")) {
			address="/WEB-INF/pages/todaysevents.jsp";
		}else if(action.equals("showupcoming")) {
			address="/WEB-INF/pages/upcomingevents.jsp";
		}else if(action.equals("showpast")) {
			address="/WEB-INF/pages/pastevents.jsp";
		}else if(action.equals("showall")) {
			address="/WEB-INF/pages/allevents.jsp";
		}else if(action.equals("sort")) {
			String sortBy = request.getParameter("sortBy");
			String order = request.getParameter("order");
			address="/WEB-INF/pages/allevents.jsp";
			EventBean eventBean=new EventBean();
			List<Event> events = eventBean.getAllEvents();
			switch(sortBy) {
				case "Name":
					if(order.equals("Ascending")) {
						Collections.sort(events, EventComparator.NAME_SORT);
					}else {
						Collections.sort(events, EventComparator.decending(EventComparator.NAME_SORT));
					}
					break;
				case "Date":
					if(order.equals("Ascending")) {
						Collections.sort(events, EventComparator.DATE_SORT);
					}else {
						Collections.sort(events, EventComparator.decending(EventComparator.DATE_SORT));
					}
					break;
				case "Time":
					if(order.equals("Ascending")) {
						Collections.sort(events, EventComparator.TIME_SORT);
					}else {
						Collections.sort(events, EventComparator.decending(EventComparator.TIME_SORT));
					}
					break;
				case "Category":
					if(order.equals("Ascending")) {
						Collections.sort(events, EventComparator.CATEGORY_SORT);
					}else {
						Collections.sort(events, EventComparator.decending(EventComparator.CATEGORY_SORT));
					}
					break;
			}
			session.setAttribute("sortedList", events);
		}else if(action.equals("showbycategory")) {
			String name = request.getParameter("name");
			System.out.print(name);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
