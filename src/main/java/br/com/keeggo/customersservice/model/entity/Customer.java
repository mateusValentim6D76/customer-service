package br.com.keeggo.customersservice.model.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

	public Customer(Integer id, String name, String surname, String cpf, Date dthBirthday, Gender gender,
			AddressCustomer addressCustomer) {

		this.id = id;
		this.name = name;
		this.surname = surname;
		this.cpf = cpf;
		this.dthBirthday = dthBirthday;
		this.gender = gender;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 150)
	@NotEmpty(message = "{name.field.required}")
	private String name;

	@Column(nullable = false, length = 150)
	@NotEmpty(message = "{surname.field.required}")
	private String surname;

	@Column	(length = 11, name = "num_cpf", unique = true)
	@NotNull(message = "{cpf.field.required}")
	@CPF(groups = CPFValidator.class, message = "{cpf.field.invalid}")
	@CNPJ(groups = CNPJValidator.class)
	private String cpf;

	@Column(name = "dth_birthday")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dthBirthday;

	@Column(nullable = false, name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "registration_date", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate registrationDate;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<AddressCustomer> addressCustomer;

	@PrePersist
	public void prePersist() {
		setRegistrationDate(LocalDate.now());
	}

}