package br.com.Bean;

import java.util.ArrayList;

public class UserBean {
	
	private String nome = "";
	private String email = "";
	private String senha = "";
	private int id = 0;
	private static int nmbID = 0;
	private static boolean searchForId = false;
	private ArrayList<GameBean> jogos = new ArrayList<GameBean>();
	
	public UserBean(String nome,String email, String senha) {
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
		this.setId(nmbID);
		UserBean.nmbID++;
	}

	public UserBean(String nome,String email, String senha, ArrayList<UserBean> users) {
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
		if(users.isEmpty()) {
			this.setId(0);
		}else {
			for (UserBean userBean : users) {
				if(userBean.getId() > this.getId()) {
					this.setId(userBean.getId());
				}
			}
			UserBean.nmbID = this.getId() + 1;
			this.setId(UserBean.nmbID);
		}
		
	}
	
	public UserBean(String nome,String email, String senha,int id) {
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
		this.setId(id);
	}
	

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public static boolean isSearchForId() {
		return searchForId;
	}

	public static void setSearchForId() {
		UserBean.searchForId = true;
	}
	
	
	
	
	
}
