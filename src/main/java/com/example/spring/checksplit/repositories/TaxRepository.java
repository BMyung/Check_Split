package com.example.spring.checksplit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.checksplit.models.Tax;
@Repository
public interface TaxRepository extends CrudRepository<Tax, Long>{
	
	List <Tax> findAll();
	
	@Query("SELECT t.rate from Tax t WHERE t.city LIKE ?1")
	List<Tax> findTaxRate(String city);

}
