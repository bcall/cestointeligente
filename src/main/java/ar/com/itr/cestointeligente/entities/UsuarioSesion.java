package ar.com.itr.cestointeligente.entities;

import java.util.Date;

public class UsuarioSesion {
	private int id;
	private String nombreUsuario;
	private String token;
	private EstadoSesion estado;
	private Date inicio;
	private int usuarioId;

	public UsuarioSesion() {

	}

	public UsuarioSesion(int id, String usuario, String token, EstadoSesion estado, Date inicio, int usuarioId) {
		super();
		this.id = id;
		this.nombreUsuario = usuario;
		this.token = token;
		this.estado = estado;
		this.inicio = inicio;
		this.usuarioId = usuarioId;
	}

	@Override
	public String toString() {
		return "UsuarioSesiones [id=" + id + ", usuario=" + nombreUsuario + ", token=" + token + ", estado=" + estado
				+ ", inicio=" + inicio + "]";
	}

	// *** Getters and Setters ***//

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String usuario) {
		this.nombreUsuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public EstadoSesion getEstado() {
		return estado;
	}

	public void setEstado(EstadoSesion estado) {
		this.estado = estado;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}	

}
