package fr.fms;
import fr.fms.dao.UserDao;

import java.util.Scanner;

import fr.fms.dao.ArticlesDao;
import fr.fms.entities.Article;
import fr.fms.entities.User;

public class TestJdbc {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			System.out.println("Veuillez saisir un login : ");
			String log = scan.next();
			
			System.out.println("Veuillez saisir un mot de passe : ");
			String pwd = scan.next();
			
			User user = new User(log, pwd);
			
			if(user.userExists()) { 	//new UserDao<User>().isUser(user)
				System.out.println(new ArticlesDao<Article>().readAll());
				loop = false;
				scan.close();
			} else {
				System.out.println("Le compte n'existe pas.\n");
			}
			 
		}
		
		
		
		
		//Ex 8 - Users//
		//new UserDao<User>().create(new User("Jean", "123"));
		//new UserDao<User>().update(new User(3, "Jeanne", "123"));
		//new UserDao<User>().delete(3);
		//System.out.println(new UserDao<User>().read(2));
		//System.out.println(new UserDao<User>().readAll());
	
		//Ex 3 - Articles//				
		//System.out.println(new ArticlesDao<Article>().read(12));
		
//		System.out.println("\n-----\n");
//		System.out.println(new ArticlesDao<Article>().readAll());
//		new ArticlesDao<Article>().delete(51);
		
		//Ex 2//
		//ArrayList<Article> articles = new ArrayList<Article>(); 

//		try (Connection connection = DriverManager.getConnection(url, login, password)) {
//			String strSql = "SELECT * FROM t_articles";
//			try(Statement statement = connection.createStatement()){
//					try (ResultSet resultSet = statement.executeQuery(strSql)){
//					while(resultSet.next()) {
//						int rsIdArticle = resultSet.getInt(1);
//						String rsDescription = resultSet.getString(2);
//						String rsBrand = resultSet.getString(3);
//						double rsPrice = resultSet.getDouble(4);
//						articles.add(new Article(rsIdArticle, rsDescription, rsBrand, rsPrice));
//					}
//				}
//			}
//			for(Article a : articles) {
//				System.out.println(a.getIdArticle() + " - " + a.getDescription() + " - " + a.getBrand() + " - " + a.getPrice());
//			}
//				
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
	}

}
