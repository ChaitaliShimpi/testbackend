package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.supplierDAO;
import com.niit.model.supplier;

public class supplierUnitTest {
	static supplierDAO supplierDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		supplierDAO = (supplierDAO) context.getBean("supplierDAO");
	}

	
	@Test
	public void addsupplierTest() {
		supplier supplier = new supplier();
		supplier.setsuppId(22);
		supplier.setsuppName("maybelline");
		supplier.setsuppDesc("black");
		assertTrue("Problem in supplier Insertion", supplierDAO.addsupplier(supplier));

	}

	@Ignore
	@Test
	public void updatesupplierTest() {
		supplier supplier = new supplier();
		supplier.setsuppId(1);
		supplier.setsuppName("Foundation");
		supplier.setsuppDesc("gives glow on your face");
		assertTrue("Problem in supplier updation", supplierDAO.updatesupplier(supplier));
	}
	@Ignore
	@Test
	public void getOnesupplierTest() {
		supplier s = supplierDAO.getOnesupplier(1);
		System.out.println(s);
		assertNotNull("Problem in get supplier", supplierDAO.getOnesupplier(1));
	}

	@Ignore
	@Test
	public void deletesupplierTest() {
		assertTrue("problem in  deletion", supplierDAO.deletesupplier(1));
	}
	@Ignore
	@Test
	public void getallTest() {
		List<supplier> supplist = supplierDAO.getAllsupplier();
		for (supplier supplier : supplist) {
			System.out.println(supplier);
		}
		assertNotNull("problem in getting all supplier", supplierDAO.getAllsupplier());
	}
}
