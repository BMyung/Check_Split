package com.example.spring.checksplit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.checksplit.models.Check;
@Repository
public interface CheckRepository extends CrudRepository<Check, Long>{
	List<Check> findAll();

}
