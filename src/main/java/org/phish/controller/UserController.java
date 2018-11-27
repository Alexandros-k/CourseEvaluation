package org.phish.controller;

import java.util.List;

import org.phish.model.User;
import org.phish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@RequestMapping(value = "/lala/test",method = RequestMethod.POST,headers = "Accept=application/json")
	public String addUser(@ModelAttribute("user")User user) {
		
		userService.addUser(user);
		
		return "redirect:/professorsPage";
		
	}
	
	@RequestMapping(value = "/updateUser/lala/test",method = RequestMethod.POST,headers = "Accept=application/json")
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
	
	@RequestMapping(value = "lala/professorHomePage",method = RequestMethod.GET,headers = "Accept=application/json")
	public String sendToProfessorHomePage() {		
		
		return "professorHomePage";
		
	}

}
