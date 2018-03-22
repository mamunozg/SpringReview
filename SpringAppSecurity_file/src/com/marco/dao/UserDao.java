package com.marco.dao;

import java.util.List;

import com.marco.pojo.User;


public interface UserDao {
	public User findByUserName(String userName);
	public void save(User user);
	public List<User> findAll();
}
