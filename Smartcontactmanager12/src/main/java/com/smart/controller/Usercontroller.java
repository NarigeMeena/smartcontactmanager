package com.smart.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smart.dao.Userrepository;
import com.smart.entites.User;

@RestController
@RequestMapping("/user")
public class Usercontroller {
	
	@Autowired
	private Userrepository userrepository;

	@RequestMapping("/index")
	public ModelAndView dashboard(Model model, Principal principal) {
		String userName = principal.getName();
		System.out.println("USERNAME " + userName);

		User user = userrepository.getUserByUserName(userName);
		System.out.println("USER" + user);
		model.addAttribute("User", user);
		// get the user using username(Email)
		return new ModelAndView("normal/user_dashboard.html");
	}
	// @RequestMapping("index")
	//// public ModelAndView dashboard( Model model,Principal principal)
	// {
//		String userName=principal.getName();
	// User user=userRepository.getUserByUserName(userName);
	// System.out.println("USER"+user);
	// model.addAttribute("user", user);
	// return new ModelAndView("normal/user_dashbord.html");
}
