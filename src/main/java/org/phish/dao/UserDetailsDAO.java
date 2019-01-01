package org.phish.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.phish.model.User;
import org.phish.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		sessionFactory = sf;
	}
	
	public List<UserDetails> getAllUserDetails() {
		Session session = this.sessionFactory.getCurrentSession();		
		List<UserDetails> userList = session.createQuery("From UserDetails").list();
		return userList;
	}
	
	public UserDetails getUserDetails(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		UserDetails userDetails = (UserDetails)session.get(UserDetails.class,new Integer(id));
		return userDetails;
	}

	public void addUserDetails(UserDetails userDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		//session.persist(userDetails);
	}

	public void updateUserDetails(UserDetails userDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(userDetails);
		
	}

	public void deleteUserDetails(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		UserDetails userDetails = (UserDetails)session.load(UserDetails.class, new Integer(id));
		if(null !=userDetails) {
			session.delete(userDetails);
		}
		
	}
	
	public String getUserDetails(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("select u.firstName from User as u where u.username = :username");//Otan exeis hql grafeis ta onomata opws einai sto model kai oxi stin db
		q.setString("username",username );
		String userList = (String) q.uniqueResult();
		return userList;
	}


}
