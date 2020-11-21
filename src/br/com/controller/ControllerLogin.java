package br.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		System.out.println("Entrou no doPost");
		users = user.listarUser();
		
		if(users.isEmpty()) {
			req.setAttribute("email", "alibaba");
			String email =  req.getParameter("email");
			String password = req.getParameter("senha");
			String nome = req.getParameter("nome");
			
			user.insereUser(nome, email, password, 0);
			
			req.getRequestDispatcher("/index.html").forward(req, resp);
		}else {
			System.out.println("Não é nulo");
			for(UserBean people: users) {
				
				String email = (String) req.getAttribute("email");
				String password = (String) req.getAttribute("senha");
				if(email == people.getEmail() && password == people.getSenha()) {
					req.setAttribute("nome", people.getNome());
					req.setAttribute("id", people.getId());
				}
			}
		}
		
		
		
	}
	
}
