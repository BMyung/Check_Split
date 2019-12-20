package com.example.spring.checksplit.controllers;



import java.text.NumberFormat;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.spring.checksplit.models.Check;
import com.example.spring.checksplit.models.Order;
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
			String code = RandomStringUtils.randomAlphanumeric(7);
			check.setCode(code);
			session.setAttribute("code", code);
			mainService.saveCheck(check);
			String rd="redirect:/"+ code +"/orderform";
		return rd;
	}
	}
	
	@GetMapping("/form")
	public String newContacts() {
		return "form.jsp";	
		
	}
	
	@PostMapping("/form/new")
	public String phoneNumbers(@RequestParam("guest")String guest, @RequestParam("phone") String phone, HttpSession session) {
//		List<String> guestList = this.mainService.splitList(guest);
		String code = (String) session.getAttribute("code");
		System.out.println(code);
		String rd = "redirect:/"+ code + "/orderform";
		return rd;
	}

	//Method to send out texts
	
	
	@GetMapping("/{code}/orderform")
	public String form(@PathVariable("code") String code, Model model) {
		model.addAttribute("code", code);
		return "mainform.jsp";
	}
	
	@PostMapping("/orderform/{code}/process")
	public String processData(@RequestParam("name") String names, @RequestParam("price") String prices, @PathVariable("code")String code, RedirectAttributes redirectAttributes, @RequestParam("tipPercent") Double tipPercent) {
		Check check = this.mainService.findCheck(code);
		Order order = new Order();
		Double subtotal = this.mainService.addSubtotal(prices);
		order.setName(names);
		order.setSubtotal(subtotal);
		order.setTip(subtotal * tipPercent);
		Double taxAmount = (check.getTaxAmount()/check.getSubtotal())*subtotal;
		order.setTax(taxAmount);
		Double orderTotal = subtotal + taxAmount + order.getTip();
		order.setTotal(orderTotal); 
		order.setCheck(check);
		mainService.save(order);

		Double checkTotal = check.getTotal();
		if (checkTotal==null) {
			checkTotal = (double) 0;
		}
		check.setTotal(checkTotal + orderTotal);
		this.mainService.saveCheck(check);
		redirectAttributes.addFlashAttribute("order", order);
//		redirectAttributes.addFlashAttribute("check",check);
		String rd = "redirect:/total/"+ code;
		return rd;
	}
	
	@GetMapping("/total/{code}")
	public String total(Model model, @PathVariable("code")String code) {
		model.addAttribute("check", this.mainService.findCheck(code));
		return "total.jsp";
	}
	
	
}
