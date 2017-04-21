package ar.com.itr.cestointeligente.entities.view;

public class MessageView {
	int mensajeId;
	int composteraId;
	String fecha;
	Double peso;
	String evento;
	
	public MessageView(int mensajeId, int composteraId, String fecha,
			Double peso, String evento) {
		super();
		this.mensajeId = mensajeId;
		this.composteraId = composteraId;
		this.fecha = fecha;
		this.peso = peso;
		this.evento = evento;
	}

	public MessageView() {
	}

	public int getmensajeId() {
		return mensajeId;
	}

	public void setmensajeId(int mensajeId) {
		this.mensajeId = mensajeId;
	}

	public int getcomposteraId() {
		return composteraId;
	}

	public void setcomposteraId(int composteraId) {
		this.composteraId = composteraId;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}
}
