package br.com.BO;

import br.com.Bean.GameBean;
import br.com.Bean.GameState;
import br.com.DAO.GameDAO;

public class GameBO {

		public void insereUser(String nome, String plataforma, boolean online, int multiplayer, GameState state) {
			
			GameBean gameBean = new GameBean(nome, plataforma, online, multiplayer, state);
			GameDAO gameDao = new GameDAO();
			gameDao.inserirUser(gameBean);
		}
		

}
