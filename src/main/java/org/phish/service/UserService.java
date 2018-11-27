package org.phish.service;

import java.util.List;



import org.phish.dao.UserDAO;
import org.phish.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
public class UserService{

	@Autowired
	UserDAO userDAO;

	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);
	}
	
	@Transactional
	public List<User> getAllUsers() {		
		return userDAO.getAllUsers();
	}
	
	@Transactional
	public User getUser(int id) {		
		return userDAO.getUser(id);
	}
	
	@Transactional
	public void editUder(User user) {
		userDAO.updateUser(user);
		
	}
	
	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
		
	}
}
