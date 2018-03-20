package com.marco.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {

	private String street;
	private int zipCode;

	public Address() {
		super();
	}

	public Address(String street, int zipCode) {
		super();
		this.street = street;
		this.zipCode = zipCode;
	}
	
	@Autowired
	public void setStreet(@Value("Calle Villaverde a Perales del Rioo")String street) {
		this.street = street;
	}

	@Autowired
	public void setZipCode(@Value("45880")int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", zipCode=" + zipCode + "]";
	}

}
