package com.spring.boot.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/about")
	public ModelAndView aboutHandler() {
		
		ModelAndView mv = new ModelAndView();	
		mv.addObject("name", "Nikita Sharma");
		mv.addObject("curr_date", new Date().toLocaleString());
		mv.setViewName("about");
	
		return mv;
	}
	
	@RequestMapping("/iterate")
	public ModelAndView iterationHandler() {
		ModelAndView mv = new ModelAndView();
		List<String> list = List.of("Ankit", "Bhuvan", "Chirag", "Dhruv", "Ethan");
		mv.addObject("names", list);
		mv.setViewName("iterator");
		return mv;
	}
	
	@RequestMapping("/conditions")
	public ModelAndView conditionsHandler() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("isActive", false);
		mv.addObject("gender", "F");
		List<String> names = new ArrayList<>();
		names.add("Ankit");
		names.add("Rakul");
		mv.addObject("listOfNames", names);
		mv.setViewName("conditions");
		return mv;
	}
	
	@RequestMapping("/fragments")
	public String showFooter() {
		return "host";
	}
}
