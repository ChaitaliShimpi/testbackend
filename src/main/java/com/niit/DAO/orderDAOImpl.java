package com.niit.DAO;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.order;

@Repository("orderDAO")
@Transactional
public class orderDAOImpl implements orderDAO {
	@Autowired
	SessionFactory sessionfactory;

	public boolean addOrder(order o) {
		try {
			sessionfactory.getCurrentSession().save(o);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
			return false;
		}
	}

	public order getOrder(int orderId) {
		order o = (order) sessionfactory.getCurrentSession().get(order.class, orderId);
		return o;
	}

}
