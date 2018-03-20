package com.marco.dao;

import java.util.List;

import com.marco.pojo.Address;
import com.marco.pojo.Admin;

public interface AddressDao {
	
	public void save(Address address);
	public List<Address> findAll(Admin admin);
	
} 
