/**
 * 
 */
package com.tutorials.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tutorials.spring.mvc.bean.Exercise;

/**
 * @author Siddhant sahu URL to go : http://localhost:8080/Spring-MVC/fitnessTracker
 *
 */
@Controller
public class FitnessTrackerController {

	@RequestMapping("/fitnessTracker")
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {
		System.out.println("Exercise :" + exercise.getMinutes());
		// return "forward:addMinutes";
		return "redirect:addMinutes";
	}

	@RequestMapping("/addMinutes")
	public String addMoreMinutes(@ModelAttribute("exercise") Exercise exercise) {
		System.out.println("Exercise add more minutes:" + exercise.getMinutes());
		return "fitnessTracker";
	}
}
