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
	
	
	public boolean save(Admin admin) {
		admin.setCreationDate(new Timestamp(new Date().getTime()));
		return adminDao.save(admin);
	}
	
	
	public List<Admin> findAll() {		
		return adminDao.findAll();
	}
	
	public Admin findById(int id) {		
		return adminDao.findById(id);
	}


	public boolean saveOrUpdate(Admin adminForm) {
		if(adminForm.getIdAdmin() == 0) {
			return save(adminForm);
		}
		else {
			return adminDao.update(adminForm);
		}
				
	}


	public boolean delete(int id) {		
		return adminDao.delete(id);
	}

	
	
}
