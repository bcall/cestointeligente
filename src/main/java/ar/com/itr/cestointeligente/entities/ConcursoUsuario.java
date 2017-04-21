package ar.com.itr.cestointeligente.entities;

public class ConcursoUsuario {
	private int id;
	private int usuarioId;
	private int puntosAcumulados;
	private int posicionFinal;
	private int concursoId;

	@Override
	public String toString() {
		return "ConcursoUsuario [id=" + id + ", usuarioId=" + usuarioId + ", puntosAcumulados=" + puntosAcumulados
				+ ", posicionFinal=" + posicionFinal + ", concursoId=" + concursoId + "]";
	}

	// *** Getters and Setters ***//

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public int getPuntosAcumulados() {
		return puntosAcumulados;
	}

	public void setPuntosAcumulados(int puntosAcumulados) {
		this.puntosAcumulados = puntosAcumulados;
	}

	public int getPosicionFinal() {
		return posicionFinal;
	}

	public void setPosicionFinal(int posicionFinal) {
		this.posicionFinal = posicionFinal;
	}

	public int getConcursoId() {
		return concursoId;
	}

	public void setConcursoId(int concursoId) {
		this.concursoId = concursoId;
	}
}
