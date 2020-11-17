package br.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection() {
		
		
		//Copiar a url(apertar com o botao direito no banco quando iniciar o mysql e copiar a  url colocando no final o nome do banco) ,
		//user e password da conexão com o mysql
		String url = "";
		String user = "";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (Exception error) {
			throw new RuntimeException("Conexão Falhou", error);
		}
	}
	
}
