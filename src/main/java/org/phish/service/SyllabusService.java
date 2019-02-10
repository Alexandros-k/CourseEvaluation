package org.phish.service;

import java.util.List;

import org.phish.dao.SyllabusDAO;
import org.phish.model.Syllabus;
import org.phish.model.Verb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("syllabusService")
public class SyllabusService{

	@Autowired
	SyllabusDAO syllabusDAO;

	@Transactional
	public void addsyllabus(Syllabus syllabus) {
		syllabusDAO.addSyllabus(syllabus);
		
	}
	
	@Transactional
	public List<Verb> getAllVerbs() {		
		return syllabusDAO.getAllVerbs();
	}

	@Transactional
	public List<Syllabus> getAllSyllabus() {
		return syllabusDAO.getAllSyllabus();
		
	}




	
	/*@Transactional
	public User getVerb(int id) {		
		return syllabusDAO.getVerb(id);
	}
	
	@Transactional
	public void editUder(User user) {
		userDAO.updateUser(user);
		
	}
	
	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
		
	}
	
	@Transactional
	public String getUser(String username) {
		return userDAO.getUser(username);
		
	}*/
	
}
