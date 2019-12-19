package com.example.spring.checksplit.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring.checksplit.models.Check;
import com.example.spring.checksplit.models.Order;
import com.example.spring.checksplit.models.Product;
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

public Double addSubtotal(Product product) {
	List<String> stringPrices = this.splitList(product.getPrice());
	Double subtotal = 0.00;
	for(int i = 0; i < stringPrices.size(); i++) {
		Double newPrice = Double.parseDouble(stringPrices.get(i));
		subtotal += newPrice;
	}
return subtotal;
}

public Order save(Order order) {
	return this.orderRepository.save(order);
}
//public List<Object> createOrders(Order order){
//	List<String> names = this.splitList(order.getName());
//	List<String> stringPrices = this.splitList(order.getSubtotalString());
//	List<Double> prices = new ArrayList<Double>();
//	for(int i = 0; i < stringPrices.size(); i++) {
//		Double newPrice = Double.parseDouble(stringPrices.get(i));
//		prices.add(newPrice);
//		subtotal += newPrice;
//	}
//	return this.createObjectPair(names, prices); 
//	
//}
//
//public List<Object> createObjectPair(List<String> names, List<Double>prices) {
//	
//	
//	
//}

}

