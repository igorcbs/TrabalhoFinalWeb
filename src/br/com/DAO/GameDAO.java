package br.com.DAO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;

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
		
		String sql = "INSERT INTO db.Jogos (idJogos,nome,plataforma,multiplayer,online,estado,imagem,idUser) values(?,?,?,?,?,?,?,?)";
		
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(game.getImage(), "png", baos);
			InputStream is = new ByteArrayInputStream(baos.toByteArray());
			ps = conn.prepareStatement(sql);
			ps.setInt(1, game.getId());
			ps.setString(2, game.getNome());
			ps.setString(3, game.getPlataforma());
			ps.setInt(4, game.getMultiplayer());
			ps.setInt(5, game.isOnline());
			ps.setString(6, game.getState());
			ps.setBlob(7, is);
			ps.setInt(8, game.getIdUser());
			ps.execute();
			ps.close();
			System.out.println("INSERIUUUUUUUUU PORRAAA");
		} catch (Exception e) {
			throw new RuntimeException("Não conseguiu inserir o jogo", e);
		}
		
		
	}
	
	//Mudar os atributos do rs.get pois o banco não está criado
	public ArrayList<GameBean> listarJogos() {
		String sql = "SELECT * FROM db.Jogos";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			boolean on = false;
			while(rs.next()) {
				if (rs.getInt("online") == 1) {
					on = true;
				}
				
				java.sql.Blob blob = rs.getBlob("imagem");
				InputStream in = blob.getBinaryStream();
				BufferedImage image = ImageIO.read(in);
				
				GameState estadoAtual = GameState.valueOf(rs.getString("estado"));
				System.out.println(estadoAtual);
				GameBean user = new GameBean(rs.getString("nome"),rs.getString("plataforma"),on,rs.getInt("multiplayer"),estadoAtual,rs.getInt("idUser"),rs.getInt("idJogos"));
				users.add(user);
			}
 			
			
		} catch (Exception e) {
			throw new RuntimeException("Não conseguiu recuperar usuarios", e);
			
		}
		
		return users;
	}
	
	///Atualizar
	public void atualizarUser(GameBean game) {
		
		String sql = "UPDATE db.Jogos SET nome = ?, plataforma = ?,  multiplayer = ?, online = ?, estado = ? WHERE idJogos = " + game.getId();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, game.getNome());
			ps.setString(2, game.getPlataforma());
			ps.setInt(3, game.isOnline());
			ps.setInt(4, game.getMultiplayer());
			ps.setString(5, game.getState());
			ps.execute();
			ps.close();
			
		} catch (Exception e) {
			throw new RuntimeException("Não conseguiu atualizar o jogo", e);
		}
		
	}
	
	//Excluir
	public void excluirJogo(int idJogo) {
		
		String sql = "DELETE FROM db.Jogos WHERE idJogos = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idJogo);
			ps.execute();
			ps.close();
			System.out.println("EXCLUIUUU PORRAAA");
		} catch (Exception e) {
			throw new RuntimeException("Não conseguiu excluir o jogo", e);
		}
		
	}
	
}
