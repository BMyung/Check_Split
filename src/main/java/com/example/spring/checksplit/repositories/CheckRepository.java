package com.example.spring.checksplit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.spring.checksplit.models.Check;

public interface CheckRepository extends CrudRepository<Check, Long>{
	List<Check> findAll();

}
