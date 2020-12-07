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

	public UserDAO() {

		conn = new ConnectionFactory().getConnection();
	}

	// Inserir
	public void inserirUser(UserBean user) {

		String sql = "INSERT INTO db.Usuario (idUsuario,nome,email,senha) values(?,?,?,?)";

		try {

			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getNome());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getSenha());

			ps.execute();
			ps.close();

		} catch (Exception e) {
			throw new RuntimeException("Não conseguiu inserir Usuario", e);
		}

	}

	// Mudar os atributos do rs.get pois o banco não está criado
	public ArrayList<UserBean> listarUser() {
		String sql = "SELECT * FROM db.Usuario";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				UserBean user = new UserBean(rs.getString("nome"), rs.getString("email"), rs.getString("senha"),
						rs.getInt("idUsuario"));
				users.add(user);
			}

		} catch (Exception e) {
			throw new RuntimeException("Não conseguiu recuperar usuarios", e);

		}

		return users;
	}

	/// Atualizar
	public void atualizarUser(UserBean user) {

		String sql = "UPDATE db.Usuario SET nome = ?, email = ? WHERE idUsuario = " + user.getId();

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getNome());
			ps.setString(2, user.getEmail());
			ps.execute();
			ps.close();

		} catch (Exception e) {
			throw new RuntimeException("Não conseguiu atualizar o usuario", e);
		}

	}

	// Excluir
	public boolean excluirPessoa(int idUser) {

		String sql = "DELETE FROM db.Usuario WHERE idUsuario = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUser);
			ps.execute();
			ps.close();

			return true;
		} catch (Exception e) {
			throw new RuntimeException("Não conseguiu excluir o usuario", e);
		}

	}

}
