package br.com.BO;

import br.com.Bean.UserBean;
import br.com.DAO.UserDAO;

public class UserBO {

	public void insereUser(String nome, String email, String senha) {
		
		UserBean userBean = new UserBean(nome, email, senha);
		UserDAO userDao = new UserDAO();
		userDao.inserirUser(userBean);
	}
	
	
}
