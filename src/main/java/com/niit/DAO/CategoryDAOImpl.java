package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	SessionFactory sessionfactory;

	
	public boolean addCategory(Category c) {
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(c);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
			return false;
		}
	}

	public List<Category> getAllCategory() {
		return sessionfactory.getCurrentSession().createQuery("from Category").list();
	}

	public boolean deleteCategory( int catid) {
	try{
		Category cat=getOneCategory(catid);
		sessionfactory.getCurrentSession().delete(cat);
		return true;
	}
	catch(Exception e)
	{
	System.out.println("exception expired"+e);	
		return false;
	 }
   }

	public boolean updateCategory(Category c) {
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

	public Category getOneCategory(int catid) {
		Category category=(Category)sessionfactory.getCurrentSession().get(Category.class, catid);
		return category;
	}

}