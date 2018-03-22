package com.marco.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.marco.dao.UserDao;
import com.marco.pojo.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	public void save(User user) {
		user.setCreationDate(new Timestamp(new Date().getTime()));
		String pass = user.getPassword();
		user.setPassword(passwordEncoder.encode(pass));		
		userDao.save(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

}
