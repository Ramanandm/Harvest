package com.harvestbasket.EcomBackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harvestbasket.EcomBackend.dao.UserDao;
import com.harvetbasket.EcomBackend.model.User;
import com.harvetbasket.EcomBackend.model.Usercred;

@Transactional
@Repository()
public class UserDaoImpl implements UserDao {
	
	@Autowired
    SessionFactory sessionFactory;
	
	@Override
	public boolean insertUser(User user) {
		try {
			Usercred uc=new Usercred();
			uc.setUsername(user.getEmailid());
			uc.setPassword(user.getPassword());
			uc.setRole("ROLE_USER");
			uc.setSatus(false);
			sessionFactory.getCurrentSession().save(user);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
		}		
		return false;
	}

	@Override
	public boolean updateUser(User user) {
       try {
    	   sessionFactory.getCurrentSession().update(user);
    	   return true;
	} catch (Exception e) {
		// TODO: handle exception
	}
		return false;
	}

	@Override
	public boolean deleteUser(String emailid) {
		 try {
	    	   sessionFactory.getCurrentSession().delete(emailid,User.class);
	    	   return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> selectAllUser() {
		try {
		     return sessionFactory.getCurrentSession().createQuery("from User").list();
		}catch (Exception e) {
		}
		return null;
	}

	@Override
	public User selectOneUser(String emailid) {
		try {
			return(User)sessionFactory.getCurrentSession().createQuery("from user where Useremailid='"+emailid+ "'").uniqueResult();
		}catch (Exception e) {
			return null;
		
		}
	
	}

}
