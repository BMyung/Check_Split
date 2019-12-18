package com.example.spring.checksplit.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring.checksplit.models.Check;
import com.example.spring.checksplit.models.Order;
import com.example.spring.checksplit.repositories.CheckRepository;
import com.example.spring.checksplit.repositories.OrderRepository;
import com.example.spring.checksplit.repositories.TaxRepository;
import com.example.spring.checksplit.repositories.UserRepository;
@Service
public class MainService {
	private final TaxRepository taxRepository;
	private final UserRepository userRepository;
	private final CheckRepository checkRepository;
	private final OrderRepository orderRepository;
	
public MainService(TaxRepository taxRepository, UserRepository userRepository, CheckRepository checkRepository, OrderRepository orderRepository) {
	this.checkRepository = checkRepository;
	this.orderRepository = orderRepository;
	this.taxRepository = taxRepository;
	this.userRepository = userRepository;
}

public List<Order> allOrders(){
	return this.orderRepository.findAll();
}

public Check saveCheck(Check check) {
	return this.checkRepository.save(check);
}

public List<String> splitList(String formString){
	String[] splitString = formString.split(",");
	List<String> list = Arrays.asList(splitString);
	return list;
}



}
