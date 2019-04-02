package com.harvestbasket.EcomBackend.dao;

import java.util.List;

import com.harvestbasket.EcomBackend.model.User;

public interface UserDao {
	
	boolean insertUser(User u);
	boolean updateUser(User u);
	boolean deleteUser(String emailid);
	List<User> selectAllUser();
	User selectOneUser(String emailid);
}
