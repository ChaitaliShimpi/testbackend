package com.niit.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.orderDAO;
import com.niit.model.order;

public class orderUnitTest {
	static orderDAO orderDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		orderDAO = (orderDAO) context.getBean("orderDAO");
	}

	@Test
	public void addOrderTest() {
		order o=new order();
		o.setOrderId(1);
		o.setDeliveryStatus("Pending");
		o.setOrderDate(new Date());
		o.setShippingAddress("dadar");
		o.setTotalAmount(1000);
		o.setTransactionType("cod");
		o.setUsername("chaitali2");
		assertTrue("Problem in order Insertion", orderDAO.addOrder(o));
	}
}
