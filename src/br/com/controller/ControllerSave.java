package br.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.Bean.GameBean;
import br.com.Bean.GameState;
import br.com.DAO.GameDAO;

@WebServlet("/ControllerSave")
public class ControllerSave extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		GameDAO gamedao = new GameDAO();
		GameState estados[] = GameState.values();
		ArrayList<GameBean> games;
		
		String nome =  req.getParameter("nome");
		String plataforma = req.getParameter("plataforma");
		int numJogadores = Integer.parseInt(req.getParameter("num")) ;
		String estado = req.getParameter("estado");
		String strOnline = req.getParameter("online");
		boolean eOnline = true;
		boolean vazio = false;
		
		//Falta id do user
		
		
		if(strOnline == null) {
			eOnline = false;
		}
		
		games = gamedao.listarJogos();
		
		if(games.isEmpty()) {
			vazio = true;
		}else {
			for (GameBean gameBean : games) {
				if(games.get(games.size() - 1) == gameBean) {
					for(GameState state: estados) {		
						if(state.name().contains(estado)) {
							if(vazio) {
								gamedao.inserirUser(new GameBean(nome,plataforma,eOnline,numJogadores,state,0));
							}else {
								gamedao.inserirUser(new GameBean(nome,plataforma,eOnline,numJogadores,state,0));
							}
						}
					}
				}
			}
		}
		
//		gamedao.inserirUser(new GameBean("Cyberpunk 2077", "Playstation 5", false, 1, GameState.desejado,0));
//		gamedao.inserirUser(new GameBean("Anthem", "Playstation 4", true, 1, GameState.desejado,0));
		
//		System.out.println(gamedao.listarJogos());
		
	}
	
}
