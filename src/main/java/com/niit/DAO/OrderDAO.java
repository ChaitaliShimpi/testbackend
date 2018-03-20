package com.niit.DAO;

import java.util.List;

import com.niit.model.Order;

public interface OrderDAO {
public boolean addOrder(Order o);
public Order getOrder(int orderId);
}
