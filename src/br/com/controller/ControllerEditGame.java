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
import br.com.Bean.Singleton;
import br.com.DAO.GameDAO;

@WebServlet("/ControllerEditGame")
public class ControllerEditGame extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		
		
		
		req.getRequestDispatcher("contactShow.jsp").forward(req, resp);
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		
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
//		int id = Integer.parseInt(req.getParameter("idUser"));
		//Falta id do user
		
		
		if(strOnline == null) {
			eOnline = false;
		}
		
		games = gamedao.listarJogos();
		
		if((req.getParameter("edit") != null) == true ) {
			
			
			
			
		}else if(((req.getParameter("delete") != null) == true)) {
			System.out.println("remoeeemrelkldk");
		}
		
		req.setAttribute("userId", Singleton.shared.getUserId());
		req.setAttribute("userNome", Singleton.shared.getUserName());
		req.getRequestDispatcher("/review.jsp").forward(req, resp);
	}
	
}
