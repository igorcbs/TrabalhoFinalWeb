package br.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.BO.GameBO;
import br.com.BO.UserBO;
import br.com.Bean.GameBean;
import br.com.Bean.GameState;
import br.com.Bean.Singleton;
import br.com.Bean.UserBean;
import br.com.DAO.GameDAO;
import br.com.DAO.UserDAO;


@WebServlet("/ControllerReview")
public class ControllerReview extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<UserBean> users = new UserBO().listarUser();
		ArrayList<GameBean> games = new GameBO().listarJogos();
		
		String[] array = new String[3];
		
		for (UserBean user : users) {
			System.out.println("Entrou no for");
			if (user.getId() == Singleton.shared.getUserId()) {
				System.out.println("OPA");				
				user.setJogos(new GameBO().addJogosEmUser(games));
				System.out.println("BLZ");
				System.out.println(user.getId());
				System.out.println(Singleton.shared.getUserId());
				if (user.getJogos().isEmpty()) {
					System.out.println("VIXI");
					req.setAttribute("qttJogos", 0);
				}else {
					System.out.println("OPA NAO Ë NULO");
					req.setAttribute("qttJogos", user.getJogos().size());
					int i = 1;
					for (GameBean gameBean : user.getJogos()) {
						array[i] = gameBean.getNome();
						
						req.setAttribute("nomeJogo"+i, gameBean.getNome());
						req.setAttribute("multiplayerJogo"+i, gameBean.getMultiplayer());
					}
					
				}
			}
			
			req.setAttribute("array", array);
		}
		
		System.out.println(req.getAttribute("qttJogos"));
		req.getRequestDispatcher("/review.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setAttribute("userId", Singleton.shared.getUserId());
		req.setAttribute("userNome", Singleton.shared.getUserName());
		req.getRequestDispatcher("/review.jsp").forward(req, resp);
		
	}
	
}
