package org.phish.service;

import java.util.List;

import org.phish.dao.ProgrammeDAO;
import org.phish.model.Course;
import org.phish.model.Programme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("programmeService")
public class ProgrammeService {

	@Autowired
	ProgrammeDAO programmeDAO;
	
	@Transactional
	public void addProgramme(Programme programme) {
		programmeDAO.addProgramme(programme);
		
	}
	@Transactional
	public List<Programme> getAllProgrammes() {		
		return programmeDAO.getAllProgrammes();
	}
	
	@Transactional
	public List<Course> getAllCourses() {		
		return programmeDAO.getAllCourses();
	}
	
	
	@Transactional
	public Programme getProgramme(int id) {
		return programmeDAO.getProgramme(id);
	}
	@Transactional
	public void addCourse(Course course) {
		programmeDAO.addCourse(course);
		
	}
	@Transactional
	public void deleteCourse(Programme programme) {
		programmeDAO.deleteCourse(programme);
		
	}
	
	@Transactional
	public Course getCourse(int id) {
		return programmeDAO.getCourse(id);
		
	}
	
	@Transactional
	public void updateCourse(Course course) {
		 programmeDAO.updateCourse(course);
		
	}
	
	@Transactional
	public int getProgrammeIdFromName(String programme_name) {
		return programmeDAO.getProgrammeId(programme_name);
		
	}
	
	@Transactional
	public void deleteProgramme(Programme programme) {
		programmeDAO.deleteProgramme(programme);
		
	}
	@Transactional
	public void updateProgramme(Programme programme) {
		programmeDAO.updateProgramme(programme);		
	}
	@Transactional
	public void editCourse(Course course) {
		programmeDAO.editCourse(course);
		
	}
	
	@Transactional
	public void editProfessor(Course course) {
		programmeDAO.editProfessor(course);
		
	}
	
	
	
}
