package ar.com.itr.cestointeligente.entities;

public class Isla {
	private int GR_U_DAY_PROY;
	private int INPUT_DAY_PROY;
	private String CORRIENTE_RESIDUO_NAME;
	private int GR_DAY_PROY;
	private String ISLA_POSICION;
	private Double HINPUT;
	private Double HOUTPUT;
	private Double LASTW;
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
	public Isla() {

	}
	
	/**
	 * Constructor
	 * @param gR_U_DAY_PROY
	 * @param iNPUT_DAY_PROY
	 * @param cORRIENTE_RESIDUO_NAME
	 * @param gR_DAY_PROY
	 * @param iSLA_POSICION
	 * @param hINPUT
	 * @param hOUTPUT
	 * @param lASTW
	 */
	public Isla(int gR_U_DAY_PROY, int iNPUT_DAY_PROY, String cORRIENTE_RESIDUO_NAME, int gR_DAY_PROY,
			String iSLA_POSICION, Double hINPUT, Double hOUTPUT, Double lASTW) {
		super();
		GR_U_DAY_PROY = gR_U_DAY_PROY;
		INPUT_DAY_PROY = iNPUT_DAY_PROY;
		CORRIENTE_RESIDUO_NAME = cORRIENTE_RESIDUO_NAME;
		GR_DAY_PROY = gR_DAY_PROY;
		ISLA_POSICION = iSLA_POSICION;
		HINPUT = hINPUT;
		HOUTPUT = hOUTPUT;
		LASTW = lASTW;
	}

	public String getIdentifier() {
		String identifier = (this.getISLA_POSICION() != null) ? this.getISLA_POSICION() + " - " : "";
		identifier = identifier + this.getCORRIENTE_RESIDUO_NAME();
		return identifier;
	}


	// GETTERS AND SETTERS

	public int getGR_U_DAY_PROY() {
		return GR_U_DAY_PROY;
	}

	public void setGR_U_DAY_PROY(int gR_U_DAY_PROY) {
		GR_U_DAY_PROY = gR_U_DAY_PROY;
	}

	public int getINPUT_DAY_PROY() {
		return INPUT_DAY_PROY;
	}

	public void setINPUT_DAY_PROY(int iNPUT_DAY_PROY) {
		INPUT_DAY_PROY = iNPUT_DAY_PROY;
	}

	public String getCORRIENTE_RESIDUO_NAME() {
		return CORRIENTE_RESIDUO_NAME;
	}

	public void setCORRIENTE_RESIDUO_NAME(String cORRIENTE_RESIDUO_NAME) {
		CORRIENTE_RESIDUO_NAME = cORRIENTE_RESIDUO_NAME;
	}

	public int getGR_DAY_PROY() {
		return GR_DAY_PROY;
	}

	public void setGR_DAY_PROY(int gR_DAY_PROY) {
		GR_DAY_PROY = gR_DAY_PROY;
	}

	public String getISLA_POSICION() {
		return ISLA_POSICION;
	}

	public void setISLA_POSICION(String iSLA_POSICION_POSICION) {
		ISLA_POSICION = iSLA_POSICION_POSICION;
	}

	public Double getHINPUT() {
		return HINPUT;
	}

	public void setHINPUT(Double hINPUT) {
		HINPUT = hINPUT;
	}

	public Double getHOUTPUT() {
		return HOUTPUT;
	}

	public void setHOUTPUT(Double hOUTPUT) {
		HOUTPUT = hOUTPUT;
	}

	public Double getLASTW() {
		return LASTW;
	}

	public void setLASTW(Double lASTW) {
		LASTW = lASTW;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	//TODO usar un object view
			
		public String getCorrienteResiduoName() {
			return this.getCORRIENTE_RESIDUO_NAME();
		}
		
		public int getGrUDayProy() {
			return this.getGR_DAY_PROY();
		}
		
		public int getInputDayProy() {
			return this.getINPUT_DAY_PROY();
		}
		
		public String getIslaPosicion() {
			return this.getISLA_POSICION();
		}
		
		public int getGrDayProy() {
			return this.GR_DAY_PROY;
		}
}
