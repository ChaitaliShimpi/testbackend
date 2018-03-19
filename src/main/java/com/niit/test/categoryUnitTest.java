package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.categoryDAO;
import com.niit.model.category;

public class categoryUnitTest {
	static categoryDAO categoryDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		categoryDAO = (categoryDAO) context.getBean("categoryDAO");
		//when called will go to dbconfig & there specified to go categoryDAOImpl
	}
	
	@Test
	public void addCategoryTest() {
		category category = new category();
		category.setCatname("eyeliner");
		category.setCatDesc("used as liner");
		assertTrue("Problem in Category Insertion", categoryDAO.addCategory(category));
	}

	@Ignore
	@Test
	public void updateCategoryTest() {
		category category = new category();
		category.setCatid(1);
		category.setCatname("CHAITALI");
		category.setCatDesc("gives glow on your face");
		assertTrue("Problem in Category updation", categoryDAO.updatecategory(category));
	}

	@Ignore
	@Test
	public void getOneCategoryTest() {
		category cat = categoryDAO.getOnecategory(1);
		System.out.println(cat);
		assertNotNull("Problem in get Category", categoryDAO.getOnecategory(1));
	}

	@Ignore
	@Test
	public void deleteCAtegoryTest() {
		assertTrue("problem in  deletion", categoryDAO.deletecategory(2));
	}

	@Ignore
	@Test
	public void getallTest() {
		List<category> catlist = categoryDAO.getallcategory();
		for (category category : catlist) {
			System.out.println(category);
		}
		assertNotNull("problem in getting all categories", categoryDAO.getallcategory());
	}
}
