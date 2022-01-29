package br.com.keeggo.customersservice.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class ServiceProvided {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 150)
	private String description;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Customer customer;

	@Column
	private BigDecimal value;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateService;
}
