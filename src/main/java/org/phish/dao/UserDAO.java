package org.phish.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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
		Query q = session.createQuery("select ud.firstName from UserDetails ud, User u where ud.id= u.id and u.username = :username");//Otan exeis hql grafeis ta onomata opws einai sto model kai oxi stin db
		q.setString("username",username );
		String userList = (String) q.uniqueResult();		
		return userList;
	}
	
	public int getUserId(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("select u.id from User u where u.username = :username");
		q.setString("username",username );
		int userId = (int) q.uniqueResult();		
		return userId;
	}	

	public int getUserByLastName(String lastName) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("select u.id from User u, UserDetails ud where u.id= ud.id and lastname= :lastName");//Otan exeis hql grafeis ta onomata opws einai sto model kai oxi stin db
		q.setString("lastName",lastName );
		int userList = (int) q.uniqueResult();
		return userList;
	}


}
