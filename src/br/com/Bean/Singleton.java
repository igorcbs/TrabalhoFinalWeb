package br.com.Bean;

import java.util.ArrayList;

public class Singleton {
	
	public static Singleton shared = new Singleton();
	
	
	private static int userId = 0;
	private static String userName = "";
	private static int gameId = 0;
	private static ArrayList<Integer> gameIds = new ArrayList<Integer>();
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		Singleton.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		Singleton.userName = userName;
	}
	public  Singleton getShared() {
		return shared;
	}
	public  void setShared(Singleton shared) {
		Singleton.shared = shared;
	}
	public  int getGameId() {
		return gameId;
	}
	public  void setGameId(int gameId) {
		Singleton.gameId = gameId;
	}
	public  ArrayList<Integer> getGameIds() {
		return gameIds;
	}
	public  void setGameIds(Integer gameIds) {
		Singleton.gameIds.add(gameIds); 
	}
	

}
