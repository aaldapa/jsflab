package com.jsflab.dao;

import com.jsflab.model.User;

public interface UserDao extends GenericDao<User> {

	/**
     * Devuelve un Object User que coincida con el username y password pasado
     *
     * @param username
     * @return
     */
    public User loadUserByUsername(String username, String password);

}
