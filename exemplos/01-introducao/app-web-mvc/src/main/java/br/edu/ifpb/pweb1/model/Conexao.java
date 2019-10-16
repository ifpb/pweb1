package br.edu.ifpb.pweb1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private Connection connection;
	
	public void conectar() throws Exception {
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/pweb1";
		String usuario = "postgres";
		String senha = "secret";
		Connection connection = DriverManager.getConnection(url, usuario, senha);
		this.connection = connection;
	}
	
	public void desconectar() throws SQLException {
		if (!this.connection.isClosed()) {
			this.connection.close();
		}
	}
	
	public Connection getConexao() {
		return this.connection;
	}
	
}
