package br.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.Bean.GameBean;
import br.com.Bean.GameState;
import br.com.DAO.GameDAO;


@WebServlet("/ControllerReview")
public class ControllerReview extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GameDAO gamedao = new GameDAO();
		gamedao.inserirUser(new GameBean("Cyberpunk 2077", "Playstation 5", false, 1, GameState.desejado));
		gamedao.inserirUser(new GameBean("Anthem", "Playstation 4", true, 1, GameState.desejado));
		System.out.println(gamedao.listarJogos());
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}
	
}
