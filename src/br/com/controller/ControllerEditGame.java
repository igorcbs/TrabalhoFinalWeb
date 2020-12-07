package br.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
		
		GameDAO gamedao = new GameDAO();
		ArrayList<GameBean> games = gamedao.listarJogos();
		String nomeJogo = (String) req.getAttribute("nomeJogo");
		
		for (GameBean gameBean : games) {
			if(nomeJogo.contains(gameBean.getNome())) {
				for(Integer id: Singleton.shared.getGameIds()) {
					if(id == gameBean.getId()) {
						Singleton.shared.setGameId(id);
					}
				}
			}
		}

//		req.getRequestDispatcher("/contactShow.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		
		GameDAO gamedao = new GameDAO();
		int idJogo = Singleton.shared.getGameId();

		if((req.getParameter("edit") != null) == true ) {
			
			ArrayList<GameBean> games = gamedao.listarJogos();
			
			String nome =  req.getParameter("nomeJogo");
			String plataforma = req.getParameter("plataforma");
			int numJogadores = Integer.parseInt(req.getParameter("num"));
			String estado = req.getParameter("estado");
			String strOnline = req.getParameter("on");
			
			boolean eOnline = true;
			
			if(strOnline == null) {
				eOnline = false;
			}
			
			
			for (GameBean gameBean : games) {
				if(gameBean.getId() == Singleton.shared.getGameId()) {
					gameBean.setNome(nome);
					gameBean.setPlataforma(plataforma);
					gameBean.setMultiplayer(numJogadores);
					gameBean.setOnline(eOnline);
					gameBean.setState(GameState.valueOf(estado));
					gamedao.atualizarUser(gameBean);
					break;
				}
			}
			
			
		}else if(((req.getParameter("delete") != null) == true)) {
			gamedao.excluirJogo(idJogo);
			
		}
		

		req.setAttribute("userId", Singleton.shared.getUserId());
		req.setAttribute("userNome", Singleton.shared.getUserName());
		
		ControllerReview controller = new ControllerReview();
		controller.doGet(req, resp);
		
		if (!resp.isCommitted()){
			   RequestDispatcher dispatcher = req.getRequestDispatcher("/review.jsp"); 
			   dispatcher.forward(req, resp); 
		}
		
//		req.getRequestDispatcher("/review.jsp").forward(req, resp);
		
	}
	
}
