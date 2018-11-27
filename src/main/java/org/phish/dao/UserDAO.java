package org.phish.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.phish.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		sessionFactory = sf;
	}
	
	public List<User> getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();		
		List<User> userList = session.createQuery("From User").list();
		return userList;
	}
	
	public User getUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User)session.get(User.class,new Integer(id));
		return user;
	}

	public void addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
	}

	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		
	}

	public void deleteUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User)session.load(User.class, new Integer(id));
		if(null !=user) {
			session.delete(user);
		}
		
	}
	
	

}
