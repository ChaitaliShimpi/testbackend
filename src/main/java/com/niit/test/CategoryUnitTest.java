package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.CategoryDAO;
import com.niit.model.Category;

public class CategoryUnitTest {
	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		//when called will go to dbconfig & there specified to go categoryDAOImpl
	}
	
	@Test
	public void addCategoryTest() {
		Category category = new Category();
		category.setCatname("eyeliner");
		category.setCatDesc("used as liner");
		assertTrue("Problem in Category Insertion", categoryDAO.addCategory(category));
	}

	@Ignore
	@Test
	public void updateCategoryTest() {
		Category category = new Category();
		category.setCatid(1);
		category.setCatname("CHAITALI");
		category.setCatDesc("gives glow on your face");
		assertTrue("Problem in Category updation", categoryDAO.updateCategory(category));
	}

	@Ignore
	@Test
	public void getOneCategoryTest() {
		Category cat = categoryDAO.getOneCategory(1);
		System.out.println(cat);
		assertNotNull("Problem in get Category", categoryDAO.getOneCategory(1));
	}

	@Ignore
	@Test
	public void deleteCategoryTest() {
		assertTrue("problem in  deletion", categoryDAO.deleteCategory(2));
	}

	@Ignore
	@Test
	public void getallTest() {
		List<Category> catlist = categoryDAO.getAllCategory();
		for (Category category : catlist) {
			System.out.println(category);
		}
		assertNotNull("problem in getting all categories", categoryDAO.getAllCategory());
	}
}
