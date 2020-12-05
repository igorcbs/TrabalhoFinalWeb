package br.com.BO;

import java.util.ArrayList;

import br.com.Bean.GameBean;
import br.com.Bean.GameState;
import br.com.Bean.Singleton;
import br.com.Bean.UserBean;
import br.com.DAO.GameDAO;
import br.com.DAO.UserDAO;

public class GameBO {

	GameDAO gameDao = new GameDAO();
	ArrayList<GameBean> users = new ArrayList<GameBean>();
	
	public void insereJogo(String nome, String plataforma, boolean online, int multiplayer, GameState state,int id) {
		
		GameBean gameBean = new GameBean(nome,plataforma,online,multiplayer,state,id);
		
		gameDao.inserirUser(gameBean);
	}
		
	public ArrayList<GameBean> listarJogos() {
		
		users = gameDao.listarJogos();
		System.out.println(users);
		
		return users;
		
	}
	
	public void atualizarJogo(String nome, String plataforma, boolean online, int multiplayer, GameState state, int id) {
		
		GameBean gameBean = new GameBean(nome, plataforma, online, multiplayer, state, id);
		
		gameDao.atualizarUser(gameBean);
	}
	
	public void excluirJogo(int id) {
		
		gameDao.excluirJogo(id);
	}
	
	
	public ArrayList<GameBean> addJogosEmUser(ArrayList<GameBean> games) {
		
		games = gameDao.listarJogos();
		ArrayList<GameBean> gamesUser = new ArrayList<GameBean>();
		
		
		for (GameBean gameBean : games) {
			if(gameBean.getIdUser() == Singleton.shared.getUserId()) {
				System.out.println(Singleton.shared.getUserId());
				gamesUser.add(gameBean);
			}
		}
		
		return gamesUser;
		
	}
	
	public static void main(String[] args) {
		GameBO gameBO = new GameBO();
//		gameBO.insereJogo("batata", "Banana", true, 3, GameState.desejado);
		gameBO.listarJogos();
	}
}
