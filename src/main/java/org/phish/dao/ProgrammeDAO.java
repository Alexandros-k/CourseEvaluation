package org.phish.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.phish.model.Course;
import org.phish.model.Programme;
import org.phish.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProgrammeDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		sessionFactory = sf;
	}
	
	public List<Programme> getAllProgrammes() {
		Session session = this.sessionFactory.getCurrentSession();		
		List<Programme> programmeList = session.createQuery("From Programme").list();
		return programmeList;
	}
	
	public List<Course> getAllCourses() {
		Session session = this.sessionFactory.getCurrentSession();		
		List<Course> courseList = session.createQuery("From Course").list();
		return courseList;
	}
	

	public void addProgramme(Programme programme) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(programme);
		
	}

	public Programme getProgramme(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Programme programme = (Programme)session.get(Programme.class,new Integer(id));
		return programme;
	}

	public void addCourse(Course course) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(course);
		
	}
	
	public void updateCourse(Course course) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(course);
		
	}

	public void deleteCourse(Programme programme) {
		Session session = this.sessionFactory.getCurrentSession();
		//session.clear();
		/*Course course = (Course)session.load(Course.class, new Integer(id));
		if(null !=course) {			
			*/
			session.update(programme);
		//}
		
		
	}

	public Course getCourse(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Course course = (Course)session.get(Course.class,new Integer(id));
		return course;
		
	}
	
	public int getProgrammeId(String programme_name) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("select p.id from Programme p where p.programme_name = :programme_name");
		q.setString("programme_name",programme_name );
		int programmeId = (int) q.uniqueResult();		
		return programmeId;
	}

	public void deleteProgramme(Programme programme) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(programme);
	}

	public void updateProgramme(Programme programme) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(programme);
		
	}

	public void editCourse(Course course) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(course);		
	}

	
	public void editProfessor(Course course) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(course);
	}	
	
	
	

}
