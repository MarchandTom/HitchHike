package hitchhike;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public abstract class DAO<T>
{

	public Connection getConnection() throws Exception{
		
		Class.forName("org.sqlite.JDBC");

		String url = "jdbc:sqlite:C:hitchhike.db";

		Connection con = DriverManager.getConnection(url);
		
		return con;
	}


	public abstract ArrayList<T> findAll();
	
	public abstract int size();
}