package com.niit.shopppingcartdao;

import java.util.List;

import com.niit.shoppingcart.model.Supplier;

public interface SupplierDAO {
	public List<Supplier> list();

	public Supplier get(String id);

	public void saveOrUpdate(Supplier supplier);

	public void delete(String id);

}
