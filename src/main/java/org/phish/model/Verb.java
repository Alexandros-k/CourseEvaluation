package org.phish.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VERB")
public class Verb implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private	Integer id;
	
	@Column(name="name")
	private String name;

	@ManyToOne
	@JoinColumn(name="attribute_id")
	private Attribute attribute;

	
/*	@ManyToMany(mappedBy = "verbs")
	private Set<Syllabus>syllabus = new HashSet<>();
	*/
	
	public Verb() {
		super();
	}
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

/*	public Set<Syllabus> getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(Set<Syllabus> syllabus) {
		this.syllabus = syllabus;
	}
*/
	

		
}
