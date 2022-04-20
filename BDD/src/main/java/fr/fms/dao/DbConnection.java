package fr.fms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	private static Connection connection = null;
	private static Properties prop;

	/**
	 * @return the connection
	 */
	public static Connection getConnection() {
		//static {
		try {
			if(connection == null) {
				prop = CreateConfigFile.readPropertiesFile("config.properties");
				Class.forName(prop.getProperty("db.driver.class"));
				
				String url = prop.getProperty("db.url");
				String login = prop.getProperty("db.login");
				String password = prop.getProperty("db.password");
				
				connection = DriverManager.getConnection(url, login, password);
			} 
			
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
		//}
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
