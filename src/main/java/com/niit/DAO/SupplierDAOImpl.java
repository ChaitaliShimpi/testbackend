package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Supplier;
@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO{
	@Autowired
	SessionFactory sessionfactory;


	public boolean addSupplier(Supplier s) {
			try {
				sessionfactory.getCurrentSession().saveOrUpdate(s);
				return true;
			} catch (Exception e) {
				System.out.println("exception arised" + e);
				return false;
			}
	}
	public Supplier getOneSupplier(int suppId) {
	
		Supplier s=(Supplier)sessionfactory.getCurrentSession().get(Supplier.class,suppId);
		return s;
	
	}
	public List<Supplier> getAllSupplier() {
	List<Supplier> supplist=sessionfactory.getCurrentSession().createQuery("from Supplier").list();
	return supplist;
	}

	public boolean deleteSupplier(int suppId) {
	try{
		Supplier s=getOneSupplier(suppId);
		sessionfactory.getCurrentSession().delete(s);
		return true;
	}
	
	catch(Exception e)
	{
	System.out.println("exception expired"+e);	
		return false;
	 }
	}
	public boolean updateSupplier(Supplier s) {
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
}


