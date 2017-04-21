package ar.com.itr.cestointeligente.entities.view;

public class CestoNotAliveView {
	private int cestoId;
	private String establecimiento;
	private String establecimientoCalle;
	private String isla;
	private String ubicacion;

	@Override
	public String toString() {
		return "CestoNotAliveView [cestoId=" + cestoId + ", establecimientoCalle=" + establecimientoCalle
				+  ", isla=" + isla + ", ubicacion=" + ubicacion + "]";
	}

	// Getters and Setters
	public int getCestoId() {
		return cestoId;
	}

	public void setCestoId(int cestoId) {
		this.cestoId = cestoId;
	}

	public String getIsla() {
		return isla;
	}

	public void setIsla(String isla) {
		this.isla = isla;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getEstablecimientoCalle() {
		return establecimientoCalle;
	}

	public void setEstablecimientoCalle(String establecimientoCalle) {
		this.establecimientoCalle = establecimientoCalle;
	}

	public String getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}

}
