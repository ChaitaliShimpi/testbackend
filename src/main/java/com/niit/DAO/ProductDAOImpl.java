package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionfactory;

	public boolean addProduct(Product p) {
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(p);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
			return false;
		}
	}

	public Product getOneProduct(int prodId) {

		Product p = (Product) sessionfactory.getCurrentSession().get(Product.class, prodId);
		return p;

	}

	public List<Product> getAllProduct() {
		List<Product> prodlist = sessionfactory.getCurrentSession().createQuery("from Product").list();
		return prodlist;
	}

	public boolean deleteProduct(int prodId) {
		try {
			Product p = getOneProduct(prodId);
			sessionfactory.getCurrentSession().delete(p);
			return true;
		}

		catch (Exception e) {
			System.out.println("exception expired" + e);
			return false;
		}
	}

	public boolean updateProduct(Product p) {
		try {
			sessionfactory.getCurrentSession().update(p);
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
			return false;
		}
	}
}
