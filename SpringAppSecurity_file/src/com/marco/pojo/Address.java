package com.marco.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue
	private int idAddress;
	private String street;
	private int zipCode;

	@ManyToOne
	@JoinColumn(name = "idAdmin")
	private Admin admin;

	public Address() {
		super();
	}

	public Address(String street, int zipCode) {
		super();
		this.street = street;
		this.zipCode = zipCode;
	}

	public int getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Address [idAddress=" + idAddress + ", street=" + street + ", zipCode=" + zipCode + "]";
	}

}
