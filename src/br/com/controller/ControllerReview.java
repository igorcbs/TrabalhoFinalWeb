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
		
//		String[] array = new String[3];
		
		for (UserBean user : users) {
			
			if (user.getId() == Singleton.shared.getUserId()) {
					
				user.setJogos(new GameBO().addJogosEmUser(games));
			
				if (user.getJogos().isEmpty()) {
				
					req.setAttribute("qttJogos", 0);
				}else {
				
					req.setAttribute("qttJogos", user.getJogos().size());

					int i = 0;
					for (GameBean gameBean : user.getJogos()) {
//						array[i] = gameBean.getNome();
						
						req.setAttribute("nomeJogo"+i, gameBean.getNome());
						req.setAttribute("multiplayerJogo"+i, gameBean.getMultiplayer());
						
						req.setAttribute("idGame"+i, gameBean.getId());
						
						Singleton.shared.setGameIds(gameBean.getId());
						System.out.println("Id:" + gameBean.getId());
						i++;
					}
					
//					req.setAttribute("nomeJogos", array);
				}
			}
			
		}
		
		req.getRequestDispatcher("/review.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		int id = Integer.parseInt(req.getParameter("idGame")) ;
		
//		req.setAttribute("idGame", req.getParameter("idGame"));
		String nome = req.getParameter("nomeJogo");
		
		req.setAttribute("nomeJogo", req.getParameter("nomeJogo"));
		req.setAttribute("multiplayerJogo", req.getParameter("multiplayerJogo"));
		req.setAttribute("userId", Singleton.shared.getUserId());
		req.setAttribute("userNome", Singleton.shared.getUserName());
		
		ControllerEditGame controller = new ControllerEditGame();
		
		controller.doGet(req, resp);
		
		req.getRequestDispatcher("/contactShow.jsp").forward(req, resp);
		
	}
	
}
