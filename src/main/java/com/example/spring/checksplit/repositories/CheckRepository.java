package com.example.spring.checksplit.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.checksplit.models.Check;
@Repository
public interface CheckRepository extends CrudRepository<Check, Long>{
	List<Check> findAll();
	
	Optional<Check> findByCodeEquals(String string);
	
//	@Query("Select COUNT(o.total) FROM Check c Join c.orders.o GROUP BY c.code WHERE c.code = ?1")
//	Double findTotal(String code);

}
