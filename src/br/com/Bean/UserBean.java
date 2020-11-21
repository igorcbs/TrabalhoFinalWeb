package br.com.Bean;

public class UserBean {
	
	private String nome = "";
	private String email = "";
	private String senha = "";
	private int id = 0;
	private static int nmbID = 0;
	
	public UserBean(String nome,String email, String senha, int id) {
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
		if(getId() == 0) {
			this.setId(id);
		}else {
			this.setId(nmbID + 1);
		}
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
	
	
}
