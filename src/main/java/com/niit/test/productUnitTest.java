package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.productDAO;
import com.niit.model.category;
import com.niit.model.product;

public class productUnitTest {
	static productDAO productDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		productDAO = (productDAO) context.getBean("productDAO");
	}

	@Ignore
	@Test
	public void addproductTest() {
		product product = new product();
		//product.setProdId(4);
		product.setProdName("maybelline");
		product.setProdDesc("Purple");
		product.setQuantity(5);
		product.setPrice(500);
		product.setSuppid(5);
		product.setCatid(1);
		assertTrue("Problem in product Insertion", productDAO.addproduct(product));

	}

	@Ignore
	@Test
	public void updateproductTest() {
		product product = new product();
		product.setProdId(2);
		product.setProdName("lipstick");
		product.setProdDesc("gives glow on your face");
		assertTrue("Problem in product updation", productDAO.updateproduct(product));
	}

	@Ignore
	@Test
	public void getOneproductTest() {
		product p = productDAO.getOneproduct(1);
		System.out.println(p);
		assertNotNull("Problem in get Category", productDAO.getOneproduct(1));
	}
	
	@Test
	public void deleteproductTest(){
		assertTrue("Problem in assertion",productDAO.deleteproduct(1));
	}

	@Ignore
	@Test
	public void getallTest() {
		List<product> prodlist = productDAO.getallproduct();
		for (product product : prodlist) {
			System.out.println(product);
		}
		assertNotNull("problem in getting all categories", productDAO.getallproduct());
	}
}
