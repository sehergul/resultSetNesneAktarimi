package com.example.resultSetNesneAktarimi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class Main {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		DbHelper dbHelper = new DbHelper();
		Statement statement= null;
		ResultSet resultSet;
		try {
			connection = dbHelper.getConnection();
			statement= connection.createStatement();
			resultSet = statement.executeQuery("select id,ad,soyad,sehir,meslek,bakiye from musteri");
			ArrayList<Musteri> musteriler = new ArrayList<Musteri>();
			while(resultSet.next()) {
				musteriler.add(new Musteri(resultSet.getInt("id"),
						resultSet.getString("ad"),
						resultSet.getString("soyad"),
						resultSet.getString("sehir"),
						resultSet.getString("meslek"),
						resultSet.getInt("bakiye")));
			}
			System.out.println("Musteri sayisi: " + musteriler.size());
		}catch(SQLException sqlException) {
			dbHelper.showErrorMessage(sqlException);
		}finally {
			connection.close();
		}
		

	}
}