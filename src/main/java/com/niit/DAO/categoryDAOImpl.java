package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.category;

@Repository("categoryDAO")
@Transactional
public class categoryDAOImpl implements categoryDAO {
	@Autowired
	SessionFactory sessionfactory;

	
	public boolean addCategory(category c) {
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(c);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
			return false;
		}
	}

	public List<category> getallcategory() {
		return sessionfactory.getCurrentSession().createQuery("from category").list();
	}

	public boolean deletecategory( int catid) {
	try{
		category cat=getOnecategory(catid);
		sessionfactory.getCurrentSession().delete(cat);
		return true;
	}
	catch(Exception e)
	{
	System.out.println("exception expired"+e);	
		return false;
	 }
   }

	public boolean updatecategory(category c) {
		try
		{
			sessionfactory.getCurrentSession().update(c);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}

	}

	public category getOnecategory(int catid) {
		category category=(category)sessionfactory.getCurrentSession().get(category.class, catid);
		return category;
	}

}