package com.harvestbasket.EcomBackend.dao;

import java.util.List;

import com.harvestbasket.EcomBackend.model.Seller;

public interface SellerDao {
	boolean insertSeller(Seller seller);
	boolean updateSeller(Seller seller);
	boolean deleteSeller(String sname);
	List<Seller> selectAllSellers();
	Seller selectOneSellers(String sname);



}
