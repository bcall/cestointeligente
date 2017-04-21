package ar.com.itr.cestointeligente.entities;

public class TipoResiduo {	
	private int ID;
	private String name;
	
	/**
	 * Default Constructor
	 */
	public TipoResiduo() {		
	}
	
	/**
	 * Constructor
	 * @param iD
	 * @param name
	 */
	public TipoResiduo(int iD, String name) {
		super();
		ID = iD;
		this.name = name;
	}	
	
	//Getters and Setters
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
