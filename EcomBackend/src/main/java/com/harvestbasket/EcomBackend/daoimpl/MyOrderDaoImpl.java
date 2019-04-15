package com.harvestbasket.EcomBackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harvestbasket.EcomBackend.dao.MyOrderDao;
import com.harvestbasket.EcomBackend.model.Cart;
import com.harvestbasket.EcomBackend.model.MyOrder;
import com.harvestbasket.EcomBackend.model.User;

@Transactional
@Repository
public class MyOrderDaoImpl implements MyOrderDao {
    
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean insertMyOrder(MyOrder myorder) {
		try {
			sessionFactory.getCurrentSession().save(myorder);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
		}		
		return false;
	}

	@Override
	public boolean upadateMyOrder(MyOrder myorder) {
		try {
	    	   sessionFactory.getCurrentSession().update(myorder);
	    	   return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	@Override
	public boolean deleteMyOrder(String orderid) {
		try {
	    	   sessionFactory.getCurrentSession().delete(selectOneMyOrder(orderid));
	    	   return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<MyOrder> selectAllMyOrders(User user) {
		try {
		     return sessionFactory.getCurrentSession().createQuery("from MyOrder where User="+user.getCusid()).list();
		}catch (Exception e) {
		}
		return null;
	}

	@Override
	public MyOrder selectOneMyOrder(String orderid) {
		try {
			return(MyOrder)sessionFactory.getCurrentSession().createQuery("from Cart where orderid ="+orderid).uniqueResult();
		}catch (Exception e) {
			return null;
	}

	}

	@Override
	public List<MyOrder> selectAllMyOrders(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
