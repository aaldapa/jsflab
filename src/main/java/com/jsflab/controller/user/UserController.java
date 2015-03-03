/**
 * Gestion de Usuarios
 */
package com.jsflab.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;

import com.jsflab.model.User;
import com.jsflab.service.UserService;

/**
 * @author Alberto
 *
 */
@Named(value="userBean")
@RequestScoped
public class UserController {

	private final Logger log = Logger.getLogger(UserController.class);
	
	@Inject
	private UserService userService;
	
	private List<User> lstUsers=new ArrayList<User>();
	
	private User selectedUser= new User();
	private User user;
	
	private Boolean selectedRow;

	
	public String doLoadForm(User usuario){
		setUser(usuario);
		return "formulario";
	}
	
	public String doLoadForm(){
		setUser(new User());
		return "formulario";
	}
	
	
	/**
	 * Eliminar usuario mediante el "row boton" de la tabla
	 * @param usuario
	 */
	public void doDeleteUser(User usuario){		
		this.deleteUser(usuario);
	}
	
	/**
	 * Elimina el usuario seleccionado de la tabla mediante el boton inferior
	 */
	public void doDeleteUsers(){
		this.deleteUser(selectedUser);
    }
	/**
	 * Guarda un usuario en base de datos
	 */
	public void doSaveUser(){
		userService.createUser(user);
		user=new User();
	}
	/**
	 * Carga la lista con todos los usuarios y devuelve el outcome userList para mostrar la pagina del listado.
	 * Se utiliza en la llamada desde el menu y desde el volver del formulario 
	 * @return
	 */
	public String doListUsers(){
		lstUsers=userService.findAllUsers();
		return "userList";
	}
	
    public void onRowSelect(SelectEvent event) {  
//        FacesMessage msg = new FacesMessage("Usuario seleccionado", ((User) event.getObject()).getNombre());  
//        FacesContext.getCurrentInstance().addMessage(null, msg); 
//        
    	selectedRow=true;
    }  
  
    /**
     * Los metodos que reciben una peticion Ajax de jsf deben recibir un objeto AjaxBehaviorEvent.
     * Las peticiones Ajax de primefaces reciben objetos mas especificos relacionados con el evento que los dispara, por ejemplo  en este cas, seria SelectEvent
     * @param event
     */
    public void onRowSelect(AjaxBehaviorEvent event) {  
    	log.info(event);
    	selectedRow=true;
  }  

    
    public void onRowUnselect(AjaxBehaviorEvent event) {  
//        FacesMessage msg = new FacesMessage("Usuario deseleccionado", ((User) event.getObject()).getNombre());  
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    	selectedRow=false;
    }  
	
	
	/**
	 * Elimina el usuario de la tabla y de la base de datos
	 * @param usuario
	 */
	private void deleteUser(User usuario){
		//Borro el usuario de la base de datos
		userService.deleteUser(usuario.getIdUser());
		//Elimino el usuario de la tabla		
		lstUsers.remove(selectedUser);
	}
	
	public List<User> getLstUsers() {
		return lstUsers;
	}

	public void setLstUsers(List<User> lstUsers) {
		this.lstUsers = lstUsers;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(Boolean selectedRow) {
		this.selectedRow = selectedRow;
	}

}
