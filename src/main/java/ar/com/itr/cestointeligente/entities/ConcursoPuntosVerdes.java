package ar.com.itr.cestointeligente.entities;

public class ConcursoPuntosVerdes {
	private int id;
	private int concursoId;
	private int puntos;	
	
	@Override
	public String toString() {
		return "ConcursoPuntosVerdes [id=" + id + ", concursoId=" + concursoId + ", puntos=" + puntos + "]";
	}
	
	//*** Getters and Setters ***//
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getConcursoId() {
		return concursoId;
	}
	public void setConcursoId(int concursoId) {
		this.concursoId = concursoId;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

}
