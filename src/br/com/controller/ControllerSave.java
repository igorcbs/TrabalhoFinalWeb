package br.com.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
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
//		String image =req.getParameter("myimg");
		
//		FileInputStream fis =null;
//		
//		File image = new File(myloc);
//		fis = new FileInputStream(image);
//		
//		BufferedImage image = new Buffer
		
		boolean eOnline = true;
		
		if(strOnline == null) {
			eOnline = false;
		}
		
		games = gamedao.listarJogos();
		
		if(games.isEmpty()) {
			gamedao.inserirUser(new GameBean(nome,plataforma,eOnline,numJogadores,GameState.valueOf(estado),Singleton.shared.getUserId(),0));
		}else {
			for (GameBean gameBean : games) {
				if(games.get(games.size() - 1) == gameBean) {
					for(GameState state: estados) {		
						if(state.name().contains(estado)) {
							gamedao.inserirUser(new GameBean(nome,plataforma,eOnline,numJogadores,state,Singleton.shared.getUserId(),games.size()));
							
						}
					}
				}
			}
		}
		
		req.setAttribute("userId", Singleton.shared.getUserId());
		req.setAttribute("userNome", Singleton.shared.getUserName());
		
		ControllerReview controller = new ControllerReview();
		
		controller.doGet(req, resp);
		
		req.getRequestDispatcher("/review.jsp").forward(req, resp);
		
		
	}
	
}
