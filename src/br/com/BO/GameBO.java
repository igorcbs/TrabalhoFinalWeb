package br.com.BO;

import java.util.ArrayList;

import br.com.Bean.GameBean;
import br.com.Bean.GameState;
import br.com.DAO.GameDAO;

public class GameBO {

	GameDAO gameDao = new GameDAO();
	ArrayList<GameBean> users = new ArrayList<GameBean>();
	
	public void insereJogo(String nome, String plataforma, boolean online, int multiplayer, GameState state) {
		
		GameBean gameBean = new GameBean(nome,plataforma,online,multiplayer,state);
		
		gameDao.inserirUser(gameBean);
	}
		
	public void listarJogos() {
		
		users = gameDao.listarJogos();
		System.out.println(users);
		
	}
	
	public void atualizarJogo(String nome, String plataforma, boolean online, int multiplayer, GameState state) {
		
		GameBean gameBean = new GameBean(nome, plataforma, online, multiplayer, state);
		
		gameDao.atualizarUser(gameBean);
	}
	
	public void excluirJogo(int id) {
		
		gameDao.excluirPessoa(id);
	}
	
	public static void main(String[] args) {
		GameBO gameBO = new GameBO();
//		gameBO.insereJogo("batata", "Banana", true, 3, GameState.desejado);
		gameBO.listarJogos();
	}
	
}
