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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SyllabusController {

	@Autowired
	SyllabusService syllabusService;
	
	ArrayList<String>verbNames = new ArrayList<String>();
	ArrayList<Verb> newVerbNames = new ArrayList<Verb>();
	ArrayList<Integer>verbscount = new ArrayList<Integer>();
	 Map <String,Integer> hm = new HashMap<String, Integer>();
	 Map <String,Integer> hm1 = new HashMap<String, Integer>();
	 ArrayList<Map <String,Integer>>totalArray = new ArrayList<Map <String,Integer>>();
	
	@RequestMapping(value = "/addSyllabus",method = RequestMethod.POST,headers = "Accept=application/json")
	public  String addSyllabus(@RequestParam("courseName") String courseName) throws FileNotFoundException {		
	/*	verbNames.add("define");
		verbNames.add("describe");
		verbNames.add("label");
		verbNames.add("recall");
		verbNames.add("summarize");
	*/
		
		
		List<Verb> listOfVerbs = syllabusService.getAllVerbs();		

		FileSearch fileSearch = new FileSearch();
		
		String rootPath = System.getProperty("catalina.home");
		String filename = rootPath + File.separator + "tmpFiles" + File.separator + courseName ;;
		
		 String file="C:\\ProfessoruploadSyllabus\\syllabus\\dasa";
		
		
	 List<String> verbNames = fileSearch.parseFile(filename, listOfVerbs);
		
		for (String lucentVerb : verbNames) {
			for (Verb verb : listOfVerbs) {
				if(lucentVerb.equals(verb.getName())) {
					
					newVerbNames.add(verb);					
				}				
			}			
		}
		
		Syllabus javaSullabus = new Syllabus(courseName,newVerbNames);
		
		
		syllabusService.addsyllabus(javaSullabus);
		
		//userDetailsService.addUserDetails(user.getUserDetails());
		
		return "professorHomePage";
	}
	
	@RequestMapping(value="/statistics",method = RequestMethod.GET,headers = "Accept=application/json")
	public String getSyllabus(Model model) {
		
ArrayList<String> AttributeNames = new ArrayList<String>();
		int remember=0;
		int understand=0;
		int apply=0;
		int analyze=0;
		int evaluate=0;
		int create=0;
		
		hm.put("remember", 0);
		hm.put("understand", 0);
		hm.put("apply", 0);
		hm.put("analyze", 0);
		hm.put("evaluate", 0);
		hm.put("create", 0);
		
		AttributeNames.add("remember");
		AttributeNames.add("understand");
		AttributeNames.add("apply");
		AttributeNames.add("analyze");
		AttributeNames.add("evaluate");
		AttributeNames.add("create");
		
		
		List<Syllabus> syllabus =  syllabusService.getAllSyllabus();

		
		Map <Integer,ArrayList<String>> sortedAttr1 = sortAttributes2(syllabus);
		//Map <String,Integer> sortedAttr=sortAttributes( syllabus );
		
	/*	for(Map.Entry<Integer, ArrayList<String>> entry : sortedAttr1.entrySet()) {
		    Integer attr = entry.getKey();
		    ArrayList<String> attrValue = entry.getValue();
		  for (String attrval : attrValue) {
			
			  for(Map.Entry<String, Integer> entry1 : hm.entrySet()) {
				    String attr1 = entry1.getKey();
				    Integer attrValue1 = entry1.getValue();
				  if(attr1.equals(attrval)) {
						
						
						hm.put(attr1, attrValue1 + 1);
					}
				  
				  
			
			  
			
		  }
		}
		}*/
		
		model.addAttribute("SyllabusList",syllabus);
		model.addAttribute("VerbList",sortedAttr1);
		model.addAttribute("VerbCount",hm);
		return "statistics";
		
		
	}

	
	
	private Map <String,Integer> sortAttributes(List<Syllabus> syllabus ){
		
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
		
		return hm;
				
	}
	
	
	private Map <Integer,ArrayList<String>>  sortAttributes2(List<Syllabus> syllabus ){
		Integer counter=0;
		ArrayList<String> attributeCounter = new ArrayList<String>();
		//ArrayList<String> attributecollection = new ArrayList<String>();
		 Map <Integer,ArrayList<String>> attributecollection = new HashMap<Integer, ArrayList<String>>();
		for (Syllabus syllabi : syllabus) {
			
			List<Verb> verbs =	syllabi.getVerbs();
			
			for (Verb verb : verbs) {
			String attrName =	verb.getAttribute().getName();
		
			attributeCounter.add(attrName);
		
			}
			
			
			
			attributecollection.put(counter,new ArrayList<String>(attributeCounter));
			
			attributeCounter.clear();
			
			counter++;
			}	
		
		return attributecollection;
				
	}
	
	
	
}


	
