package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.Bean.GameBean;
import br.com.Bean.GameState;

public class GameDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Statement st;
	private ArrayList<GameBean> users = new ArrayList<GameBean>();
	
	public GameDAO(){
		
		conn = new ConnectionFactory().getConnection();
	}
	
	//Inserir
	public void inserirUser(GameBean game) {
		
		String sql = "INSERT INTO Usuario (nome,email,senha) values(?,?.?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, game.getNome());
			ps.setString(2, game.getPlataforma());
			ps.setString(3, game.getOnline());
			ps.setString(4, game.getMultiplayer());
			ps.setString(5, game.getState);
			ps.setString(6, game.getId);
			ps.execute();
			ps.close();
			
		} catch (Exception e) {
			throw new RuntimeException("Não conseguiu inserir Usuario", e);
		}
		
		
	}
	
	//Mudar os atributos do rs.get pois o banco não está criado
	public ArrayList<GameBean> listarJogos() {
		String sql = "SELECT * FROM Usuario";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				GameBean user = new GameBean(rs.getString("nome"),rs.getString("plataforma"),rs.getString("online"),rs.getString("multiplayer"),rs.getNString("state"), rs.getNString("id_jogo");
				users.add(user);
			}
 			
			
		} catch (Exception e) {
			throw new RuntimeException("Não conseguiu recuperar usuarios", e);
			
		}
		
		return users;
	}
	
	///Atualizar
	public void atualizarUser(GameBean game) {
		
		String sql = "UPDATE Usuario SET nome = ?, email = ? WHERE id_Usuario = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, game.getNome());
			ps.setString(2, game.getPlataforma());
			ps.setString(3, game.getOnline());
			ps.setString(4, game.getMultiplayer());
			ps.setString(5, game.getState);
			ps.setString(6, game.getId);
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
