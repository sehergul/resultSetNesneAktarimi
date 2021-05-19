package com.example.resultSetNesneAktarimi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
	private String userName="postgres";
	private String password="12345";
	private String dbUrl="jdbc:postgresql://localhost/dbUrun";
	
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbUrl, userName, password);

	}
	
	public void showErrorMessage(SQLException exception) {
		System.out.println("Error: " + exception.getMessage());
		System.out.println("Error code: " + exception.getErrorCode());
	}
}
