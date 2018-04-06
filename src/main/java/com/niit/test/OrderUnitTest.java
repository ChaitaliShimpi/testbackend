package com.niit.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.OrderDAO;
import com.niit.model.Order;

public class OrderUnitTest {
	static OrderDAO orderDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		orderDAO = (OrderDAO) context.getBean("orderDAO");
	}

	@Test
	public void addOrderTest() {
		Order o=new Order();
		o.setOrderId(1);
		o.setDeliveryStatus("Pending");
		o.setOrderDate(new Date());
		o.setShippingAddress("malad");
		o.setTotalAmount(1000);
		o.setTransactionType("cod");
		o.setUsername("chaitali2");
		o.setState("maharashtra");
		o.setPincode(400092);
		assertTrue("Problem in order Insertion", orderDAO.addOrder(o));
	}
}
