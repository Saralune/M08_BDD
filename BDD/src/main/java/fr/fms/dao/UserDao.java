/**
 * 
 */
package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Article;
import fr.fms.entities.User;

/**
 * @author Stagiaires10P
 *
 */
public class UserDao implements Dao<User> {

	@Override
	public void create(User obj) {
		String str = "INSERT INTO T_Users (Login, Password) VALUES (?, ?);";
		
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPassword());
			
			if(ps.executeUpdate() == 1) {
				System.out.println("Insertion d'utilisateur ok.");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}		
		
	}

	@Override
	public boolean update(User obj) {
		String str = "UPDATE t_users SET Login = ? WHERE IdUser = ?;";
		
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getLogin());
			ps.setInt(2, obj.getIdUser());
			
			if(ps.executeUpdate() == 1) {
				System.out.println("Modification de l'utilisateur ok.");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}	
		
		return true;
	}

	@Override
	public boolean delete(int id) {
		String str = "DELETE FROM t_users WHERE IdUser = ?;";
		 
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, id);
			
			if(ps.executeUpdate() == 1) {
				System.out.println("Suppression de l'utilisateur ok.");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return true;	
	}

	@Override
	public User read(int id) {
		String strSql = "SELECT * from t_users WHERE idUser = ?;";

		try(PreparedStatement ps = connection.prepareStatement(strSql)){
			ps.setInt(1, id);
			
			try (ResultSet resultSet = ps.executeQuery()){	
				resultSet.next();
				
				int rsIdUser = resultSet.getInt(1);
				String rsLogin = resultSet.getString(2);
				String rsPassword = resultSet.getString(3);
				
				return new User(rsIdUser, rsLogin, rsPassword);
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<User> readAll() {
		ArrayList<User> res = new ArrayList<User>();
		String strSql = "SELECT * from t_users;";

		try(PreparedStatement ps = connection.prepareStatement(strSql)){
			try (ResultSet resultSet = ps.executeQuery()){	
				while(resultSet.next()) {
					
					int rsIdUser = resultSet.getInt(1);
					String rsLogin = resultSet.getString(2);
					String rsPassword = resultSet.getString(3);
					
					res.add(new User(rsIdUser, rsLogin, rsPassword));
				}
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public boolean isUser(User user) {
		ArrayList<User> list = readAll();
		
		for (int i = 0; i < list.size(); i++) {		
			
			if(list.get(i).getLogin().equals(user.getLogin()) && list.get(i).getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		
		return false;
	}
}
