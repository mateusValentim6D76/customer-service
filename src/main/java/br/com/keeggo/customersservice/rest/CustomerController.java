package br.com.keeggo.customersservice.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	public Customer save(@RequestBody @Valid Customer customer) {
		return repository.save(customer);
	}
	
	@GetMapping("{id}")
	public Customer searchID (@PathVariable Integer id) {
		return repository
				.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomerByID(@PathVariable Integer id) {
		repository
			.findById(id)
			.map( customer -> {
				repository.delete(customer);
				return Void.TYPE;
			})
			.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCustomer(@PathVariable Integer id, @RequestBody Customer cUpdated) {
		repository
			.findById(id)
			.map(customer -> {
				cUpdated.setId(customer.getId());
				return repository.save(cUpdated);
			})
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)); 
	}
}