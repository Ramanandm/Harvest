package com.harvestbasket.EcomBackend.dao;

import java.util.List;

import com.harvestbasket.EcomBackend.model.Cart;
import com.harvestbasket.EcomBackend.model.User;

public interface CartDao {
	
	boolean insertCart(Cart cart);
	boolean updateCart(Cart cart);
	boolean deleteCart(Cart cart);
    List<Cart>selectAllCarts(int itemid);
    Cart selectOneCart(int itemid);
	boolean deleteCart(int itemid);
	List<Cart> selectAllCarts(User user);

    
	
}
