package ar.com.itr.cestointeligente.entities;

public class IslaPosicion {
	private int ID;
	private String POSICION;
	
	/**
	 * Default Constructor
	 */
	public IslaPosicion() {
		
	}
	
	/**
	 * Constructor
	 * @param iD
	 * @param pOSICION
	 */
	public IslaPosicion(int iD, String pOSICION) {
		super();
		ID = iD;
		POSICION = pOSICION;
	}
	
	//getters and setters
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getPOSICION() {
		return POSICION;
	}
	public void setPOSICION(String pOSICION) {
		POSICION = pOSICION;
	}
}
