package org.unibl.etf.osi.controller;

import java.io.IOException;

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
import org.unibl.etf.osi.dao.EventDAO;
import org.unibl.etf.osi.dto.Category;
import org.unibl.etf.osi.dto.Event;

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
