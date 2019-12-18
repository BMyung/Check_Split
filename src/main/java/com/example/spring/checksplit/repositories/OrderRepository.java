package com.example.spring.checksplit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.spring.checksplit.models.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
	List<Order> findAll();

}
