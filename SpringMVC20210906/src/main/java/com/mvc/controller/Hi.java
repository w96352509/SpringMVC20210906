package com.mvc.controller;

import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping(value = "/hi")
public class Hi {
	
	@RequestMapping(value = "/{welcome}")
	@ResponseBody
	public String greet(@PathVariable("welcome")String welcome,
			            @RequestParam("name")String name) {
		//�ѨM������D
		//�w�]�s�X:ISO-8859-1
		//���ܽs�X:UTF-8
		try {
			welcome=new String(welcome.getBytes("ISO-8859-1"), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return welcome+name;
	}
	//=@RequestMapping
	@GetMapping("/sayhi") //���wget
	@ResponseBody
	public ModelAndView sayhi() {
		ModelAndView mav = new ModelAndView();
		//mav.setViewName("/WEB-INF/view/sayhi.jsp"); //��V���W��
		mav.setViewName("sayhi"); //��springmvc-servlet.xml �����w�q view
		mav.addObject("username","John");
		return mav ;
	}
}

