package br.com.keeggo.customersservice.rest.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServiceProvidedDTO {

	@NotEmpty(message = "{description.field.required}")
	private String description;
	
	@NotEmpty(message = "{value.field.required}")
	private String value;
	
	@NotEmpty(message = "{dateService.field.required}")
	private String dateService;
	
	@NotNull(message = "{idCustomer.field.required}")
	private Integer idCustomer;
}
