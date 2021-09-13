package com.mvc.controller;

import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		//解決中文問題
		//預設編碼:ISO-8859-1
		//改變編碼:UTF-8
		try {
			welcome=new String(welcome.getBytes("ISO-8859-1"), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return welcome+name;
	}
	//=@RequestMapping
	@GetMapping("/sayhi") //指定get
	@ResponseBody
	public ModelAndView sayhi() {
		ModelAndView mav = new ModelAndView();
		//mav.setViewName("/WEB-INF/view/sayhi.jsp"); //渲染器名稱
		mav.setViewName("sayhi"); //於springmvc-servlet.xml 中有定義 viewResolver 標籤的寫法
		mav.addObject("username","John");
		return mav ;
	}
	@GetMapping("/sayhi2") //指定get
	//不可以加@ResponseBody
	public String sayhi2(Model model) {
		model.addAttribute("username","Mary");
		return "sayhi" ; //直接回傳就是view的名字(字串)
	}
}

