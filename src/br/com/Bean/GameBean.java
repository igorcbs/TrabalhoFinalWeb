package br.com.Bean;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;

public class GameBean {
	
	private String nome;
	private String plataforma;
	private boolean online;
	private int multiplayer;
	private GameState state;
	private int id;
	private static int nmbID = 0;
	private BufferedImage image;
	private int idUser = 0;
	//Foto
	
	//Initializer
	public GameBean(String nome, String plataforma, boolean online, int multiplayer, GameState state, int idUser) {
		
		setMultiplayer(multiplayer);
		setNome(nome);
		setOnline(online);
		setPlataforma(plataforma);
		setState(state);
		setImage(new BufferedImage(80, 40, ColorSpace.TYPE_RGB));
		this.id = nmbID;
		nmbID ++;
		this.setIdUser(idUser);
	}
	
	public GameBean(String nome, String plataforma, boolean online, int multiplayer, GameState state, int idUser, int idGame) {
		setMultiplayer(multiplayer);
		setNome(nome);
		setOnline(online);
		setPlataforma(plataforma);
		setImage(new BufferedImage(80, 40, ColorSpace.TYPE_RGB));
		setState(state);
		this.id = idGame;
		setIdUser(idUser);
	}
	
	//Methods
	
	//Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(!nome.isEmpty() && !nome.isBlank())
			this.nome = nome;
		else
			throw new IllegalArgumentException();
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		if(!plataforma.isEmpty() && !plataforma.isBlank())
			this.plataforma = plataforma;
		else
			throw new IllegalArgumentException();
	}

	public int isOnline() {
		if(online)
			return 1;
		else 
			return 0;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public int getMultiplayer() {
		return multiplayer;
	}

	public void setMultiplayer(int multiplayer) {
		if(multiplayer > 0 && multiplayer < 9)
			this.multiplayer = multiplayer;
		else
			throw new IllegalArgumentException();
	}

	public String getState() {
		return state.toString();
	}

	public void setState(GameState state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

}
