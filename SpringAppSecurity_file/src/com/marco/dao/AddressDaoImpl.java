package com.marco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.marco.pojo.Address;
import com.marco.pojo.Admin;


@Transactional
@Repository
public class AddressDaoImpl implements AddressDao {

	@Autowired
	private SessionFactory sessionFactorty;
	
	private Session getSession() {
		return sessionFactorty.getCurrentSession();
	}
	
	
	@Override
	public void save(Address address) {		
		getSession().save(address);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findAll(Admin admin) {
		Criteria crit = getSession().createCriteria(Address.class)
				.setFetchMode("admin", FetchMode.JOIN)
				.add(Restrictions.eq("admin.idAdmin", admin.getIdAdmin()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		return crit.list();
	}

	
}
