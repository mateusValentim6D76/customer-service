package br.com.keeggo.customersservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.keeggo.customersservice.model.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	

}
