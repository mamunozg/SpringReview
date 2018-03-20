package com.marco.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marco.dao.AdminDao;
import com.marco.pojo.Admin;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public void save(Admin admin) {
		admin.setCreationDate(new Timestamp(new Date().getTime()));
		adminDao.save(admin);
	}

	public List<Admin> findAll() {
		return adminDao.findAll();
	}

	public Admin findById(int id) {
		return adminDao.findById(id);
	}

	public void saveOrUpdate(Admin adminForm) {
		if (adminForm.getIdAdmin() == 0) {
			save(adminForm);
		} else {
			adminDao.update(adminForm);
		}

	}

	public void delete(int id) {
		Admin admin = adminDao.findById(id);
		adminDao.delete(admin);
	}

}
