package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.cart;
import com.niit.model.category;

@Repository("cartDAO")
@Transactional
public class cartDAOImpl implements cartDAO {
	@Autowired
	SessionFactory sessionfactory;

	public boolean addCart(cart ca) {
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(ca);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
			return false;
		}
	}

	public boolean deleteCart(int cartId) {
		try {
			cart ca = getOnecartitem(cartId);
			sessionfactory.getCurrentSession().delete(ca);
			return true;
		} catch (Exception e) {
			System.out.println("exception expired" + e);
			return false;
		}
	}

	public List<cart> getAllcart(String username) {
		Query query = sessionfactory.getCurrentSession().createQuery("from cart where username=?");
		query.setString(0, username);
		return query.list();
	}

	public cart getOnecartitem(int cartId) {
		cart ca=(cart) sessionfactory.getCurrentSession().get(cart.class, cartId);
		return ca;
	}

	public List<cart> getAllUnpaidItem(String username) {
		Query query = sessionfactory.getCurrentSession().createQuery("from cart where username=? and paymentStatus=?");
		query.setString(0, username);
		query.setString(1, "np");
		return query.list();
	}

	public List<cart> getAllPaidItem(String username) {
		Query query = sessionfactory.getCurrentSession().createQuery("from cart where username=? and paymentStatus=?");
		query.setString(0, username);
		query.setString(1, "p");
		return query.list();
		
	}

}
