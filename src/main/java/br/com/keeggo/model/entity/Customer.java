package br.com.keeggo.model.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 150)
	private String nome;
	@Column(nullable = false, length = 150)
	private String sobreNome;
	@Column(nullable = false, length = 11)
	private String cpf;
	@Column(nullable = false)
	private Date dthNascimento;

}
