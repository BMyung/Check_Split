package com.example.spring.checksplit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.spring.checksplit.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	List<User>findAll();
	

}
