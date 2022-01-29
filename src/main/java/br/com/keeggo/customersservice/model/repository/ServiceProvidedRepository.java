package br.com.keeggo.customersservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.keeggo.customersservice.model.entity.Customer;
import br.com.keeggo.customersservice.model.entity.ServiceProvided;

public interface ServiceProvidedRepository extends JpaRepository<ServiceProvided, Integer>{

}
