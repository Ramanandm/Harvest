package com.harvestbasket.EcomBackend.dao;

import java.util.List;

import com.harvestbasket.EcomBackend.model.MyOrder;
import com.harvestbasket.EcomBackend.model.User;

public interface MyOrderDao {

	boolean insertMyOrder(MyOrder myorder);
	boolean upadateMyOrder(MyOrder myorder);
	boolean deleteMyOrder(String orderid);
	List<MyOrder>selectAllMyOrders(int i);
	MyOrder selectOneMyOrder(String orderid);
	List<MyOrder> selectAllMyOrders(User user);
	
}
