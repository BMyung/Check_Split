package com.example.spring.checksplit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.checksplit.models.Order;
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
	List<Order> findAll();

}
