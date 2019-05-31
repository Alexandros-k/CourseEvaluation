package org.phish.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PROGRAMME")
public class Programme implements  Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="programme_name")
	private String programme_name;
	
	@OneToMany(mappedBy="programme",orphanRemoval=true,cascade = { CascadeType.ALL },fetch = FetchType.EAGER)	
	private List<Course> courses = new ArrayList<Course>(); 

	public Programme() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProgramme_name() {
		return programme_name;
	}

	public void setProgramme_name(String programme_name) {
		this.programme_name = programme_name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	









}






