package com.niit.DAO;

import java.util.List;

import com.niit.model.order;

public interface orderDAO {
public boolean addOrder(order o);
public order getOrder(int orderId);
}
