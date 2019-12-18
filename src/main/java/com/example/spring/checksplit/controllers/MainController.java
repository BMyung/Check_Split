package com.example.spring.checksplit.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring.checksplit.models.Check;
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
		List<String> guestList = this.mainService.splitList(guest);
		System.out.println(guestList);
		return "redirect:/orderform";
	}

	//Method to send out texts
	
	@GetMapping("/orderform")
	public String form() {
		return "mainform.jsp";
	}
	
	@PostMapping("/orderform/process")
	public String processData() {
	}
}
