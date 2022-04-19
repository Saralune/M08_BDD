import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import fr.fms.dao.ArticlesDao;
import fr.fms.dao.CreateConfigFile;
import fr.fms.entities.Article;

public class TestJdbc {

	public static void main(String[] args) {
		ArrayList<Article> articles = new ArrayList<Article>(); 
		
//		try {

			//Ex 3 - ajout d'un article//
			/*Article artCreated = new Article("Caméra", "Marque", 200, 1);
			
			try (Connection connection = DriverManager.getConnection(url, login, password)) {
				ArticlesDao articlesDao = new ArticlesDao();
				articlesDao.createPrepared(artCreated, connection);
			} catch(SQLException e) {
				e.printStackTrace();
			}*/
			
			
			//Ex 3 - mise à jour de la table//
			/*Article artUpdated = new Article(18, 125.5);
			try (Connection connection = DriverManager.getConnection(url, login, password)) {
				ArticlesDao articlesDao = new ArticlesDao();
				articlesDao.updatePrepared(artUpdated, connection);
				
			} catch(SQLException e) {
				e.printStackTrace();
			}*/
			
			//Ex 3 - suppression d'un article//
			/*try (Connection connection = DriverManager.getConnection(url, login, password)) {
				ArticlesDao articlesDao = new ArticlesDao();
				articlesDao.deletePrepared(17, connection);
				
			} catch(SQLException e) {
				e.printStackTrace();
			}*/
			
			//Ex 3 - infos d'un article//				
			new ArticlesDao<Article>().read(11);
			
			System.out.println("\n-----\n");
			
			//Ex 2//
//			try (Connection connection = DriverManager.getConnection(url, login, password)) {
//				String strSql = "SELECT * FROM t_articles";
//				try(Statement statement = connection.createStatement()){
//					try (ResultSet resultSet = statement.executeQuery(strSql)){
//						while(resultSet.next()) {
//							int rsIdArticle = resultSet.getInt(1);
//							String rsDescription = resultSet.getString(2);
//							String rsBrand = resultSet.getString(3);
//							double rsPrice = resultSet.getDouble(4);
//							articles.add(new Article(rsIdArticle, rsDescription, rsBrand, rsPrice));
//						}
//					}
//				}
//				for(Article a : articles) {
//					System.out.println(a.getIdArticle() + " - " + a.getDescription() + " - " + a.getBrand() + " - " + a.getPrice());
//				}
//				
//			} catch(SQLException e) {
//				e.printStackTrace();
//			}
		
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}

}
