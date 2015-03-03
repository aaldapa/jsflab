package com.jsflab.service;

import java.util.List;

import com.jsflab.model.User;
/**
 * 
 * @author Alberto
 *
 */
public interface UserService {

	public List<User> findAllUsers();
	public void createUser(User user);
	public User getUser(Integer id); 
	public void deleteUser(Integer id);
	
}
