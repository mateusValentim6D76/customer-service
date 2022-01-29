package br.com.keeggo.customersservice.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.keeggo.customersservice.model.entity.Customer;
import br.com.keeggo.customersservice.model.entity.ServiceProvided;

public interface ServiceProvidedRepository extends JpaRepository<ServiceProvided, Integer>{

	@Query("select s from ServiceProvided s join s.customer c where upper (c.name) like upper (:name) and MONTH(s.dateService) = :month")
	List<ServiceProvided> findByNameAndMonth(@Param("name") String name, @Param("month") Integer month);

}
