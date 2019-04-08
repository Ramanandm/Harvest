package com.harvestbasket.EcomBackend.dao;

import java.util.List;

import com.harvestbasket.EcomBackend.model.Cart;
import com.harvestbasket.EcomBackend.model.User;

public interface CartDao {
	
	boolean inserCart(Cart cart);
	boolean updateCart(Cart cart);
	boolean deleteCart(int itemid);
    List<Cart>selectAllCarts(User user);
    Cart selectOneCart(int itemid);

    
	
}
