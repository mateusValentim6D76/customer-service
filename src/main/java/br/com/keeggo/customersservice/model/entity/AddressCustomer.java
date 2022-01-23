package br.com.keeggo.customersservice.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class AddressCustomer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id_address;
	
	@Column(nullable = false, length = 150)
	private String address;
	
	@Column(nullable = false, length = 150)
	private String city;
	
	@Column(nullable = false, length = 100)
	private String uf;
	
	@OneToOne
	@JoinColumn(name = "id_address_customer")
	private Customer customer;

}
