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
		req.getRequestDispatcher("/contactShow.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		
		GameDAO gamedao = new GameDAO();
		GameState estados[] = GameState.values();
		ArrayList<GameBean> games = gamedao.listarJogos();;
		
		String nome =  req.getParameter("nome");
		String plataforma = req.getParameter("plataforma");
		int numJogadores = Integer.parseInt(req.getParameter("num")) ;
		String estado = req.getParameter("estado");
		String strOnline = req.getParameter("online");
		int idJogo = (int) req.getAttribute("idGame");
		boolean eOnline = true;
		//Falta id do user
		
		
		if(strOnline == null) {
			eOnline = false;
		}

		if((req.getParameter("edit") != null) == true ) {
			for (GameBean gameBean : games) {
				if(gameBean.getIdUser() == Singleton.shared.getUserId()) {
					if(gameBean.getId() == idJogo) {
						gameBean.setNome(nome);
						gameBean.setPlataforma(plataforma);
						gameBean.setMultiplayer(numJogadores);
						gameBean.setOnline(eOnline);
						gameBean.setState(GameState.valueOf(estado));
						gamedao.atualizarUser(gameBean);
						break;
					}
					
				}
			}
			
			
		}else if(((req.getParameter("delete") != null) == true)) {
			gamedao.excluirJogo(idJogo);
			
		}
		
		req.setAttribute("userId", Singleton.shared.getUserId());
		req.setAttribute("userNome", Singleton.shared.getUserName());
		req.getRequestDispatcher("/review.jsp").forward(req, resp);
	}
	
}
