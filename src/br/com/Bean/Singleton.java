package br.com.Bean;

public class Singleton {
	
	public static Singleton shared = new Singleton();
	
	
	private static int userId = 0;
	private static String userName = "";
	
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
	
	
}
