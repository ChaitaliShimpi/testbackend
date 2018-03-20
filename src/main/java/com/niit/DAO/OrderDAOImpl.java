package com.niit.DAO;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Order;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	SessionFactory sessionfactory;

	public boolean addOrder(Order o) {
		try {
			sessionfactory.getCurrentSession().save(o);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
			return false;
		}
	}

	public Order getOrder(int orderId) {
		Order o = (Order) sessionfactory.getCurrentSession().get(Order.class, orderId);
		return o;
	}

}
