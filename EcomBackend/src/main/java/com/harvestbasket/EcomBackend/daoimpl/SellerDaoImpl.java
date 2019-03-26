package com.harvestbasket.EcomBackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harvestbasket.EcomBackend.dao.SellerDao;
import com.harvestbasket.EcomBackend.model.Category;
import com.harvestbasket.EcomBackend.model.Seller;
import com.harvestbasket.EcomBackend.model.User;
import com.harvestbasket.EcomBackend.model.Usercred;

@Transactional
@Repository()
public class SellerDaoImpl implements SellerDao {

	@Autowired
    SessionFactory sessionFactory;
	
	@Override
	public boolean insertSeller(Seller seller) {
		try {
			Usercred uc=new Usercred();
			uc.setUsername(seller.getSname());
			uc.setPassword(seller.getSellerpassword());
			uc.setRole("ROLE_SELLER");
			uc.setSatus(false);
			sessionFactory.getCurrentSession().save(seller);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
		}		
		return false;
	}

	@Override
	public boolean updateSeller(Seller seller) {
		try {
	    	   sessionFactory.getCurrentSession().update(seller);
	    	   return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean deleteSeller(String sname) {
		try {
	    	   sessionFactory.getCurrentSession().delete(sname,Seller.class);
	    	   return true;
	    	   
		} catch (Exception e) {

		}
		return false;
	}

	@Override
	public List<Seller> selectAllSellers() {
		try {
		     return sessionFactory.getCurrentSession().createQuery("from Seller").list();
		}catch (Exception e) {
		}
		return null;
	}

	@Override
	public Seller selectOneSellers(String sname) {
		
		try {
			return(Seller)sessionFactory.getCurrentSession().createQuery("from Seller where sname='"+sname+ "'").uniqueResult();
		}catch (Exception e) {
			return null;
	}

}

	@Override
	public boolean insertSeller1(Seller c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertSeller11(Seller c) {
		// TODO Auto-generated method stub
		return false;
	}
}
