package org.phish.controller;

import java.util.List;

import org.phish.model.Course;
import org.phish.model.Programme;
import org.phish.model.User;
import org.phish.service.ProgrammeService;
import org.phish.service.SyllabusService;
import org.phish.service.UserDetailsService;
import org.phish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProgrammeController {

	@Autowired
	ProgrammeService programmeService;
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "/programmePage", method = RequestMethod.GET,headers = "Accept=application/json")
	public String displayAdminPage(Model model) {
		
		List<Programme> listOfProgrammes = programmeService.getAllProgrammes();		
		model.addAttribute("listOfProgrammes",listOfProgrammes);	
		
		return "programme";
	}
	
	@RequestMapping(value="/addProgramme", method = RequestMethod.GET)
	public String RedirectToAddProgramme(Model model) {		
		
		model.addAttribute("programme",new Programme());
		
		return "addProgramme" ;		
		
	}
	
	@RequestMapping(value = "/addProgrammeToDb",method = RequestMethod.POST,headers = "Accept=application/json")
	public String addProgramme(@ModelAttribute("programme")Programme programme) {			
			
		programmeService.addProgramme(programme);		
		
		return "redirect:/programmePage";
		
	}
	
	@RequestMapping(value="/addCourse/{id}", method = RequestMethod.GET)
	public String RedirectToAddCourse(Model model,@PathVariable("id")int id) {
		
		Programme pr =this.programmeService.getProgramme(id);
		
		Course cr = new Course();
		
		cr.setProgramme(pr);
		
		
		model.addAttribute("course", cr);		
		
		return "addCourse" ;		
		
	}
	
	@RequestMapping(value = "/addCourse/test/addCourseToDb",method = RequestMethod.POST,headers = "Accept=application/json")
	public String addCourse(@ModelAttribute("course")Course course) {				
			
		programmeService.addCourse(course);		
		
		return "redirect:/programmePage";
		
	}
	
	@RequestMapping(value= "/deleteCourse/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCourse(@PathVariable("id")int id) {
		
	Course cr =	programmeService.getCourse(id);
	List<Course> courseList = cr.getProgramme().getCourses();
	
	Programme programme =cr.getProgramme();
	
	courseList.remove(cr);
		
		programmeService.deleteCourse(cr.getProgramme());
		
		return "redirect:/programmePage";
	}
	
	@RequestMapping(value= "/deleteProgramme/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteProgramme(@PathVariable("id")int id) {
		
	Programme pr =	programmeService.getProgramme(id);		
		
		programmeService.deleteProgramme(pr);
		
		return "redirect:/programmePage";
	}
	
	@RequestMapping(value= "/updateProgramme/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateProgramme(@PathVariable("id")int id,Model model) {
		
		model.addAttribute("programme",this.programmeService.getProgramme(id));
		
		return "addProgramme" ;	
	}
	
	@RequestMapping(value = "/updateProgramme/addProgrammeToDb",method = RequestMethod.POST,headers = "Accept=application/json")
	public String updateProgramme(@ModelAttribute("programme")Programme programme) {			
			
		programmeService.updateProgramme(programme);		
		
		return "redirect:/programmePage";
		
	}
	
	@RequestMapping(value= "/addProfessorToCourse/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String addProfessor(@PathVariable("id")int id,Model model) {
		
		Course cr = this.programmeService.getCourse(id);
		
		model.addAttribute("course", cr);
		
		return "addProfessorToCourse";
	}
	
	@RequestMapping(value = "addProfessorToCourse/test/addProfessorToCourse",method = RequestMethod.POST,headers = "Accept=application/json")
	public String addProfessorToCourse(@ModelAttribute("course")Course course) {		
	
		
		String lName=course.getUser().getUserDetails().getLastName();
		
		int userId= userService.getUserByLastName(lName);		
		
		course.getUser().setId(userId);
			
		programmeService.updateCourse(course);		
		
		return "redirect:/programmePage";
		
	}
	
	
	@RequestMapping(value= "/editCourse/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String editCourse(@PathVariable("id")int id,Model model) {
		
		model.addAttribute("course",this.programmeService.getCourse(id));
		
		return "addCourse" ;	
	}
	
	@RequestMapping(value = "/editCourse/test/addCourseToDb",method = RequestMethod.POST,headers = "Accept=application/json")
	public String updateCourse(@ModelAttribute("course")Course course) {				
			
		programmeService.editCourse(course);		
		
		return "redirect:/programmePage";
		
	}
	
/*	@RequestMapping(value= "/reAssignProfessor/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String reAssignProfessor(@PathVariable("id")int id,Model model) {
		
		model.addAttribute("course",this.programmeService.getCourse(id));
		
		return "addProfessorToCourse" ;	
	}
	
	@RequestMapping(value = "/reAssignProfessor/test/addProfessorToCourse",method = RequestMethod.POST,headers = "Accept=application/json")
	public String updateProfessor(@ModelAttribute("course")Course course) {
		
		programmeService.editProfessor(course);	
		
		return "redirect:/programmePage";
	}
	*/
}
