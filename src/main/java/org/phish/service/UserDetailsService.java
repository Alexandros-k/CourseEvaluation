package org.phish.service;

import java.util.List;


import org.phish.dao.UserDetailsDAO;
import org.phish.model.User;
import org.phish.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailsService {	

	@Autowired
	UserDetailsDAO userDetailsDAO;

	@Transactional
	public void addUserDetails(UserDetails userDetails) {
		userDetailsDAO.addUserDetails(userDetails);
	}
	
	@Transactional
	public List<UserDetails> getAllUserDetails() {		
		return userDetailsDAO.getAllUserDetails();
	}
	
	@Transactional
	public UserDetails getUserDetails(int id) {		
		return userDetailsDAO.getUserDetails(id);
	}
	
	@Transactional
	public void editUserDetails(UserDetails userDetails) {
		userDetailsDAO.updateUserDetails(userDetails);
		
	}
	
	@Transactional
	public void deleteUserDetails(int id) {
		userDetailsDAO.deleteUserDetails(id);
		
	}
	
	@Transactional
	public String getUserDetails(String username) {
		return userDetailsDAO.getUserDetails(username);
		
	}
	
}
