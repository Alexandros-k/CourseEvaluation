package org.phish.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.phish.helper.FileSearch;
import org.phish.model.Syllabus;
import org.phish.model.Verb;
import org.phish.service.SyllabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SyllabusController {

	@Autowired
	SyllabusService syllabusService;
	
	ArrayList<String>verbNames = new ArrayList<String>();
	ArrayList<Verb> newVerbNames = new ArrayList<Verb>();
	

	
	
	@RequestMapping(value = "/addSyllabus",method = RequestMethod.POST,headers = "Accept=application/json")
	public  String addSyllabus() throws FileNotFoundException {		
	/*	verbNames.add("define");
		verbNames.add("describe");
		verbNames.add("label");
		verbNames.add("recall");
		verbNames.add("summarize");
	*/
		
		
		List<Verb> listOfVerbs = syllabusService.getAllVerbs();		

		FileSearch fileSearch = new FileSearch();
		
		String rootPath = System.getProperty("catalina.home");
		String filename = rootPath + File.separator + "tmpFiles" ;
		
		 String file="C:\\ProfessoruploadSyllabus\\syllabus\\dasa";
		
		
	 List<String> verbNames = fileSearch.parseFile(file, listOfVerbs);
		
		for (String lucentVerb : verbNames) {
			for (Verb verb : listOfVerbs) {
				if(lucentVerb.equals(verb.getName())) {
					
					newVerbNames.add(verb);					
				}				
			}			
		}
		
		Syllabus javaSullabus = new Syllabus("python",newVerbNames);
		
		
		syllabusService.addsyllabus(javaSullabus);
		
		//userDetailsService.addUserDetails(user.getUserDetails());
		
		return "professorHomePage";
	}

}


	
