package br.com.keeggo.customersservice.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServiceProvidedDTO {

	private String description;
	private String value;
	private String dateService;
	private Integer idCustomer;
}
