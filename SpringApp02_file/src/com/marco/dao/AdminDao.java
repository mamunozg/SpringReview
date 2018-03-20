package com.marco.dao;

import java.util.List;

import com.marco.pojo.Admin;

public interface AdminDao {

	public boolean save(Admin admin);
	public List<Admin> findAll();
	public Admin findById(int id);
	public List<Admin> findByName(String name);
	public boolean update(Admin admin);
	public boolean delete(int id);
	public int[] saveAll(List<Admin> admin);
}

