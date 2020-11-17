package br.com.Bean;

public class GameBean {
	
	private String nome;
	private String plataforma;
	private boolean online;
	private int multiplayer;
	private GameState state;
	private int id;
	private static int nmbID = 0;
	//Foto
	
	//Initializer
	public GameBean(String nome, String plataforma, boolean online, int multiplayer, GameState state) {
		
		setMultiplayer(multiplayer);
		setNome(nome);
		setOnline(online);
		setPlataforma(plataforma);
		setState(state);
		this.id = nmbID;
		nmbID ++;
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
		if(multiplayer > 0 && multiplayer < 5)
			this.multiplayer = multiplayer;
		else
			throw new IllegalArgumentException();
	}

	public GameState getState() {
		return state;
	}

	public void setState(GameState state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}
	

}
