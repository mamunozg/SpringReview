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

import com.marco.pojo.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public User findByUserName(String userName) {
		Criteria crit = getSession().createCriteria(User.class);
		crit.add(Restrictions.eq("user", userName));
		return (User) crit.uniqueResult();
	}

	@Override
	public void save(User user) {
		getSession().save(user);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		Query query = getSession().createQuery("from User");
		return query.list();
	}

}
