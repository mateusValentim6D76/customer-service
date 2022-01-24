package br.com.keeggo.customersservice;

import static br.com.keeggo.customersservice.model.entity.Gender.MALE;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.keeggo.customersservice.model.entity.Customer;
import br.com.keeggo.customersservice.model.repository.CustomerRepository;

@SpringBootApplication
public class CustomersServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(CustomersServiceApplication.class, args);
	}

}
