package br.com.keeggo.customersservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.keeggo.customersservice.model.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
