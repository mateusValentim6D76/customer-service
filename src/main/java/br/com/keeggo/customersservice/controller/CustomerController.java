package br.com.keeggo.customersservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.keeggo.customersservice.model.entity.Customer;
import br.com.keeggo.customersservice.model.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private final CustomerRepository repository;
	
	@Autowired
	public CustomerController(CustomerRepository repository) {
		this.repository = repository; 
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer save(Customer customer) {
		return repository.save(customer);
	}
	
}
