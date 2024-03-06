package com.spring.boot.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/about")
	public ModelAndView aboutHAndler() {
		
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
}
