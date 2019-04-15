package com.harvestbasket.EcomBackend.dao;

import java.util.List;

import com.harvestbasket.EcomBackend.model.Product;
import com.harvestbasket.EcomBackend.model.Seller;

public interface ProductDao {
	boolean insertProduct(Product c);
	boolean updateProduct(Product products);
	boolean deleteProduct(int productid);
	List<Product> selectAllProducts();
	List<Product> selectCatProducts(int id);
	Product selectOneProduct(int productid);
	
	
}
