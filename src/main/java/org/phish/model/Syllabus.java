package org.phish.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="SYLLABUS")
public class Syllabus implements Serializable {

	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private	Integer id;
	
	@Column(name="syllabus_name")
	private String syllabusName;	

	@ManyToMany(cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		},fetch = FetchType.EAGER)
    @JoinTable(
        name = "syllabus_verb", 
        joinColumns = { @JoinColumn(name = "syllabus_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "verb_id") }
    )
	private List<Verb>verbs = new ArrayList<Verb>();

	public Syllabus() {
		super();
	}

	public Syllabus(String syllabusName, List<Verb> verbs) {
		super();
		this.syllabusName = syllabusName;
		this.verbs = verbs;
	}

	public Syllabus(Integer id, String syllabusName, List<Verb> verbs) {
		super();
		this.id = id;
		this.syllabusName = syllabusName;
		this.verbs = verbs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return syllabusName;
	}

	public void setName(String syllabusName) {
		this.syllabusName = syllabusName;
	}

	public List<Verb> getVerbs() {
		return verbs;
	}

	public void setVerbs(List<Verb> verbs) {
		this.verbs = verbs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
