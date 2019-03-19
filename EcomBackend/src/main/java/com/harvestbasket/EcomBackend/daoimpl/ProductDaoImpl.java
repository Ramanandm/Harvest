package com.harvestbasket.EcomBackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harvestbasket.EcomBackend.dao.ProductDao;
import com.harvestbasket.EcomBackend.model.Category;
import com.harvestbasket.EcomBackend.model.Product;
import com.harvestbasket.EcomBackend.model.Seller;

@Transactional
@Repository()
public class ProductDaoImpl implements ProductDao {

	@Autowired
    SessionFactory sessionFactory;
	
	@Override
	public boolean insertProduct(Product products) {
		try {
			sessionFactory.getCurrentSession().save(products);
			return true;
		}catch (Exception e) 
		{
		}		
		return false;
	}

	@Override
	public boolean updateProduct(Product products) {
		try {
 	   sessionFactory.getCurrentSession().update(products);
		return true;
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int productid)
	{
		try {
	    	   sessionFactory.getCurrentSession().delete(productid);
	    	   return true;
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public List<ProductDao> selectAllProducts() {
		try {
		     return sessionFactory.getCurrentSession().createQuery("from Product").list();
		}catch (Exception e) {
		}
		return null;
	}
	

	@Override
	public ProductDao selectOneProducts(int productid) {
		try {
			return (ProductDao)sessionFactory.getCurrentSession().createQuery("from Product where productid ='"+productid+"'").uniqueResult();
		}catch (Exception e) {
			return null;
	}
	}

}
