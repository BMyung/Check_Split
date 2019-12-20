package com.example.spring.checksplit.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring.checksplit.models.Check;
import com.example.spring.checksplit.models.Order;
import com.example.spring.checksplit.repositories.CheckRepository;
import com.example.spring.checksplit.repositories.OrderRepository;
import com.example.spring.checksplit.repositories.TaxRepository;
import com.example.spring.checksplit.repositories.UserRepository;;

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

public Double addSubtotal(String checkPrices) {
	List<String> priceList = this.splitList(checkPrices);
	Double subtotal = 0.00;
	for (String number : priceList) {
		subtotal += Double.parseDouble(number);
	}
	return subtotal;
}

public Order save(Order order) {
	return this.orderRepository.save(order);
}

public Check findCheck(String code){
	if(this.checkRepository.findByCodeEquals(code).isPresent()) {
		return this.checkRepository.findByCodeEquals(code).get();
	}
	else {
		return null;
	}
}

public Double findTax(String code) {
	Check thisCheck = this.findCheck(code);
	Double taxTotal = thisCheck.getTaxAmount();
	Double taxPercent = taxTotal/thisCheck.getSubtotal();
	return taxPercent;
}

public Double round(Double value) {
BigDecimal bd = new BigDecimal (Double.toString(value));
bd = bd.setScale(2, RoundingMode.HALF_UP);
return bd.doubleValue();
}

//public Double getTotal(String code) {
//	return this.checkRepository.findTotal(code);
//}


//public Order
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

