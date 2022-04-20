package fr.fms.dao;
import java.sql.Connection;
import java.util.ArrayList;

import fr.fms.entities.Article;

public interface Dao<T> {
	public Connection connection = DbConnection.getConnection();
	
	public void create(T obj);
	public boolean update(T obj);
	public boolean delete(int id);
	public T read(int id); 
	public ArrayList<T> readAll();
}
