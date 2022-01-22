package br.com.keeggo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class AddressCustomer {
	
	@Column(nullable = false, length = 150)
	private String address;
	@Column(nullable = false, length = 150)
	private String city;
	@Column(nullable = false, length = 100)
	private String uf;

}
