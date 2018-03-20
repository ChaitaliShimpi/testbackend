package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Cart;
import com.niit.model.Category;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {
	@Autowired
	SessionFactory sessionfactory;

	public boolean addCart(Cart ca) {
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
			Cart ca = getOnecartitem(cartId);
			sessionfactory.getCurrentSession().delete(ca);
			return true;
		} catch (Exception e) {
			System.out.println("exception expired" + e);
			return false;
		}
	}

	public List<Cart> getAllcart(String username) {
		Query query = sessionfactory.getCurrentSession().createQuery("from Cart where username=?");
		query.setString(0, username);
		return query.list();
	}

	public Cart getOnecartitem(int cartId) {
		Cart ca=(Cart) sessionfactory.getCurrentSession().get(Cart.class, cartId);
		return ca;
	}

	public List<Cart> getAllUnpaidItem(String username) {
		Query query = sessionfactory.getCurrentSession().createQuery("from Cart where username=? and paymentStatus=?");
		query.setString(0, username);
		query.setString(1, "np");
		return query.list();
	}
}
