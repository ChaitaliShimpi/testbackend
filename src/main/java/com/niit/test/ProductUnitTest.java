package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;

public class ProductUnitTest {
	static ProductDAO productDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	@Ignore
	@Test
	public void addProductTest() {
		Product product = new Product();
		//product.setProdId(4);
		product.setProdName("maybelline");
		product.setProdDesc("Purple");
		product.setQuantity(5);
		product.setPrice(500);
		product.setSuppid(5);
		product.setCatid(1);
		assertTrue("Problem in product Insertion", productDAO.addProduct(product));

	}

	@Ignore
	@Test
	public void updateProductTest() {
		Product product = new Product();
		product.setProdId(2);
		product.setProdName("lipstick");
		product.setProdDesc("gives glow on your face");
		assertTrue("Problem in product updation", productDAO.updateProduct(product));
	}

	@Ignore
	@Test
	public void getOneProductTest() {
		Product p = productDAO.getOneProduct(1);
		System.out.println(p);
		assertNotNull("Problem in get Category", productDAO.getOneProduct(1));
	}
	
	@Test
	public void deleteProductTest(){
		assertTrue("Problem in assertion",productDAO.deleteProduct(1));
	}

	@Ignore
	@Test
	public void getAllTest() {
		List<Product> prodlist = productDAO.getAllProduct();
		for (Product product : prodlist) {
			System.out.println(product);
		}
		assertNotNull("problem in getting all categories", productDAO.getAllProduct());
	}
}
