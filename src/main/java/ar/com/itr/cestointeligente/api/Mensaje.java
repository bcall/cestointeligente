package ar.com.itr.cestointeligente.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mensaje {
	@JsonProperty(value="compostera_id")
	private int composteraId;
	@JsonProperty(value="pesoDepositado")
	private double peso;
	private int evento;
	@JsonProperty(value="concurso_id")
	private int concursoId = 1;
	@JsonProperty(value="usuario_id")
	private int usuarioId;

	// *** Getters and Setters ***//

	public int getUsuarioId() {
		return usuarioId;
	}	
	public int getComposteraId() {
		return composteraId;
	}
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getEvento() {
		return evento;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}

	public int getConcursoId() {
		return concursoId;
	}

	public void setConcursoId(int concursoId) {
		this.concursoId = concursoId;
	}

	public void setComposteraId(int composteraId) {
		this.composteraId = composteraId;
	}

}
