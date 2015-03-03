package com.jsflab.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.jsflab.dao.UserDao;
import com.jsflab.model.User;
/**
 * 
 * @author Alberto
 *
 */
@Named
public class UserServiceImpl implements UserService {

	private final Logger log = Logger.getLogger(UserServiceImpl.class);
	
	@Inject
	private UserDao userDao;
	
	
	@Override
	public List<User> findAllUsers() {
		List<User> lstUsers=userDao.findAll();
		return lstUsers;
				
	}
	
	@Override
	@Transactional
	public void createUser(User user) {
		userDao.create(user);
	}

	@Override
	public User getUser(Integer id) {
		User user=userDao.findById(id);
		return user;
	}

	@Override
	@Transactional
	public void deleteUser(Integer id) {
		log.info("Delete usuario id: "+id);
		userDao.delete(id);
	}

	

}
