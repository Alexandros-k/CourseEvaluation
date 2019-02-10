package org.phish.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.phish.helper.FileSearch;
import org.phish.model.Attribute;
import org.phish.model.Syllabus;
import org.phish.model.Verb;
import org.phish.service.SyllabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SyllabusController {

	@Autowired
	SyllabusService syllabusService;
	
	ArrayList<String>verbNames = new ArrayList<String>();
	ArrayList<Verb> newVerbNames = new ArrayList<Verb>();
	ArrayList<Integer>verbscount = new ArrayList<Integer>();
	 Map <String,Integer> hm = new HashMap<String, Integer>();
	
	
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
	
	@RequestMapping(value="/statistics",method = RequestMethod.GET,headers = "Accept=application/json")
	public String getSyllabus(Model model) {
		

		
		
		hm.put("remember", 0);
		hm.put("understand", 0);
		hm.put("apply", 0);
		hm.put("analyze", 0);
		hm.put("evaluate", 0);
		hm.put("create", 0);
		
		List<Syllabus> syllabus =  syllabusService.getAllSyllabus();
	for (Syllabus syllabi : syllabus) {
			
		List<Verb> verbs =	syllabi.getVerbs();
		
		for (Verb verb : verbs) {
		String attrName =	verb.getAttribute().getName();
		
		for(Map.Entry<String, Integer> entry : hm.entrySet()) {
		    String attr = entry.getKey();
		    int attrValue = entry.getValue();
		  
			if(attrName.equals(attr)) {
				
				
				hm.put(attr, attrValue + 1);
			}
		}
		}
		}	
		
	
			
		model.addAttribute("SyllabusList",syllabus);
		model.addAttribute("VerbList",hm);
		return "statistics";
		
		
	}

	
	
	
	
}


	
