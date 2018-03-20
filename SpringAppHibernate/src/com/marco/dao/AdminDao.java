package com.marco.dao;

import java.util.List;

import com.marco.pojo.Admin;

public interface AdminDao {

	public void save(Admin admin);
	public List<Admin> findAll();
	public Admin findById(int id);
	public List<Admin> findByName(String name);
	public void update(Admin admin);
	public void delete(Admin admin);
}

