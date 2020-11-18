package br.com.BO;

import java.util.ArrayList;

import br.com.Bean.UserBean;
import br.com.DAO.UserDAO;

public class UserBO {
	
	UserDAO userDao = new UserDAO();
	ArrayList<UserBean> users = new ArrayList<UserBean>();
	
	public void insereUser(String nome, String email, String senha, int id) {
		
		UserBean userBean = new UserBean(nome, email, senha, id);
		
		userDao.inserirUser(userBean);
	}
	
	
	public void listarUser() {
		
		users = userDao.listarUser();
		System.out.println(users.toString());
		
	}
	
	public void atualizarUser(String nome, String email, String senha, int id) {
		
		UserBean userBean = new UserBean(nome, email, senha, id);
		
		userDao.atualizarUser(userBean);
		
	}
	
	
}
