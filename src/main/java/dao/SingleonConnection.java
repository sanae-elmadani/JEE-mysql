package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleonConnection {
	//quand une classe est charger au memoire le premier bloc qui s execute est le bloc static 
	private static Connection connection;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_catal", "root","");
			 System.out.println("connecter");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}
	
	public static Connection getConnection() {
		return connection;
		
	}
	

}
