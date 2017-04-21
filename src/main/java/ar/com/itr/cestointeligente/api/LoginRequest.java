package ar.com.itr.cestointeligente.api;

import java.io.Serializable;

public class LoginRequest implements Serializable {
	private static final long serialVersionUID = 7567897913886562397L;
	private String username;
	private String password;

	@Override
	public String toString() {
		return "LoginRequest [username=" + username + ", password=" + password + "]";
	}

	// *** Getters and Setters ***//
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
