package com.mvc.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.entity.products.Product;
import com.mvc.service.ProductService;

@Controller
@RequestMapping(value = "/product")
@SessionAttributes(value = {"groups","products"})
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = {"/", "/input"})
	public String index(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("groups", productService.groups.values());
		model.addAttribute("products", productService.query());
		model.addAttribute("action", "save");
		return "product";
	}
	
	@PostMapping(value = "/save")
	//@Valid 啟動303驗證
	public String save(@Valid Product product , BindingResult result , Model model  ) {
		if (result.hasErrors()) {
			model.addAttribute("action", "save");
			return "product"; //將錯誤資訊帶給指定jsp頁面
		}
		productService.save(product); //儲存
		return "redirect:/mvc/product/";
	}
	
	@GetMapping(value = "/delete/{name}")
	public String delete(@PathVariable("name") String name ) {
		productService.delete(name);
		return "redirect:/mvc/product/";
	}
	
	@GetMapping(value = "/get/{name}")
	public String get(@PathVariable("name") String name , Model model) {
		model.addAttribute("product" ,productService.get(name));
		model.addAttribute("groups", productService.groups.values());
		model.addAttribute("products", productService.query());
		model.addAttribute("action", "update");
		return "product";
	}
	
	@RequestMapping(value = "/update")
	public String update(Product product) {
		productService.update(product);
		return "redirect:/mvc/product/";
	}
	
	
}
