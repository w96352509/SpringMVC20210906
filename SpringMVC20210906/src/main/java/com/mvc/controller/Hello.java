package com.mvc.controller;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello")
public class Hello {
	
	@RequestMapping(value = "/greet")
	@ResponseBody
	public String greet() {
		return "Hello Greet !";
	}
	
	/*
	 * ���|�G/sayhi?name=vincent&age=18
	 * �a�J�Gname �P age �G�ӰѼ�
	 * */
	@RequestMapping(value = "/sayhi")
	@ResponseBody
	public String sayHi(@RequestParam(value = "name", defaultValue = "unknown", required = false) String name, 
			            @RequestParam("age") Integer age) {
		
		return "Hello " + name + ", " + age;
	}
	
	/*
	 * Lab:
	 * ���|�G/bmi?h=170&w=60
	 * �a�J�Gh �P w �G�ӰѼ�
	 * ���G�Gbmi = 20.76
	 * */
	@RequestMapping(value = "/bmi")
	@ResponseBody
	public String bmi(@RequestParam("h") Double h, @RequestParam("w") Double w) {
		double bmi = w / Math.pow(h/100, 2);
		return String.format("bmi = %.2f", bmi);
	}
	
	/*
	 * PathVariable
	 * ���|�G/exam/75 -> ���G�G75 pass
	 * ���|�G/exam/45 -> ���G�G45 fail
	 * */
	@RequestMapping(value = "/exam/{score}")
	@ResponseBody
	public String exam(@PathVariable("score") Integer score) {
		return score + " " + ((score >= 60)? "Pass" : "Fail");
	}
	
	/*
	 * Lab: PathVariable + RequestParam
	 * ���|�G/calc/add?x=30&y=20  -> ���G�G50
	 * ���|�G/calc/sub?x=30&y=20  -> ���G�G10
	 * ���|�G/calc/sub?y=20       -> ���G�G20
	 * ���|�G/calc/sub?x=0&y=20   -> ���G�G-20
	 * ���|�G/calc/add            -> ���G�G0
	 * ���|�G/calc/div            -> ���G�G"None" <- �L�����|
	 * */
	@RequestMapping(value = "/calc/{exp}")
	@ResponseBody
	public String calc(@PathVariable("exp") String exp,
			           @RequestParam(value = "x", required = false) Optional<Integer> x,
			           @RequestParam(value = "y", required = false) Optional<Integer> y) {
		if(x.isPresent() && y.isPresent()) {
			switch (exp) {
				case "add":
					return x.get() + y.get() + "";
				case "sub":
					return x.get() - y.get() + "";
				default:
					return "None";
			}
		}
		if(x.isPresent()) {
			return x.get() + "";
		}
		if(y.isPresent()) {
			return y.get() + "";
		}
		return "0";
	}
	
	/*
	 * �`���� PathVariable �U�Φr�� * ���N�h�r, ? ���N�@�r
	 * */
	@RequestMapping(value = "/any/*/java?")
	@ResponseBody
	public String any() {
		return "Any";
	}
	
	/*
	 * �o��h�����
	 * ���|�G/age?a=18&a=19&a=20 
	 * ���G�G[18, 19, 20] , age of average = 19
	 * */
	@RequestMapping("/age")
	@ResponseBody
	public String age(@RequestParam("a") List<Integer> ageList) {
		double avg = ageList.stream().mapToInt(age -> age).average().getAsDouble();
		return String.format("%s , age of average = %d", ageList, (int)avg);
	}
	
	/* Lab
	 * �o��h�� score ���
     * ���}��J�G/max?score=80&score=100&score=50
     * ���}��J�G/min?score=80&score=100&score=50
     * ���G�o��Gmax score = 100
	 * ���G�o��Gmin score = 80
	 * ��ĳ�ϥΡGIntSummaryStatistics
	 * */
	@RequestMapping("/{opt}")
	@ResponseBody
	public String maxAndMin(@PathVariable("opt") String opt, 
			                @RequestParam("score") List<Integer> scores) {
		String str = "%s score = %d";
		IntSummaryStatistics stat = scores.stream().mapToInt(score -> score).summaryStatistics();
		switch (opt) {
			case "max":
				str = String.format(str, opt, stat.getMax());
				break;
			case "min":
				str = String.format(str, opt, stat.getMin());
				break;
			default:
				str = "None";
				break;
		}
		return str;
	}
	
	/*
	 * Map �Ѽ�
	 * ���}��J�G/mix?name=John&score=100&age=18&pass=true
	 * ���}��J�G/mix?name=Mary&score=90&age=20&level=2
	 * */
	@RequestMapping("/mix")
	@ResponseBody
	public String mix(@RequestParam Map<String, String> map) {
		return map.toString();
	}
}
