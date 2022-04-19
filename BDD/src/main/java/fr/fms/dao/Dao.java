package fr.fms.dao;
import java.sql.Connection;

public interface Dao<T> {
	//public Connection connection = DbConnection.getConnection();
	
	public void createPrepared(T obj, Connection connection);
	public void updatePrepared(T obj, Connection connection);
	public void deletePrepared(int idArticle, Connection connection);
}
