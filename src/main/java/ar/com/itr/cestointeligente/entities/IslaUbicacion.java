package ar.com.itr.cestointeligente.entities;

public class IslaUbicacion {
	private int ID;
	private String LATITUD;
	private String LONGITUD;

	public String getLATITUD() {
		return LATITUD;
	}

	public void setLATITUD(String lATITUD) {
		LATITUD = lATITUD;
	}

	public String getLONGITUD() {
		return LONGITUD;
	}

	public void setLONGITUD(String lONGITUD) {
		LONGITUD = lONGITUD;
	}

	/**
	 * Default Constructor.
	 */
	public IslaUbicacion() {

	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}	
}
