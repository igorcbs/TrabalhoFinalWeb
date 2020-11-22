package br.com.BO;

import java.util.ArrayList;

import br.com.Bean.*;
import br.com.DAO.UserDAO;

public class UserBO {
	
	UserDAO userDao = new UserDAO();
	ArrayList<UserBean> users = new ArrayList<UserBean>();
	
	public void insereUser(String nome, String email, String senha) {
		UserBean userBean;
		
		if(!UserBean.isSearchForId()) {
			userBean = new UserBean(nome, email, senha,listarUser());
			UserBean.setSearchForId();
		}else {
			userBean = new UserBean(nome, email, senha);
		}
		userDao.inserirUser(userBean);
		
	}
	
	
	public ArrayList<UserBean> listarUser() {
		
		
		return users = userDao.listarUser();

//		System.out.println(users.toString());

	}
	
	public void atualizarUser(String nome, String email, String senha) {
		
		UserBean userBean = new UserBean(nome, email, senha);
		
		userDao.atualizarUser(userBean);
		
	}

	
}
