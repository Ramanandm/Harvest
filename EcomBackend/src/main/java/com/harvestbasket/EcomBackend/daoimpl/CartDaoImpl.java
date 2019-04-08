package com.harvestbasket.EcomBackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.hql.internal.ast.tree.SelectClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harvestbasket.EcomBackend.dao.CartDao;
import com.harvestbasket.EcomBackend.model.Cart;
import com.harvestbasket.EcomBackend.model.Category;
import com.harvestbasket.EcomBackend.model.User;

@Transactional
@Repository
public class CartDaoImpl implements CartDao {
     
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean inserCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
		}		
		return false;
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
	    	   sessionFactory.getCurrentSession().update(cart);
	    	   return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean deleteCart(int itemid) {
		try {
	    	   sessionFactory.getCurrentSession().delete(selectOneCart(itemid));
	    	   return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<Cart> selectAllCarts(User user) {
		try {
		     return sessionFactory.getCurrentSession().createQuery("from Cart where User="+user.getCusid()).list();
		}catch (Exception e) {
		}
		return null;
	}

	@Override
	public Cart selectOneCart(int itemid) {
		try {
			return(Cart)sessionFactory.getCurrentSession().createQuery("from Cart where itemid ="+itemid).uniqueResult();
		}catch (Exception e) {
			return null;
	}

	}

}
