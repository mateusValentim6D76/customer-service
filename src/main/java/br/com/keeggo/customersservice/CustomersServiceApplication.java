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

	@Bean
	public CommandLineRunner run (@Autowired CustomerRepository repository) {
		return args -> {
			Customer c = Customer.builder().cpf("43355677712").name("Mateus")
					.surname("Valentim").gender(MALE).build();
			repository.save(c);
		
	};
}

	public static void main(String[] args) {
		SpringApplication.run(CustomersServiceApplication.class, args);
	}

}
