/**
 * 
 */
package com.jsflab.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;

/**
 * Controlador para el Login
 * @author Alberto
 *
 */
@Named
@ViewScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Logger log = Logger.getLogger(LoginController.class);
	
	private String username;
	private String password;
	
	/**
	 * Constructor por defecto
	 */
	public LoginController() {
		super();
	}
	
	public String loginAction(){
		
		log.info("Login");
		
		if (username.equals("Alberto") && password.equals("123"))
			return "entrar";
		else
			 FacesContext.getCurrentInstance().addMessage(password, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Usuario no valido!", "System Error"));
		
		return null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
