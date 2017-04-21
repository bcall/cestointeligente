package ar.com.itr.cestointeligente.entities;

public class Usuario {
	private int id;
	private String password;
	private String nombre;
	private String apellido;
	private String telefono;
	private int grupoUsuarioID;
	private String nombreUsuario;
	private String email;

	public Usuario() {

	}

	public Usuario(int id, String password, String nombre, String apellido, String telefono,
			int grupoUsuario, String nombreUsuario, String email) {
		super();
		this.id = id;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.grupoUsuarioID = grupoUsuario;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", password=" + password + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", telefono=" + telefono + ", grupoUsuario=" + grupoUsuarioID + ", usuario=" + nombreUsuario + ", email=" + email + "]";
	}

	// *** Getters and Setters ***//

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public int getGrupoUsuarioId() {
		return grupoUsuarioID;
	}

	public void setGrupoUsuarioId(int grupoUsuarioId) {
		this.grupoUsuarioID = grupoUsuarioId;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
