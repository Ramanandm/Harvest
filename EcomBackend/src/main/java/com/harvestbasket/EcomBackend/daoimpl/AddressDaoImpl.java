package com.harvestbasket.EcomBackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harvestbasket.EcomBackend.dao.AddressDao;
import com.harvestbasket.EcomBackend.model.Address;

@Repository
@Transactional
public class AddressDaoImpl implements AddressDao{
	@Autowired
	SessionFactory sessionFactory;

	public boolean createAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().save(address);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateAddress(Address address) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(address);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteAddress(Address address) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(address);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<Address> selectAllAddress(int user_Id) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from Address where user="+user_Id).list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Address selectOneAddress(int address_Id) {
		// TODO Auto-generated method stub
		try {
			return (Address) sessionFactory.getCurrentSession().createQuery("from Address where address_Id=" + address_Id).uniqueResult();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
