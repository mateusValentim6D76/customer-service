package br.com.keeggo.customersservice.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.keeggo.customersservice.model.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);
	
	boolean existsByUsername(String username);

}
