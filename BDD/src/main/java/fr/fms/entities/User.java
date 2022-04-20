/**
 * 
 */
package fr.fms.entities;

import java.util.ArrayList;

import fr.fms.dao.UserDao;

/**
 * @author Stagiaires10P
 *
 */
public class User {
	private int idUser;
	private String login;
	private String password;
	
	/**
	 * @param idUser
	 * @param login
	 * @param password
	 */
	public User(int idUser, String login, String password) {
		setIdUser(idUser);
		setLogin(login);
		setPassword(password);
	}
	
	/**
	 * @param login
	 * @param password
	 */
	public User(String login, String password) {
		setLogin(login);
		setPassword(password);
	}

	public User() {
		
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	public boolean userExists() {
		ArrayList<User> list = new UserDao<User>().readAll();
		
		for (int i = 0; i < list.size(); i++) {		
			
			if(list.get(i).getLogin().equals(this.getLogin()) && list.get(i).getPassword().equals(this.getPassword())) {
				return true;
			} 
		}
		
		return false;
	}

	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "\nUser [idUser = " + idUser + ", login = " + login + ", password = " + password + "]";
	}
	
	
}
