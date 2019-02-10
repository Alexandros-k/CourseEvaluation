package org.phish.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.phish.model.Syllabus;
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
		
	
	/*
	public User getUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User)session.get(User.class,new Integer(id));
		return user;
	}

	public void addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);
		
	}

	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(user);
		
	}

	public void deleteUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User)session.load(User.class, new Integer(id));
		if(null !=user) {
			session.delete(user);
		}
		
	}
	
	public String getUser(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("select u.username from User as u where u.username = :username");//Otan exeis hql grafeis ta onomata opws einai sto model kai oxi stin db
		q.setString("username",username );
		String userList = (String) q.uniqueResult();
		return userList;
	}

	*/


}
