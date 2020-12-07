package br.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.Bean.Singleton;

@WebServlet("/ControllerIndex")
public class ControllerIndex extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setAttribute("userId", Singleton.shared.getUserId());
		
		req.setAttribute("userNome", Singleton.shared.getUserName());
		
		
		
		ControllerReview controller = new ControllerReview();
		
		controller.doGet(req, resp);
		
		req.getRequestDispatcher("/review.jsp").forward(req, resp);
	
	}

	
	
	
	
}
