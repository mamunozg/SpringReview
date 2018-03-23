package com.marco.repo;

import org.springframework.data.repository.CrudRepository;

import com.marco.domain.Admin;

public interface AdminRepo extends CrudRepository<Admin, Integer> {

}
