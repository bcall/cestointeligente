package ar.com.itr.cestointeligente.entities.view;


public class CestoView {

	private int ID;
	private String STATUS;
	private String MODELNAME;
	private Double VOLUME;
	private Double ALARMW;
	private String HARDD;
	private String FIRMWARE;
	private String FABDATE;
	private String IMAGE;
	private String TIPORESIDUO;
	private String CORRIENTERESIDUO;
	private Double WEIGTH;

	public Double getWEIGTH() {
		return WEIGTH;
	}

	public void setWEIGTH(Double wEIGTH) {
		WEIGTH = wEIGTH;
	}

	/**
	 * Default Constructor
	 */
	public CestoView() {
	}

	/**
	 * Constructor
	 * @param iD
	 * @param sTATUS
	 * @param mODELNAME
	 * @param vOLUME
	 * @param aLARMW
	 * @param hARDD
	 * @param fIRMWARE
	 * @param fABDATE
	 * @param tIPORESIDUO
	 * @param cORRIENTERESIDUO
	 */
	public CestoView(int iD, String sTATUS, String mODELNAME, Double vOLUME,
			Double aLARMW, String hARDD, String fIRMWARE, String fABDATE, String tIPORESIDUO, String  cORRIENTERESIDUO) {
		super();
		ID = iD;
		STATUS = sTATUS;
		MODELNAME = mODELNAME;
		VOLUME = vOLUME;
		ALARMW = aLARMW;
		HARDD = hARDD;
		FIRMWARE = fIRMWARE;
		FABDATE = fABDATE;
		CORRIENTERESIDUO = cORRIENTERESIDUO;
		TIPORESIDUO = tIPORESIDUO;
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

	public String getMODELNAME() {
		return MODELNAME;
	}

	public void setMODELNAME(String mODELNAME) {
		MODELNAME = mODELNAME;
	}

	public Double getVOLUME() {
		return VOLUME;
	}

	public void setVOLUME(Double vOLUME) {
		VOLUME = vOLUME;
	}

	public Double getALARMW() {
		return ALARMW;
	}

	public void setALARMW(Double aLARMW) {
		ALARMW = aLARMW;
	}

	public String getHARDD() {
		return HARDD;
	}

	public void setHARDD(String hARDD) {
		HARDD = hARDD;
	}

	public String getFIRMWARE() {
		return FIRMWARE;
	}

	public void setFIRMWARE(String fIRMWARE) {
		FIRMWARE = fIRMWARE;
	}

	public String getFABDATE() {
		return FABDATE;
	}

	public void setFABDATE(String fABDATE) {
		FABDATE = fABDATE;
	}

	public String getIMAGE() {
		return IMAGE;
	}

	public void setIMAGE(String iMAGE) {
		IMAGE = iMAGE;
	}

	public String getTIPORESIDUO() {
		return TIPORESIDUO;
	}

	public void setTIPORESIDUO(String tIPORESIDUO) {
		TIPORESIDUO = tIPORESIDUO;
	}

	public String getCORRIENTERESIDUO() {
		return CORRIENTERESIDUO;
	}

	public void setCORRIENTERESIDUO(String cORRIENTERESIDUO) {
		CORRIENTERESIDUO = cORRIENTERESIDUO;
	}
	public String getLINK() {
		return "../sections/cesto?id="+ this.getID();
	}
}
