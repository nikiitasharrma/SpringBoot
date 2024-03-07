package com.spring.boot.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
	
	@GetMapping("/about")
	public ModelAndView aboutHandler() {
		
		ModelAndView mv = new ModelAndView();	
		mv.addObject("name", "Nikita Sharma");
		mv.addObject("curr_date", new Date().toLocaleString());
		mv.setViewName("about");
	
		return mv;
	}
	
	@GetMapping("/iterate")
	public ModelAndView iterationHandler() {
		ModelAndView mv = new ModelAndView();
		List<String> list = List.of("Ankit", "Bhuvan", "Chirag", "Dhruv", "Ethan");
		mv.addObject("names", list);
		mv.setViewName("iterator");
		return mv;
	}
	
	@GetMapping("/conditions")
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
	
	@GetMapping("/fragments")
	public ModelAndView showFooter() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "Project title");
		mv.addObject("subtitle", LocalDateTime.now().toString());
		mv.setViewName("host");
		return mv;
	}
	
	@GetMapping("/inheritance")
	public ModelAndView showPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name","Nikita");
		mv.setViewName("contact");
		return mv;
	}
}
