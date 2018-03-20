package com.niit.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionfactory;

	public boolean saveUser(User u) {

		try {
			sessionfactory.getCurrentSession().saveOrUpdate(u);
			return true;
		} catch (Exception e) {
			System.out.println("Exception expired" + e);
			return false;
		}
	}
}
