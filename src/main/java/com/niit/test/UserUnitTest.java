package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

public class UserUnitTest {
	static UserDAO userDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void saveUser() {
		User user = new User();
		user.setUsername("karvi");
		user.setAddress("borivali");
		user.setEmail("karvi@gmail.com");
		user.setPassword("12345");
		user.setPhone(12345);
		user.setEnabled(true);
		user.setRole("ROLE_ADMIN");
		assertTrue("Problem in user Insertion", userDAO.saveUser(user));

	}
}
