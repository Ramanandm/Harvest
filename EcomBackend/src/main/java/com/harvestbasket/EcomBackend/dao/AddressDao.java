package com.harvestbasket.EcomBackend.dao;

import java.util.List;

import com.harvestbasket.EcomBackend.model.Address;

public interface AddressDao {

	boolean createAddress(Address address);

	boolean updateAddress(Address address);

	boolean deleteAddress(Address address);

	List<Address> selectAllAddress(int user_Id);

	Address selectOneAddress(int address_Id);
}
