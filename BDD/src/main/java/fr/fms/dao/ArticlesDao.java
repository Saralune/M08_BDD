package fr.fms.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Article;

public class ArticlesDao<T> implements Dao<Article> {

	@Override
	public void create(Article obj) {
		String str = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice, IdCat) VALUES (?, ?, ?, ?);";
		
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getDescription());
			ps.setString(2, obj.getBrand());
			ps.setDouble(3, obj.getPrice());
			ps.setInt(4, obj.getIdCat());
			
			if(ps.executeUpdate() == 1) {
				System.out.println("Insertion ok.");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public boolean update(Article obj) {
		String str = "UPDATE t_articles SET UnitaryPrice = ? WHERE IdArticle = ?;";
		
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setDouble(1, obj.getPrice());
			ps.setInt(2, obj.getIdArticle());
			
			if(ps.executeUpdate() == 1) {
				System.out.println("Modification ok.");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}	
		
		return true;
	}

	@Override
	public boolean delete(int id) {
		String str = "DELETE FROM t_articles WHERE IdArticle = ? ;";
		 
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, id);
			
			if(ps.executeUpdate() == 1) {
				System.out.println("Suppression ok.");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return true;			
	}

	//Ex 3 - infos d'un article//
	@Override
	public void read(int id) { //doit retourner T
		String strSql = "SELECT * from t_articles WHERE idArticle = ?;";
				 
		try(PreparedStatement ps = connection.prepareStatement(strSql)){
			ps.setInt(1, id);
			ps.executeUpdate();
						
			if(ps.executeUpdate() == 1) {
				System.out.println("Lecture.");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		//return objet; 
//		try(Statement statement = connection.createStatement()){
//			try (ResultSet resultSet = statement.executeQuery(strSql)){
//				resultSet.getInt(id);
//				
//				while(resultSet.next()) {
//					int rsIdArticle = resultSet.getInt(1);
//					String rsDescription = resultSet.getString(2);
//					String rsBrand = resultSet.getString(3);
//					double rsPrice = resultSet.getDouble(4);
//					
//					System.out.println(rsIdArticle + " - " + rsDescription + " - " + rsBrand + " - " + rsPrice);
//				}
//			}
//		
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public ArrayList<Article> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public ArrayList<Article> readAll() {
//		ArrayList<T> results = new ArrayList<T>();
//		String strSql = "SELECT * from t_articles WHERE;";
//		
//		//return objet; 
//		try(Statement statement = connection.createStatement()){
//			try (ResultSet resultSet = statement.executeQuery(strSql)){
//				while(resultSet.next()) {
//					if(resultSet instanceof ArticlesDao) {
//						int rsId = resultSet.getInt(1);
//						String rsDescription = resultSet.getString(2);
//						String rsBrand = resultSet.getString(3);
//						double rsPrice = resultSet.getDouble(4);
//						
//						results.add(new Article(rsId, rsDescription, rsBrand, rsPrice));
//						
//						System.out.println(rsId + " - " + rsDescription + " - " + rsBrand + " - " + rsPrice);
//					}
//					
//				}
//			}
//		
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return results;
}

