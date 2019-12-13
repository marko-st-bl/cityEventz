package org.unibl.etf.osi.beans;

import org.unibl.etf.osi.dto.User;

import org.unibl.etf.osi.dao.UserDAO;

public class UserBean {
	
	private User user=new User();
	private boolean loggedIn;
	
	public boolean login(String username, String password){
		if ((user = UserDAO.getUserByUsernamePassword(username, password))!=null){
			loggedIn = true;
			return true;
		}
		return false;
	}
	
	public void logout(){
		user = new User();
		loggedIn = false;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
	
}
