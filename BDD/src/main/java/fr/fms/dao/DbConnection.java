package fr.fms.dao;

import java.sql.Connection;

public class DbConnection {
	private Connection connection;

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	
}
