package com.niit.DAO;

import java.util.List;
import com.niit.model.*;

public interface cartDAO {

	public boolean addCart(cart ca);
	public boolean deleteCart(int cartId);
	public List<cart> getAllcart(String username);
	public cart getOnecartitem(int cartId);
	public List<cart> getAllUnpaidItem(String username);
	public List<cart> getAllPaidItem(String username);
	
}
