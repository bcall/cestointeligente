package ar.com.itr.cestointeligente.api;

import java.io.Serializable;

public class LogoutRequest implements Serializable {
	private static final long serialVersionUID = -7893480787118029308L;
	
	private String token;
	
	@Override
	public String toString() {
		return "LogoutRequest [token=" + token + "]";
	}

	//*** Getters and Setters	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}	

}
