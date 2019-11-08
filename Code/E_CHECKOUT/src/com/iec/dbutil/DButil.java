package com.iec.dbutil;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	private static Connection connection;
	// if i made here static then no need to make object of this

	public static Connection getConnection() {
		// load the driver class
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			} catch (SQLException e) {
				// System.out.println(e);
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("connection could not be establish" + e);
			e.printStackTrace();
		}
		System.out.println("Connection established");
		return connection;
	}

	public static void main(String args[]) {

		System.out.print(getConnection());
		// i directly call the getconnection method because in the same method i
		// call them.
	}

}
