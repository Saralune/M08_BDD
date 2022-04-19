package fr.fms.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.fms.entities.Article;

public class ArticlesDao implements Dao<Article> {

	@Override
	public void createPrepared(Article obj, Connection connection) {
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
	public void updatePrepared(Article obj, Connection connection) {
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
		
	}

	@Override
	public void deletePrepared(int idArticle, Connection connection) {
		String str = "DELETE FROM t_articles WHERE IdArticle = ? ;";
		
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, idArticle);
			
			if(ps.executeUpdate() == 1) {
				System.out.println("Suppression ok.");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}			
	}


}
