package com.niit.DAO;

import java.util.List;
import com.niit.model.*;

public interface CartDAO {

	public boolean addCart(Cart ca);
	public boolean deleteCart(int cartId);
	public List<Cart> getAllcart(String username);
	public Cart getOnecartitem(int cartId);
	public List<Cart> getAllUnpaidItem(String username);

}
