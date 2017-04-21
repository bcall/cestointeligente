package ar.com.itr.cestointeligente.entities;

public class GrupoUsuario {
	private int id;
	private String descripcion;

	public GrupoUsuario() {

	}

	public GrupoUsuario(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "GrupoUsuario [id=" + id + ", descripcion=" + descripcion + "]";
	}

	// *** Getter and Setters ***//

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
