package com.marco.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="admin")
public class Admin {

	@Id
	@GeneratedValue
	private int idAdmin;
	
//	@Column(name="name")
	private String name;
	private String role;
	
	@JsonIgnore
	private Timestamp creationDate;
	
//	@OneToMany(mappedBy="admin")
//	private Set<Address> adrresses;
//	
	
	public Admin() {
		super();
	}
	public Admin(String name, String role, Timestamp creationDate) {
		this.name = name;
		this.role = role;
		this.creationDate = creationDate;
	}
	
	
	
	public Admin(int idAdmin, String name, String role, Timestamp creationDate) {
		super();
		this.idAdmin = idAdmin;
		this.name = name;
		this.role = role;
		this.creationDate = creationDate;
	}
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}	
//	
//	public Set<Address> getAdrresses() {
//		return adrresses;
//	}
//	public void setAdrresses(Set<Address> adrresses) {
//		this.adrresses = adrresses;
//	}
	@Override
	public String toString() {
		return "Administrator [idAdmin=" + idAdmin + ", name=" + name + ", role=" + role + ", creationDate="
				+ creationDate + "]";
	}
	
		
}
