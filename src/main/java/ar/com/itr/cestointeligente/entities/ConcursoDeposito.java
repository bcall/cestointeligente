package ar.com.itr.cestointeligente.entities;

import java.util.Date;

public class ConcursoDeposito {
	private int id;
	private int concursoId;
	private int usuarioId;
	private Date fecha;
	private int islaId;
	private int tipoResiduoId;
	private double peso;
	private int puntos;

	@Override
	public String toString() {
		return "ConcursoDesposito [id=" + id + ", concursoId=" + concursoId + ", usuarioId=" + usuarioId + ", fecha="
				+ fecha + ", islaId=" + islaId + ", tipoResiduoId=" + tipoResiduoId + ", peso=" + peso + ", puntos="
				+ puntos + "]";
	}

	// *** Getters and Setters ***//

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

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIslaId() {
		return islaId;
	}

	public void setIslaId(int islaId) {
		this.islaId = islaId;
	}

	public int getTipoResiduoId() {
		return tipoResiduoId;
	}

	public void setTipoResiduoId(int tipoResiduoId) {
		this.tipoResiduoId = tipoResiduoId;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}
