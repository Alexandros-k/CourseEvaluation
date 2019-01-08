package org.phish.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.phish.model.User;
import org.phish.model.UserDetails;
import org.phish.service.UserDetailsService;
import org.phish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserDetailsService userDetailsService;

	
	@RequestMapping(value = "/admin", method = RequestMethod.GET,headers = "Accept=application/json")
	public String displayAdminPage(Model model) {
		
	
		
		return "adminStartingPage";
	}
	
	@RequestMapping(value = "/professorsPage", method = RequestMethod.GET,headers = "Accept=application/json")
	public String displayMainPage(Model model) {
		
		List<User> listOfUsers = userService.getAllUsers();		
		model.addAttribute("listOfUsers",listOfUsers);
	
		
		return "professors";
	}
	
	
	@RequestMapping(value="/addProfessor", method = RequestMethod.GET)
	public String RedirectToAddUser(Model model) {
		
		
		
		model.addAttribute("user",new User());
		
		return "addProfessor" ;		
		
	}
	
	
	@RequestMapping(value = "/test",method = RequestMethod.POST,headers = "Accept=application/json")
	public String addUser(@ModelAttribute("user")User user) {		
		if(user.getCourses()!=null) {
			user.getCourses().get(0).setUser(user);
			
		}
		
		
		userService.addUser(user);
		
		// find course
		// if not exist create course
		// user.getCourses.add the course
		// save again the user
		
		// userdetails
		//course
		
		
		//userDetailsService.addUserDetails(user.getUserDetails());
		
		return "redirect:/professorsPage";
		
	}
	
	@RequestMapping(value = "/updateUser/test",method = RequestMethod.POST,headers = "Accept=application/json")
	public String updateUser(@ModelAttribute("user")User user) {		
		
		userService.editUder(user);
		
		return "redirect:/professorsPage";
		
	}
	
	@RequestMapping(value= "/deleteUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteUser(@PathVariable("id")int id) {
		userService.deleteUser(id);
		return "redirect:/professorsPage";
	}
	
	@RequestMapping(value = "/updateUser/{id}",method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateUser(@PathVariable("id") int id,Model model) {
		model.addAttribute("user",this.userService.getUser(id));
		
		return "addProfessor";
		
	}
	
	@RequestMapping(value = "/professorHomePage",method = RequestMethod.GET,headers = "Accept=application/json")
	public String sendToProfessorHomePage(Principal principal,Model model) {	
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String username = authentication.getName();
		
		String userlist = userService.getUser(username);		
	
		model.addAttribute("firstname",userlist);
		return "professorHomePage";
		
	}

}
