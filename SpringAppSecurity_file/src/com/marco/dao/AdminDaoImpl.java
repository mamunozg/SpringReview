package com.marco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marco.pojo.Admin;


@Transactional
@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(Admin admin) {
		// TODO Auto-generated method stub
		getSession().save(admin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findAll() {		
		Query query = getSession().createQuery("from Admin");
		return query.list();
	}

	@Override
	public Admin findById(int id) {
		Criteria crit = getSession().createCriteria(Admin.class);
		crit.add(Restrictions.eq("idAdmin", id));		
		return (Admin) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findByName(String name) {
		Criteria crit = getSession().createCriteria(Admin.class);
		crit.add(Restrictions.like("name", "%"+name+"%"));
		return crit.list();
	}

	@Override
	public void update(Admin admin) {
		// TODO Auto-generated method stub
		getSession().update(admin);
	}

	@Override
	public void delete(Admin admin) {
		// TODO Auto-generated method stub
		getSession().delete(admin);
		
	}

}
