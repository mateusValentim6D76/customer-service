package br.com.keeggo.customersservice.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class AddressCustomer {

	@ManyToOne
	private Customer customer;
	//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private String id_address;
	
	@Id
	@Column(nullable = false, length = 150)
	//@JoinColumn(name="address_customer") 
	private String address;
	
	@Column(nullable = false, length = 150)
	private String city;
	
	@Column(nullable = false, length = 100)
	private String uf;


}
