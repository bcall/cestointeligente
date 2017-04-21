package ar.com.itr.cestointeligente.entities;

public class Message {
	int mensaje_id;
	int compostera_id;
	String fecha;
	Double peso;
	int evento;
	
	public Message(int mensaje_id, int compostera_id, String fecha,
			Double peso, int evento) {
		super();
		this.mensaje_id = mensaje_id;
		this.compostera_id = compostera_id;
		this.fecha = fecha;
		this.peso = peso;
		this.evento = evento;
	}

	public Message() {
	}

	public int getMensaje_id() {
		return mensaje_id;
	}

	public void setMensaje_id(int mensaje_id) {
		this.mensaje_id = mensaje_id;
	}

	public int getCompostera_id() {
		return compostera_id;
	}

	public void setCompostera_id(int compostera_id) {
		this.compostera_id = compostera_id;
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

	public int getEvento() {
		return evento;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}
}
