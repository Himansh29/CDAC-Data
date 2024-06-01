package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	private static Connection connection;
	private static final String DB_URL;
	private static final String DB_USERNAME;
	private static final String DB_PASSWORD;
	
	static {
		DB_URL = "jdbc:mysql://localhost:3306/voter_portal";
		DB_USERNAME = "root";
		DB_PASSWORD = "root";
	}
	
	public static Connection openConnection() throws SQLException {
		if(connection != null) {
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		}
		System.out.println("Connection created");
		return connection;
	}
	
	public static void closeConnection() throws SQLException {
		if(connection != null)
			connection.close();
		System.out.println("Connection closed");
	} 
	
}