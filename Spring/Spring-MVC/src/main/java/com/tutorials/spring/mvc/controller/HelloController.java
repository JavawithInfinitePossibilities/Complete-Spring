/**
 * 
 */
package com.tutorials.spring.mvc.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tutorials.spring.mvc.bean.InformationDetails;

/**
 * @author Siddhant sahu URL to go : http://localhost:8080/Spring-MVC/
 *         <h1>${pageContext.request.contextPath}</h1> to get access to the project path
 */
@Controller
public class HelloController {

	@RequestMapping("/formElements")
	public ModelAndView getValueFormElement(
			@Valid @RequestAttribute("info") InformationDetails details,
			BindingResult bindingResult) {
		List<String> courses = getCourse();
		Date today = new Date();
		ModelAndView model = new ModelAndView("formElements");
		model.addObject("firstName", details.getFirstName());
		model.addObject("lastName", details.getLastName());
		model.addObject("gender", details.getGender());
		model.addObject("citizen", details.getCitizen());
		model.addObject("state", details.getState());
		model.addObject("district", details.getDistrict());
		model.addObject("description", details.getDescription());
		model.addObject("likes", details.getLikes());
		model.addObject("flower", details.getFlower());
		model.addObject("courses", courses);
		model.addObject("today", today);
		if (bindingResult.hasErrors()) {
			model.setViewName("index");
		}
		return model;
	}

	@RequestMapping("/requestParamModel")
	public ModelAndView getValueFromrequestParam(@RequestParam("user") String name) {
		List<String> courses = getCourse();
		Date today = new Date();
		ModelAndView model = new ModelAndView("requestParamModel");
		model.addObject("name", name);
		model.addObject("courses", courses);
		model.addObject("today", today);
		return model;
	}

	@RequestMapping("/complexModelMapping")
	public ModelAndView getValueFromComplexModelAndView(HttpServletRequest request) {
		String name = request.getParameter("userId");
		List<String> courses = getCourse();
		Date today = new Date();
		ModelAndView model = new ModelAndView("complexModelMapping");
		model.addObject("name", name);
		model.addObject("courses", courses);
		model.addObject("today", today);
		return model;
	}

	@RequestMapping("/modelMapping")
	public String getValueFromModel(HttpServletRequest request, Model model) {
		String name = request.getParameter("username");
		model.addAttribute("formName", name);
		return "modelMapping";

	}

	@RequestMapping("/hello")
	public String helloWorld() {
		return "hello";
	}

	/*
	 * This is the welcome page controller.
	 */
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index", "info", new InformationDetails());
		Map<String, String> citizen = new HashMap<>();
		citizen.put("Indian", "Indian");
		citizen.put("Non Indian", "Non Indian");
		modelAndView.addObject("citizen", citizen);
		Map<String, String> distract = new LinkedHashMap<>();
		distract.put("Bangalore", "Bangalore");
		distract.put("Mandia", "Mandia");
		distract.put("Mangalore", "Mangalore");
		distract.put("Udupi", "Udupi");
		modelAndView.addObject("distract", distract);
		Map<String, String> flower = new LinkedHashMap<>();
		flower.put("Rose", "Rose");
		flower.put("Loutes", "Loutes");
		flower.put("Night queen", "Night queen");
		modelAndView.addObject("flower", flower);
		return modelAndView;

	}

	private List<String> getCourse() {
		List<String> courses = Arrays.asList("Course on spring framework", "JSP,Servlet and JSTL",
				"JAVA for biginner", "Test and improve your JAVA skil", "Multithreading in java");
		return courses;
	}
}
