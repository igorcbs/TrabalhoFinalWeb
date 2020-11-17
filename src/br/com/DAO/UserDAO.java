package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.Bean.UserBean;

public class UserDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Statement st;
	private ArrayList<UserBean> users = new ArrayList<UserBean>();
	
	public UserDAO(){
		
		conn = new ConnectionFactory().getConnection();
	}
	
	//Inserir
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
	
	//Mudar os atributos do rs.get pois o banco não está criado
	public ArrayList<UserBean> listarUser() {
		String sql = "SELECT * FROM Usuario";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				UserBean user = new UserBean(rs.getString("nome"),rs.getString("email"),rs.getString("senha"),rs.getString("id_Usuario"));
				users.add(user);
			}
 			
			
		} catch (Exception e) {
			throw new RuntimeException("Não conseguiu recuperar usuarios", e);
			
		}
		
		return users;
	}
	
	///Atualizar
	public void atualizarUser(UserBean user) {
		
		String sql = "UPDATE Usuario SET nome = ?, email = ? WHERE id_Usuario = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getNome());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getSenha());
			ps.execute();
			ps.close();
			
		} catch (Exception e) {
			throw new RuntimeException("Não conseguiu atualizar o usuario", e);
		}
		
	}
	
	//Excluir
	public void excluirPessoa(String idUser) {
		
		String sql = "DELETE FROM Usuario WHERE id_Usuario = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idUser);
			ps.execute();
			ps.close();
			
		} catch (Exception e) {
			throw new RuntimeException("Não conseguiu excluir o usuario", e);
		}
		
	}
	
}
