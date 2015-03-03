package com.jsflab.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.Query;

import com.jsflab.model.User;
/**
 * 
 * @author Alberto
 *
 */
@Named
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	private static final long serialVersionUID = 7680494513108369255L;

	@SuppressWarnings("unchecked")
	@Override
	public User loadUserByUsername(String username, String password) {
		
	    Query query = entityManager.createQuery("select u FROM Users u where"
	    		+ " u.username= :username and u.password");
	    query.setParameter("username", username);
	    List<User> lstUsers = query.getResultList();
	        if (lstUsers != null && lstUsers.size() == 1) {
	            return lstUsers.get(0);
	        }
	        return null;
	}

}
