package com.marco.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marco.domain.Admin;
import com.marco.repo.AdminRepo;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1/")
public class RestController {

	@Autowired
	private AdminRepo adminRepo;
	
//	@RequestMapping("/")
//	public String getAllAdmin() {
//		return adminRepo.findAll().toString();
//	}

	//READ ADMINS
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public ResponseEntity<Collection<Admin>> getAllAdmin() {
		
		List<Admin> admins = (List<Admin>) adminRepo.findAll();
		
		if(admins == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		if(admins.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
		}
		
		return new ResponseEntity<Collection<Admin>>(admins, HttpStatus.OK);
	}

	@RequestMapping(value="/admin/{idAdmin}", method=RequestMethod.GET)
	public ResponseEntity<Admin> getAdmin(@PathVariable("idAdmin") int idAdmin) {
		
		Optional<Admin> admin = adminRepo.findById(idAdmin);
		
				
		if(!admin.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
		}
		
		return new ResponseEntity<Admin>(admin.get(), HttpStatus.OK);
	}
}
