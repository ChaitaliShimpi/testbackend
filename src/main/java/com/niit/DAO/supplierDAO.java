package com.niit.DAO;

import java.util.List;

import com.niit.model.supplier;

public interface supplierDAO {
	public boolean addsupplier(supplier s);

	public supplier getOnesupplier(int suppid);

	public List<supplier> getAllsupplier();

	public boolean deletesupplier(int suppid);

	public boolean updatesupplier(supplier s);

}

