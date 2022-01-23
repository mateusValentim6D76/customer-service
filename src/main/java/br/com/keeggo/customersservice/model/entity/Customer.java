package br.com.keeggo.customersservice.model.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 150)
	private String name;

	@Column(nullable = false, length = 150)
	private String surname;

	@Column(nullable = false, length = 11, name = "num_cpf")
	private String cpf;

	@Column(name = "dth_birthday")
	private Date dthBird;
	
	@Column(nullable = false,name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "registration_date")
	private LocalDate registrationDate;

	
	@PrePersist
	public void	prePersist() {
		setRegistrationDate(LocalDate.now());
	}

}
