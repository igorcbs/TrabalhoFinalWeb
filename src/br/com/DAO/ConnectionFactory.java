package br.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection() {
		
		
		//Copiar a url(apertar com o botao direito no banco quando iniciar o mysql e copiar a  url colocando no final o nome do banco) ,
		//user e password da conexão com o mysql
		String url = "jdbc:mysql://127.0.0.1:3306/?user=dbtrabalhoweb";
		String user = "root";
		//String password = "81565534";
		String password = "Victor@001";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (Exception error) {
			throw new RuntimeException("Conexão Falhou", error);
		}
	}
	
}
