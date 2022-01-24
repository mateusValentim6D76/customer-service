package br.com.keeggo.customersservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.keeggo.customersservice.model.entity.AddressCustomer;

public interface AddressCustomerRepository extends JpaRepository<AddressCustomer, String>{

}
