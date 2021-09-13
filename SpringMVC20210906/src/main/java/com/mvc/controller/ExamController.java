package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.entity.Exam;

@Controller
@RequestMapping("/exam")
public class ExamController {
  
	@RequestMapping(value = {"/" , "/index"})
	public String index(Model model) {
	  Exam e = new Exam();
	  model.addAttribute("exam" , e) ; 
	  return "exam";
  }
}
