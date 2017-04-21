package ar.com.itr.cestointeligente.api;

import java.io.Serializable;
import java.util.Date;

public class DepositoUsuario implements Serializable {
	private static final long serialVersionUID = 8810428360304186753L;

	private Date fecha;
	private String lugar;
	private int puntos;	

	@Override
	public String toString() {
		return "DepositoUsuario [fecha=" + fecha + ", lugar=" + lugar + ", puntos=" + puntos + "]";
	}

	// *** Getters and Setters ***//
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

}
