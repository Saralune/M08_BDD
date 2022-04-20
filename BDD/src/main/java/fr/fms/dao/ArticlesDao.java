package fr.fms.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		String str = "DELETE FROM t_articles WHERE IdArticle = ?;";
		 
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
	public Article read(int id) {
		String strSql = "SELECT * from t_articles WHERE idArticle = ?;";
		
		try(PreparedStatement ps = connection.prepareStatement(strSql)){
			ps.setInt(1, id);
			
			//exceute la requête
			try (ResultSet resultSet = ps.executeQuery()){	
				//affiche le résultat
				resultSet.next();
				
				//récupère les infos du résultat
				int rsIdArticle = resultSet.getInt(1);
				String rsDescription = resultSet.getString(2);
				String rsBrand = resultSet.getString(3);
				double rsPrice = resultSet.getDouble(4);
				
				return new Article(rsIdArticle, rsDescription, rsBrand, rsPrice);
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<Article> readAll() {
		ArrayList<Article> res = new ArrayList<Article>();
		String strSql = "SELECT * from t_articles;";

		try(PreparedStatement ps = connection.prepareStatement(strSql)){
			try (ResultSet resultSet = ps.executeQuery()){
				//affiche tous les résultats
				while(resultSet.next()) {
					
					int rsIdArticle = resultSet.getInt(1);
					String rsDescription = resultSet.getString(2);
					String rsBrand = resultSet.getString(3);
					double rsPrice = resultSet.getDouble(4);
					
					res.add(new Article(rsIdArticle, rsDescription, rsBrand, rsPrice));
				}
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
}

