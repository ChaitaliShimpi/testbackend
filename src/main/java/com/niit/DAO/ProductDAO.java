package com.niit.DAO;

import java.util.List;

import com.niit.model.Product;

public interface ProductDAO {
public boolean addProduct(Product p);
public Product getOneProduct(int productId);
public List<Product> getAllProduct();
public boolean deleteProduct(int productId);
public boolean updateProduct(Product p);
}
