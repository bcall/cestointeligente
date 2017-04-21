package ar.com.itr.cestointeligente.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioRanking implements Serializable {

	private static final long serialVersionUID = 5852019396385892718L;

	private int puesto;
	@JsonProperty(value = "total_participantes")
	private int totalParticipantes;
	@JsonProperty(value = "total_puntos")
	private int totalPuntos;
	@JsonProperty(value = "ultimos_depositos")
	private List<DepositoUsuario> ultimosDespositos;
	private String token;

	@Override
	public String toString() {
		return "UsuarioRanking [puesto=" + puesto + ", totalParticipantes=" + totalParticipantes + ", totalPuntos="
				+ totalPuntos + ", ultimosDespositos=" + ultimosDespositos.toString() + "]";
	}

	public UsuarioRanking add(List<DepositoUsuario> depositos) {
		this.getUltimosDespositos().addAll(depositos);
		return this;
	}

	// *** Getters and Setters ***//

	public int getPuesto() {
		return puesto;
	}

	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}

	public int getTotalParticipantes() {
		return totalParticipantes;
	}

	public void setTotalParticipantes(int totalParticipantes) {
		this.totalParticipantes = totalParticipantes;
	}

	public int getTotalPuntos() {
		return totalPuntos;
	}

	public void setTotalPuntos(int totalPuntos) {
		this.totalPuntos = totalPuntos;
	}

	public List<DepositoUsuario> getUltimosDespositos() {
		if (this.ultimosDespositos == null) {
			this.ultimosDespositos = new ArrayList<DepositoUsuario>();
		}
		return ultimosDespositos;
	}

	public void setUltimosDespositos(List<DepositoUsuario> ultimosDespositos) {
		this.ultimosDespositos = ultimosDespositos;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
