package org.unibl.etf.osi.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.unibl.etf.osi.beans.UserBean;
import org.unibl.etf.osi.dao.EventDAO;
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
			String name=request.getParameter("name");
			String description=request.getParameter("description");
			String category=request.getParameter("category");
			String date=request.getParameter("date");
			String time=request.getParameter("time");
			Event event=new Event(name, description, date, time, category);
			EventDAO.createEvent(event);
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
