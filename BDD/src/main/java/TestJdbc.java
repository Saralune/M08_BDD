import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import fr.fms.dao.CreateConfigFile;
import fr.fms.entities.Article;

public class TestJdbc {

	public static void main(String[] args) {
		ArrayList<Article> articles = new ArrayList<Article>(); 
		
		try {
			Properties prop = CreateConfigFile.readPropertiesFile("config.properties");
			Class.forName(prop.getProperty("db.driver.class"));
			
			String url = prop.getProperty("db.url");
			String login = prop.getProperty("db.login");
			String password = prop.getProperty("db.password");
		
	//		try {
	//			Class.forName("org.mariadb.jdbc.Driver");
	//		} 		
	//		String url = "jdbc:mariadb://localhost:3306/shop";
	//		String login = "root";
	//		String password = "fms2022";
			
			
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
			try (Connection connection = DriverManager.getConnection(url, login, password)) {
				String strSql = "SELECT t.idArticle, t.description, t.brand, t.unitaryprice, category.CatName from t_articles AS t "
						+ "inner join category where t.idcat = category.idcat AND t.idArticle = 11;";
				try(Statement statement = connection.createStatement()){
					try (ResultSet resultSet = statement.executeQuery(strSql)){
						while(resultSet.next()) {
							int rsIdArticle = resultSet.getInt(1);
							String rsDescription = resultSet.getString(2);
							String rsBrand = resultSet.getString(3);
							double rsPrice = resultSet.getDouble(4);
							String rsCatName = resultSet.getString(5);
							
							System.out.println(rsIdArticle + " - " + rsDescription + " - " + rsBrand + " - " + rsPrice + " - " + rsCatName);
						}
					}
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("\n-----\n");
			
			//Ex 2//
			try (Connection connection = DriverManager.getConnection(url, login, password)) {
				String strSql = "SELECT * FROM t_articles";
				try(Statement statement = connection.createStatement()){
					try (ResultSet resultSet = statement.executeQuery(strSql)){
						while(resultSet.next()) {
							int rsIdArticle = resultSet.getInt(1);
							String rsDescription = resultSet.getString(2);
							String rsBrand = resultSet.getString(3);
							double rsPrice = resultSet.getDouble(4);
							articles.add(new Article(rsIdArticle, rsDescription, rsBrand, rsPrice));
						}
					}
				}
				for(Article a : articles) {
					System.out.println(a.getIdArticle() + " - " + a.getDescription() + " - " + a.getBrand() + " - " + a.getPrice());
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
