package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.Bean.UserBean;

public class UserDAO {

	private Connection conn;
	private PreparedStatement ps;
	
	public UserDAO(){
		
		conn = new ConnectionFactory().getConnection();
	}
	
	
	public void inserirUser(UserBean user) {
		
		String sql = "INSERT INTO Usuario (nome,email,senha) values(?,?.?)";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getNome());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getSenha());
			ps.execute();
			ps.close();
			
		} catch (Exception e) {
			throw new RuntimeException("Não conseguiu inserir Usuario", e);
		}
		
		
	}
	
	
	
	
}
