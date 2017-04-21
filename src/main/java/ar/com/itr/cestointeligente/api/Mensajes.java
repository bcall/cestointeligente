package ar.com.itr.cestointeligente.api;

import static java.util.Collections.emptyList;

import java.util.List;

public class Mensajes {	
	private int usuarioId;
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	private String token;
    private List<Mensaje> messages = emptyList();
    
    //*** Getters and Setters ***//
    
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public List<Mensaje> getMessages() {
		return messages;
	}
	public void setMessages(List<Mensaje> messages) {
		this.messages = messages;
	}	
}
