package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBConnection {
	public Connection getConnection() {
		Connection conn = null;
		String connectionURL = "jdbc:mysql://localhost:3306/mydb";
		String username="root";
		String pswd="0000";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		} catch (IllegalAccessException ex) {
			System.out.println("Error: access problem while loading!");
			System.exit(2);
		} catch (InstantiationException ex) {
			System.out.println("Error: unable to instantiate driver!");
			System.exit(3);
		}
		//System.out.println("MySQL JDBC Driver Registered!");
		try {
			conn = DriverManager.getConnection(connectionURL, username, pswd);

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		if (conn != null) {
			System.out.println("Connection established!");
		} else {
			System.out.println("Failed to make connection!");
		}
		return conn;
	}
}
