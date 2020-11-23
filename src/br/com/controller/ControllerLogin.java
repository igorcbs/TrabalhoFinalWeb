package br.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.BO.UserBO;
import br.com.Bean.UserBean;

@WebServlet("/ControllerLogin")
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBO user = new UserBO();
		ArrayList<UserBean> users;
		boolean logou = false;
		String email =  req.getParameter("email");
		String password = req.getParameter("senha");
		UserBean userRecover = null;
	
		users = user.listarUser();
		
		HttpSession session = req.getSession(true);
		
		if(users.isEmpty()) {
			System.out.println("Não há registro! Cadastre-se");
			req.getRequestDispatcher("/index.htm").forward(req, resp);
		}else {
			System.out.println("Não é nulo");
			for(UserBean people: users) {
				if((email.contains(people.getEmail())) && (password.contains(people.getSenha()))) {
					System.out.println("Usuário já registrado");
					logou = true;
					session.setAttribute("email", email);
					session.setAttribute("senha", password);
					session.setAttribute("nome", people.getNome());
					session.setAttribute("id", people.getId());
					userRecover = new UserBean(people.getNome(),people.getEmail(),people.getSenha(),people.getId());
				} 
			}

			if(logou) {
				System.out.println("logou");
				req.setAttribute("userId", userRecover.getId());
				req.setAttribute("userNome", userRecover.getNome());
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
				
			}else {
				System.out.println("Não logou");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
			
		}
		
	}
	
	
	
}
