package br.com.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.BO.UserBO;
import br.com.Bean.Singleton;
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
		
		
		if(users.isEmpty()) {
			System.out.println("Não há registro! Cadastre-se");
			req.getRequestDispatcher("/index.htm").forward(req, resp);
		}else {
			System.out.println("Não é nulo");
			for(UserBean people: users) {
				if((email.contains(people.getEmail())) && (password.contains(people.getSenha()))) {
					System.out.println("Usuário já registrado");
					logou = true;
					
					userRecover = people;
					Singleton.shared.setUserId(userRecover.getId());
					Singleton.shared.setUserName(userRecover.getNome());
					
				} 
			}

			if(logou) {
				System.out.println(userRecover.getId());
				
				req.setAttribute("userId", userRecover.getId());
				req.setAttribute("userNome", userRecover.getNome());
				
				ControllerIndex controller = new ControllerIndex();
				
				controller.doGet(req, resp);
			
			}else {
				System.out.println("Não logou");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
			
			
			
		}
		
	}
	
	
	
}
