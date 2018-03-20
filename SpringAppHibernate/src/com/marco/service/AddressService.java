package com.marco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marco.dao.AddressDao;
import com.marco.dao.AdminDao;
import com.marco.pojo.Address;
import com.marco.pojo.Admin;

@Service
public class AddressService {

	@Autowired
	private AdminDao adminDao;
	@Autowired
	private AddressDao addressDao;

	public void save(Admin admin, Address address) {
		
		address.setAdmin(admin);
		addressDao.save(address);
		
//		admin.setCreationDate(new Timestamp(new Date().getTime()));
//		adminDao.save(admin);
	}

	public List<Address> findAll(int idAdmin) {
//		return adminDao.findAll();
		Admin admin = adminDao.findById(idAdmin);
		
		return addressDao.findAll(admin);
	}


}
