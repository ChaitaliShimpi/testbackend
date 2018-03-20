package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.product;

	@Repository("productDAO")
	@Transactional
	public class productDAOImpl implements productDAO {
		@Autowired
		SessionFactory sessionfactory;
	
	
		public boolean addproduct(product p) {
				try {
					sessionfactory.getCurrentSession().saveOrUpdate(p);
					return true;
				} catch (Exception e) {
					System.out.println("exception arised" + e);
					return false;
				}
		}
		public product getOneproduct(int prodId) {
		
			product p=(product)sessionfactory.getCurrentSession().get(product.class,prodId);
			return p;
		
		}
		public List<product> getAllproduct() {
		List<product> prodlist=sessionfactory.getCurrentSession().createQuery("from product").list();
		return prodlist;
		}

		public boolean deleteproduct(int prodId) {
		try{
			product p=getOneproduct(prodId);
			sessionfactory.getCurrentSession().delete(p);
			return true;
		}
		
		catch(Exception e)
		{
		System.out.println("exception expired"+e);	
			return false;
		 }
		}
		public boolean updateproduct(product p) {
				try
				{
					sessionfactory.getCurrentSession().update(p);
					return true;
				}
				catch(Exception e)
				{
					System.out.println("Exception Arised:"+e);
					return false;
				}
		}
		public List<product> getallproduct() {
			return sessionfactory.getCurrentSession().createQuery("from product").list();
		}
	}
