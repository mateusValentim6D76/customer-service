package br.com.keeggo.customersservice.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.keeggo.customersservice.model.entity.Customer;
import br.com.keeggo.customersservice.model.entity.ServiceProvided;
import br.com.keeggo.customersservice.model.repository.CustomerRepository;
import br.com.keeggo.customersservice.model.repository.ServiceProvidedRepository;
import br.com.keeggo.customersservice.rest.dto.ServiceProvidedDTO;
import br.com.keeggo.customersservice.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/service-provided")
//Cria um construtor com os argumentos obrigatórios
@RequiredArgsConstructor
public class ServiceProvidedController {

	private final CustomerRepository customerRepository;
	private final ServiceProvidedRepository repository;
	private final BigDecimalConverter bigDecimalConverter;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServiceProvided saveService(@RequestBody ServiceProvidedDTO dto) {
		// Realizando o parse da data do serviço -> para String
		LocalDate date = LocalDate.parse(dto.getDateService(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer idCustomer = dto.getIdCustomer();

		Customer customer = customerRepository.findById(idCustomer)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "non-existent customer"));

		ServiceProvided serviceProvided = new ServiceProvided();
		serviceProvided.setDescription(dto.getDescription());
		serviceProvided.setDateService(date);
		serviceProvided.setCustomer(customer);
		serviceProvided.setValue(bigDecimalConverter.converter(dto.getValue()));

		return repository.save(serviceProvided);
	}

	@GetMapping
	public List<ServiceProvided> search(@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "month", required = false) Integer month) {
		
		return repository.findByNameAndMonth("%" + name + "%", month);
	}

}
