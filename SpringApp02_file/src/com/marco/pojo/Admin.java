package com.marco.pojo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class Admin {

	private int idAdmin;
	private String name;
	private String role;
	private Timestamp creationDate;
	
	
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
	@Override
	public String toString() {
		return "Administrator [idAdmin=" + idAdmin + ", name=" + name + ", role=" + role + ", creationDate="
				+ creationDate + "]";
	}
	
		
}
