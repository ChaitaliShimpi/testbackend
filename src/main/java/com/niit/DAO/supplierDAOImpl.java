package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.supplier;
@Repository("supplierDAO")
@Transactional
public class supplierDAOImpl implements supplierDAO{
	@Autowired
	SessionFactory sessionfactory;


	public boolean addsupplier(supplier s) {
			try {
				sessionfactory.getCurrentSession().saveOrUpdate(s);
				return true;
			} catch (Exception e) {
				System.out.println("exception arised" + e);
				return false;
			}
	}
	public supplier getOnesupplier(int suppId) {
	
		supplier s=(supplier)sessionfactory.getCurrentSession().get(supplier.class,suppId);
		return s;
	
	}
	public List<supplier> getAllsupplier() {
	List<supplier> supplist=sessionfactory.getCurrentSession().createQuery("from supplier").list();
	return supplist;
	}

	public boolean deletesupplier(int suppId) {
	try{
		supplier s=getOnesupplier(suppId);
		sessionfactory.getCurrentSession().delete(s);
		return true;
	}
	
	catch(Exception e)
	{
	System.out.println("exception expired"+e);	
		return false;
	 }
	}
	public boolean updatesupplier(supplier s) {
			try
			{
				sessionfactory.getCurrentSession().update(s);
				return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised:"+e);
				return false;
			}
	}
	public List<supplier> getallsupplier() {
		return sessionfactory.getCurrentSession().createQuery("from supplier").list();
	}
	
}


