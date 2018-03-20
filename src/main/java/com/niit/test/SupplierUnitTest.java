package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierUnitTest {
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}

	
	@Test
	public void addSupplierTest() {
		Supplier supplier = new Supplier();
		supplier.setsuppId(22);
		supplier.setsuppName("maybelline");
		supplier.setsuppDesc("black");
		assertTrue("Problem in supplier Insertion", supplierDAO.addSupplier(supplier));

	}

	@Ignore
	@Test
	public void updateSupplierTest() {
		Supplier supplier = new Supplier();
		supplier.setsuppId(1);
		supplier.setsuppName("Foundation");
		supplier.setsuppDesc("gives glow on your face");
		assertTrue("Problem in supplier updation", supplierDAO.updateSupplier(supplier));
	}
	@Ignore
	@Test
	public void getOneSupplierTest() {
		Supplier s = supplierDAO.getOneSupplier(1);
		System.out.println(s);
		assertNotNull("Problem in get supplier", supplierDAO.getOneSupplier(1));
	}

	@Ignore
	@Test
	public void deleteSupplierTest() {
		assertTrue("problem in  deletion", supplierDAO.deleteSupplier(1));
	}
	@Ignore
	@Test
	public void getAllTest() {
		List<Supplier> supplist = supplierDAO.getAllSupplier();
		for (Supplier supplier : supplist) {
			System.out.println(supplier);
		}
		assertNotNull("problem in getting all supplier", supplierDAO.getAllSupplier());
	}
}
