package ar.com.itr.cestointeligente.DAOImpl.utils;

public class IndexGraphQueryCriteria {
	private Integer corrienteResiduoID;
	private Integer establecimientoID;
	private Integer proyectoID;
	private Integer islaID;
	private Integer tipoResiduoID;

	/**
	 * Constructor
	 * @param corrienteResiduoID
	 */
	public IndexGraphQueryCriteria(Integer corrienteResiduoID) {
		super();
		this.corrienteResiduoID = corrienteResiduoID;
	}
	
	/**
	 * Constructor
	 * @param corrienteResiduoID
	 * @param establecimientoID
	 * @param proyectoID
	 * @param islaID
	 * @param tipoResiduoID
	 */
	public IndexGraphQueryCriteria(Integer corrienteResiduoID, Integer establecimientoID, Integer proyectoID,
			Integer islaID, Integer tipoResiduoID) {
		super();
		this.corrienteResiduoID = corrienteResiduoID;
		this.establecimientoID = establecimientoID;
		this.proyectoID = proyectoID;
		this.islaID = islaID;
		this.tipoResiduoID = tipoResiduoID;
	}



	//Getters and Setters
	public Integer getCorrienteResiduoID() {
		return corrienteResiduoID;
	}

	public void setCorrienteResiduoID(Integer corrienteResiduoID) {
		this.corrienteResiduoID = corrienteResiduoID;
	}

	public Integer getEstablecimientoID() {
		return establecimientoID;
	}

	public void setEstablecimientoID(Integer establecimientoID) {
		this.establecimientoID = establecimientoID;
	}

	public Integer getProyectoID() {
		return proyectoID;
	}

	public void setProyectoID(Integer proyectoID) {
		this.proyectoID = proyectoID;
	}

	public Integer getIslaID() {
		return islaID;
	}

	public void setIslaID(Integer islaID) {
		this.islaID = islaID;
	}

	public Integer getTipoResiduoID() {
		return tipoResiduoID;
	}

	public void setTipoResiduoID(Integer tipoResiduoID) {
		this.tipoResiduoID = tipoResiduoID;
	}
	
}
