package br.com.contatos.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.contatos.jdbc.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) {
		
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conex�o aberta!");
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
