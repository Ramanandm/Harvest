package com.harvestbasket.EcomBackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harvestbasket.EcomBackend.dao.CategoryDao;
import com.harvestbasket.EcomBackend.model.Category;

@Transactional
@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
    SessionFactory sessionFactory;

	@Override
	public boolean insertCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
		}		

		return false;
	}

	@Override
	public boolean updateCategory(Category category) {
		try {
	    	   sessionFactory.getCurrentSession().update(category);
	    	   return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean deleteCategory(String categname) {
		try {
	    	   sessionFactory.getCurrentSession().delete(categname,Category.class);
	    	   return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<Category> selectAllCategories() {
		try {
		     return sessionFactory.getCurrentSession().createQuery("from Category").list();
		}catch (Exception e) {
		}
		return null;
	}

	@Override
	public Category selectOneCategory(String categname) {
		try {
			return (Category)sessionFactory.getCurrentSession().createQuery("from Category where categname ='"+categname+"'").uniqueResult();
		}catch (Exception e) {
			return null;
	}

}
}