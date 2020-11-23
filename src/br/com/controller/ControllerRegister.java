package br.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.BO.UserBO;
import br.com.Bean.UserBean;

@WebServlet("/ControllerRegister")
public class ControllerRegister extends HttpServlet {

	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBO user = new UserBO();
		ArrayList<UserBean> users;
		boolean entrou = true;
		String email =  req.getParameter("email");
		String password = req.getParameter("senha");
		String nome = req.getParameter("nome");

		PrintWriter out = resp.getWriter();
		
		users = user.listarUser();
		
		if(users.isEmpty()) {
			user.insereUser(nome, email, password);
			
			req.getRequestDispatcher("/index.htm").forward(req, resp);
		}else {
			for(UserBean people: users) {
				if((email.contains(people.getEmail())) && (password.contains(people.getSenha()))) {
					System.out.println("Usuário já registrado");
					entrou = false;
					
				} 
			}
			
			if(entrou) {
				user.insereUser(nome, email, password);
				
				req.getRequestDispatcher("/index.htm").forward(req, resp);
			}else {
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
				out.print("Usuário já cadastrado! Realize o login ali em cima!");
				out.close();
			}
			
		}
		
		
		
	}
	
}
