package com.spring.boot.controllers;

import java.util.Date;

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
}
