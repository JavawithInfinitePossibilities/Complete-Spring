/**
 * 
 */
package com.tutorials.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Siddhant sahu URL to go : http://localhost:8080/Spring-MVC/welcome
 *
 */
@Controller
public class WelcomeController {

	@RequestMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("welcomeMessage", "Welcome to spring MVC tutorials...:)");
		return "welcome";
	}
}
