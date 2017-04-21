package ar.com.itr.cestointeligente.api;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UsuarioPosicion {
	private String nombre;
	private String apellido;
	private String telefono;
	private String nombreUsuario;
	private String token;
	@JsonIgnore
	private int id;

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				 + ", nombreUsuario=" + nombreUsuario + ", token=" + token + "]";
	}

	// *** Getters and Setters ***//

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

}
