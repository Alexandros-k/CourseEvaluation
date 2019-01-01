package org.phish.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 int id;

	@Column(name="username")
	 String username;
	
	@Column(name="password")
	 String password;
	
	@ManyToOne(cascade = CascadeType.ALL)
	 Role role;
	

	/*@OneToOne(mappedBy="user",cascade = { CascadeType.ALL })
	UserDetails userDetails;*/
	
	/*  @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="role_id")
	     Role role;*/
	
	
	
	public User() {
		super();
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	/*public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}*/

	

	
	
	
	
	
	
	
}
