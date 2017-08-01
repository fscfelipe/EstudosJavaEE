package br.com.contatos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		Connection connection = null;

		try {

			connection = DriverManager.getConnection
					("jdbc:postgresql://localhost:5432/postgres", "postgres", "12345");

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}
		
		return connection;

	}

}
