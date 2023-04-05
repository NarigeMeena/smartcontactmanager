package com.smart.controller;
import javax.servlet.http.HttpSession;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.smart.dao.Userrepository;
import com.smart.entites.User;
import com.smart.helper.Message;



@Controller
public class Homecontroller {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private Userrepository userrepository;
	
	
	
      @RequestMapping("/")
      public String home(Model model) {
    	  model.addAttribute("title","Home- smart contact");
    	  return "home";
      }
    	  @RequestMapping("/about")
          public String about(Model model) {
        	  model.addAttribute("title", "About -smart contact");
        	  return "about";
      }
    	 
    	  @RequestMapping("signup")
    	  public String signup(Model model) {
    		  model.addAttribute("title", "register -smart contact");
    		  model.addAttribute("user",new User());
    		  
    		  return"signup";
    	  }

    	 	 
    	  @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    		public String registerUser( @ModelAttribute("user") User user,BindingResult result1,
    				@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,
    				HttpSession session) {

    			try {

    				if (!agreement) {

    					System.out.println("You have not agreed terms and conditions");
    					throw new Exception("You have not agreed terms and conditions");
    				}
    				
    				if(result1.hasErrors()) {
    					
    					System.out.println("ERROR "+result1.toString());
    					model.addAttribute("user",user);
    					return "signup";
    				}

    				user.setRole("ROLE_USER");
    				user.setEnabled(true);
    				user.setImageurl("register.png");
    			    user.setPassword(passwordEncoder.encode(user.getPassword()));

    				System.out.println("Agreement " + agreement);
    				System.out.println("USER " + user);

    				User result = this.userrepository.save(user);

    				model.addAttribute("user", new User());

    				session.setAttribute("message", new Message("Successfully Registered !!", "alert-success"));
    				return "signup";

    			} catch (Exception e) {
    				e.printStackTrace();
    				model.addAttribute("user", user);
    				session.setAttribute("message", new Message("something went wrong !!" + e.getMessage(), "alert-danger"));
    				return "signup";
    			}}
    			 //handler for custom login
    			@RequestMapping("/login")
    			public String customLogin(Model model) {
    				
    				model.addAttribute("title","Login page");
    				return "login";

    		}
    		  
    		 
}
    	  


