package org.phish.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.phish.model.Course;
import org.phish.model.Programme;
import org.phish.model.Syllabus;
import org.phish.model.User;
import org.phish.model.Verb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SyllabusDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		sessionFactory = sf;
	}
	
	public List<Verb> getAllVerbs() {
		Session session = this.sessionFactory.getCurrentSession();		
		List<Verb> verbList = session.createQuery("From Verb").list();
		return verbList;
	}
	
	public void addSyllabus(Syllabus syllabus) {
		Session session = this.sessionFactory.getCurrentSession();
				
			session.save(syllabus);	
		}

	public List<Syllabus> getAllSyllabus() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Syllabus> SyllabusList = session.createQuery("From Syllabus").list();
		return SyllabusList;
	}

	public  void deleteSyllabus(Course cr, Syllabus sl) {
		Session session = this.sessionFactory.getCurrentSession();
		/*Syllabus syllabus = (Syllabus)session.load(Syllabus.class, new Integer(id));
		if(null !=syllabus) {*/
		session.delete(sl);
			//session.saveOrUpdate(cr);
		
		/*}*/
		
	}

	public Syllabus getSyllabus(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Syllabus syllabus = (Syllabus)session.get(Syllabus.class,new Integer(id));
		return syllabus;
		
	}

}
