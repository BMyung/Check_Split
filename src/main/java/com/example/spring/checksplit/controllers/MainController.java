package com.example.spring.checksplit.controllers;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring.checksplit.models.Check;
import com.example.spring.checksplit.models.Order;
import com.example.spring.checksplit.models.Product;
import com.example.spring.checksplit.services.MainService;

@Controller
public class MainController {
	private final MainService mainService;
	
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
	@GetMapping("/")
	public String home(@ModelAttribute("check") Check check) {
		return "index.jsp";
	}
	
	@PostMapping("/checks/new")
	public String newCheck(@Valid @ModelAttribute("check")Check check, BindingResult result, HttpSession session){
		if(result.hasErrors()) {
			return "index.jsp";
		}
		else {
			session.setAttribute("check", check);
			mainService.saveCheck(check);
		return "redirect:/form";
	}
	}
	
	@GetMapping("/form")
	public String newContacts() {

		return "form.jsp";	
		
	}
	
	@PostMapping("/form/new")
	public String phoneNumbers(@RequestParam("guest")String guest, @RequestParam("phone") String phone) {
//		List<String> guestList = this.mainService.splitList(guest);
		return "redirect:/count";
	}

	//Method to send out texts
	
	@GetMapping("/count")
	public String countForm() {
		return "ordercount.jsp";
	}
	
	@PostMapping("/ordercount")
	public String setOrderCount(HttpSession session, @RequestParam("orderItemCount") Integer itemCount) {
		session.setAttribute("orderItemCount", itemCount);
		return "redirect:/orderform";
	}
	
	@GetMapping("/orderform")
	public String form(@ModelAttribute("item") Product product) {
		return "mainform.jsp";
	}
	
	@PostMapping("/orderform/process")
	public String processData(@ModelAttribute("item")Product product) {
		Order order = new Order();
		Double subtotal = this.mainService.addSubtotal(product);
		order.setName(product.getName());
		order.setSubtotal(subtotal);
		mainService.save(order);
		return "redirect:/total";
	}
}
