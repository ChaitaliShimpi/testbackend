package com.niit.DAO;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierDAO {
	public boolean addSupplier(Supplier s);

	public Supplier getOneSupplier(int suppid);

	public List<Supplier> getAllSupplier();

	public boolean deleteSupplier(int suppid);

	public boolean updateSupplier(Supplier s);

}

