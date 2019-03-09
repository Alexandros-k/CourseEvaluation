package org.phish.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.phish.helper.FileSearch;
import org.phish.model.Attribute;
import org.phish.model.AttributeDTO;
import org.phish.model.Syllabus;
import org.phish.model.User;
import org.phish.model.Verb;
import org.phish.service.SyllabusService;
import org.phish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SyllabusController {

	@Autowired
	SyllabusService syllabusService;
	
	@Autowired
	UserService userService;
	
	ArrayList<String>verbNames = new ArrayList<String>();
	ArrayList<Verb> newVerbNames = new ArrayList<Verb>();
	ArrayList<Integer>verbscount = new ArrayList<Integer>();
	LinkedHashMap <String,Integer> hm = new LinkedHashMap<String, Integer>();
	
	
	@RequestMapping(value = "/addSyllabus",method = RequestMethod.POST,headers = "Accept=application/json")
	public  String addSyllabus(@RequestParam("courseName")String name ,Model model) throws FileNotFoundException {		
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String username = authentication.getName();
		
		String userlist = userService.getUser(username);		
	
		model.addAttribute("firstname",userlist);
		try {
		List<Verb> listOfVerbs = syllabusService.getAllVerbs();		

		FileSearch fileSearch = new FileSearch();
		
		String rootPath = System.getProperty("catalina.home");
		String filename = rootPath + File.separator + "tmpFiles" + File.separator + name +".txt" ;		
		
		
		
	 List<String> verbNames = fileSearch.parseFile(filename, listOfVerbs);
		
	 for (String lucentVerb : verbNames) {
			for (Verb verb : listOfVerbs) {
				if(lucentVerb.equals(verb.getName())) {
					
					if (!newVerbNames.contains(verb)) {
						newVerbNames.add(verb);	
					}										
				}				
			}			
		}
		
		Syllabus javaSyllabus = new Syllabus(name,newVerbNames);
		
		List<Syllabus> listOfSyllabus =	syllabusService.getAllSyllabus();
		for (Syllabus syllabus : listOfSyllabus) {
			if (syllabus.getName().equals(javaSyllabus.getName())) {
				
				String message ="You failed to import " + name	+ " file allready exist.";
				model.addAttribute("errorMessage", message);
				return "professorHomePage";	
			}
		}
		syllabusService.addsyllabus(javaSyllabus);
		 String message = "You successfully import file " + name;
			model.addAttribute("message", message);
		return "professorHomePage";		
		}catch(Exception e) {
			String message = "You failed to import file " + name + " => " + e.getMessage();
			model.addAttribute("errorMessage", message);
			return "professorHomePage";
		}
	}
	
	@RequestMapping(value="/statistics",method = RequestMethod.GET,headers = "Accept=application/json")
	public String getSyllabus(Model model) {
		
		ArrayList<AttributeDTO> attributeList = new ArrayList<AttributeDTO>();
		
		
		hm.put("remember", 0);
		hm.put("understand", 0);
		hm.put("apply", 0);
		hm.put("analyze", 0);		
		hm.put("evaluate", 0);
		hm.put("create", 0);
		
		
	
		
		List<Syllabus> syllabus =  syllabusService.getAllSyllabus();
		for (Syllabus syllabi : syllabus) {
			int counter=0;		
			attributeList.add(counter, createAttribute(syllabi));
			
			List<Verb> verbs =	syllabi.getVerbs();
			for (Verb verb : verbs) {
				String attrName =	verb.getAttribute().getName();
				
				for(Map.Entry<String, Integer> entry : hm.entrySet()) {
				    String attr = entry.getKey();
				    int attrValue = entry.getValue();
				  
					if(attrName.equals(attr)) {
						attrValue+=1;
						
						hm.put(attr, attrValue);
					}
				}
				}
			
		}	
		
	
			
		model.addAttribute("SyllabusList",syllabus);
		model.addAttribute("VerbList",attributeList);
		model.addAttribute("Verb",hm);
		return "statistics";
		
		
	}

	@RequestMapping(value= "/deleteSyllabus/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteSyllabus(@PathVariable("id")int id) {
		syllabusService.deleteSyllabus(id);
		return "redirect:/statistics";
	}
	
	public AttributeDTO createAttribute(Syllabus  syllabus) {
		AttributeDTO attr = new AttributeDTO();
		
		attr.setId(syllabus.getId());
			
			List<Verb> verbs =	syllabus.getVerbs();
			
			for (Verb verb : verbs) {
				String attrName =	verb.getAttribute().getName();		
				attr.setName(syllabus.getName());
				if(attrName.equals("remember")) {
					attr.setRemeberCounter(attr.getRemeberCounter()+1);
				}else if(attrName.equals("understand")) {
					attr.setUnderstandCounter(attr.getUnderstandCounter()+1);
				}else if(attrName.equals("apply")) {
					attr.setApplyCounter(attr.getApplyCounter()+1);
				}else if(attrName.equals("analyze")) {
					attr.setAnalyzeCounter(attr.getAnalyzeCounter()+1);
				}else if(attrName.equals("evaluate")) {
					attr.setEvaluateCounter(attr.getEvaluateCounter()+1);
				}else if(attrName.equals("create")) {
					attr.setCreateCounter(attr.getCreateCounter()+1);
				}	
			
			
				}
							
			
		return attr;

	}
}




