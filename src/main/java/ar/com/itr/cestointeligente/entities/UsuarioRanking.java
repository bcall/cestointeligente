package ar.com.itr.cestointeligente.entities;

public class UsuarioRanking {
	private int id;
	private String nombre;
	private String apellido;
	private String nombreUsuario;
    private int puntos;
    
	public UsuarioRanking() {

	}

	public UsuarioRanking(int id, String password, String nombre, String apellido, String telefono,
			int grupoUsuario, String nombreUsuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", usuario=" + nombreUsuario + ", puntos="+puntos+"]";
	}

	// *** Getters and Setters ***//

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int posicion) {
		this.puntos = posicion;
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

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}
