package com.niit.DAO;

import java.util.List;

import com.niit.model.product;

public interface productDAO {
public boolean addproduct(product p);
public product getOneproduct(int productId);
public List<product> getallproduct();
public boolean deleteproduct(int productId);
public boolean updateproduct(product p);
}
