package com.example.spring.checksplit.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring.checksplit.models.Check;
import com.example.spring.checksplit.models.Order;
import com.example.spring.checksplit.services.MainService;

@Controller
public class SpringAjaxJQuery {
	private final MainService mainService;
	
	public SpringAjaxJQuery(MainService mainService) {
		this.mainService = mainService;
	}
 
    @RequestMapping("/ajaxtest/{code}")
    public @ResponseBody
    String getOrders(@PathVariable("code")String code) {
    	Check check = this.mainService.findCheck(code);
    	List<Order> orders = check.getOrders();
    	if (orders == null) {
    		return "null";
    	}
    	else {
    	String orderList = "";
    	for(int i = 0; i < orders.size(); i++) {
    		String orderName = orders.get(i).getName();
    		Double currentTotal = this.mainService.round(orders.get(i).getTotal());
    		String currentTotalTwo = String.format("%.2f", currentTotal);
    		String newEntry = "<li>" + orderName + " - $" + currentTotalTwo + "</li>";
    		orderList+=newEntry;
    	}
        return orderList;
    }
    }
    }