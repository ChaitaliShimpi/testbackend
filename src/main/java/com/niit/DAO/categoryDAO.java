package com.niit.DAO;

import java.util.List;

import com.niit.model.category;

public interface categoryDAO {
	public boolean addCategory(category c);

	public category getOnecategory(int catid);

	public List<category> getallcategory();

	public boolean deletecategory(int catid);

	public boolean updatecategory(category c);

}
