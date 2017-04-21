package ar.com.itr.cestointeligente.entities;


public class Cesto {

	private int ID;
	private String STATUS;
	private String MODEL_NAME;
	private Double VOLUME;
	private Double ALARM_W;
	private String HARD_D;
	private String FIRMWARE;
	private String FAB_DATE;
	private String IMAGE;
	private String TIPO_RESIDUO;
	private String CORRIENTE_RESIDUO;
	private int TIPO_RESIDUO_ID;

	public Cesto() {
	}

	public Cesto(int iD, String sTATUS, String mODEL_NAME, Double vOLUME,
			Double aLARM_W, String hARD_D, String fIRMWARE, String fAB_DATE, String tIPO_RESIDUO, String  cORRIENTE_RESIDUO, int TIPO_RESIDUO_ID) {
		super();
		ID = iD;
		STATUS = sTATUS;
		MODEL_NAME = mODEL_NAME;
		VOLUME = vOLUME;
		ALARM_W = aLARM_W;
		HARD_D = hARD_D;
		FIRMWARE = fIRMWARE;
		FAB_DATE = fAB_DATE;
		CORRIENTE_RESIDUO = cORRIENTE_RESIDUO;
		TIPO_RESIDUO = tIPO_RESIDUO;
		this.TIPO_RESIDUO_ID = TIPO_RESIDUO_ID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public String getMODEL_NAME() {
		return MODEL_NAME;
	}

	public void setMODEL_NAME(String mODEL_NAME) {
		MODEL_NAME = mODEL_NAME;
	}

	public Double getVOLUME() {
		return VOLUME;
	}

	public void setVOLUME(Double vOLUME) {
		VOLUME = vOLUME;
	}

	public Double getALARM_W() {
		return ALARM_W;
	}

	public void setALARM_W(Double aLARM_W) {
		ALARM_W = aLARM_W;
	}

	public String getHARD_D() {
		return HARD_D;
	}

	public void setHARD_D(String hARD_D) {
		HARD_D = hARD_D;
	}

	public String getFIRMWARE() {
		return FIRMWARE;
	}

	public void setFIRMWARE(String fIRMWARE) {
		FIRMWARE = fIRMWARE;
	}

	public String getFAB_DATE() {
		return FAB_DATE;
	}

	public void setFAB_DATE(String fAB_DATE) {
		FAB_DATE = fAB_DATE;
	}

	public String getIMAGE() {
		return IMAGE;
	}

	public void setIMAGE(String iMAGE) {
		IMAGE = iMAGE;
	}

	public String getTIPO_RESIDUO() {
		return TIPO_RESIDUO;
	}

	public void setTIPO_RESIDUO(String tIPO_RESIDUO) {
		TIPO_RESIDUO = tIPO_RESIDUO;
	}

	public String getCORRIENTE_RESIDUO() {
		return CORRIENTE_RESIDUO;
	}

	public void setCORRIENTE_RESIDUO(String cORRIENTE_RESIDUO) {
		CORRIENTE_RESIDUO = cORRIENTE_RESIDUO;
	}

	public int getTIPO_RESIDUO_ID() {
		return TIPO_RESIDUO_ID;
	}

	public void setTIPO_RESIDUO_ID(int tIPO_RESIDUO_ID) {
		TIPO_RESIDUO_ID = tIPO_RESIDUO_ID;
	}	

}
