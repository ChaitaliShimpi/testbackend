package com.niit.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User;
@Transactional
@Repository
public class registrationDAOImpl implements registrationDAO {
@Autowired
	SessionFactory sessionFactory;
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);

	}

}
