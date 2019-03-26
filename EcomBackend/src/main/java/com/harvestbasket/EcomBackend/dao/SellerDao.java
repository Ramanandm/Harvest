package com.harvestbasket.EcomBackend.dao;

import java.util.List;

import com.harvestbasket.EcomBackend.model.Category;
import com.harvestbasket.EcomBackend.model.Seller;
import com.harvestbasket.EcomBackend.model.Seller;

public interface SellerDao {
	boolean insertSeller(Seller c);
	boolean updateSeller(Seller seller);
	boolean deleteSeller(String sname);
	List<Seller> selectAllSellers();
	Seller selectOneSellers(String sname);
	boolean insertSeller1(Seller seller);
	boolean insertSeller11(Seller c);



}
