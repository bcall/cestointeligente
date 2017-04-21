package ar.com.itr.cestointeligente.entities;


public class Project {

	private int id;
	private String IDENTIFIER;
	private int COMP_ID;
	private String TURN;
	private int ESTAB_ID;
	private String STATUS;
	private boolean ACTIVE;
	private String DATEFROM;
	private String DATETO;
	private String RESPNAME;
	private String RESPPHONE;
	private String INST_DATE;
	private String INST_RESP_NAME;
	private String SUPERV_NAME;
	private String SUPERV_PHONE;
	private String EST_NAME;	
	private int DAYS_LEFT;
	private int DAYS_PASSED;
	private int USERS;
	
	public Project() {
	}

	public int getID() {
		return id;
	}

	public void setID(int iD) {
		id = iD;
	}

	public int getCOMP_ID() {
		return COMP_ID;
	}

	public void setCOMP_ID(int cOMP_ID) {
		COMP_ID = cOMP_ID;
	}

	public String getTURN() {
		return TURN;
	}

	public void setTURN(String tURN) {
		TURN = tURN;
	}

	public int getESTAB_ID() {
		return ESTAB_ID;
	}

	public void setESTAB_ID(int eSTAB_ID) {
		ESTAB_ID = eSTAB_ID;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public boolean isACTIVE() {
		return ACTIVE;
	}

	public void setACTIVE(boolean aCTIVE) {
		ACTIVE = aCTIVE;
	}

	public String getDATEFROM() {
		return DATEFROM;
	}

	public void setDATEFROM(String dATEFROM) {
		DATEFROM = dATEFROM;
	}

	public String getDATETO() {
		return DATETO;
	}

	public void setDATETO(String dATETO) {
		DATETO = dATETO;
	}

	public String getRESPNAME() {
		return RESPNAME;
	}

	public void setRESPNAME(String rESPNAME) {
		RESPNAME = rESPNAME;
	}

	public String getRESPPHONE() {
		return RESPPHONE;
	}

	public void setRESPPHONE(String rESP_PHONE) {
		RESPPHONE = rESP_PHONE;
	}

	public String getINST_DATE() {
		return INST_DATE;
	}

	public void setINST_DATE(String iNST_DATE) {
		INST_DATE = iNST_DATE;
	}

	public String getINST_RESP_NAME() {
		return INST_RESP_NAME;
	}

	public void setINST_RESP_NAME(String iNST_RESP_NAME) {
		INST_RESP_NAME = iNST_RESP_NAME;
	}

	public String getSUPERV_NAME() {
		return SUPERV_NAME;
	}

	public int getDAYS_PASSED() {
		return DAYS_PASSED;
	}

	public void setDAYS_PASSED(int dAYS_PASSED) {
		DAYS_PASSED = dAYS_PASSED;
	}

	public void setSUPERV_NAME(String sUPERV_NAME) {
		SUPERV_NAME = sUPERV_NAME;
	}

	public String getSUPERV_PHONE() {
		return SUPERV_PHONE;
	}

	public void setSUPERV_PHONE(String sUPERV_PHONE) {
		SUPERV_PHONE = sUPERV_PHONE;
	}

	public int getDAYS_LEFT() {
		return DAYS_LEFT;
	}

	public void setDAYS_LEFT(int dAYS_LEFT) {
		DAYS_LEFT = dAYS_LEFT;
	}

	public String getEST_NAME() {
		return EST_NAME;
	}

	public void setEST_NAME(String eST_NAME) {
		EST_NAME = eST_NAME;
	}

	public String getIDENTIFIER() {
		return IDENTIFIER;
	}

	public void setIDENTIFIER(String iDENTIFIER) {
		IDENTIFIER = iDENTIFIER;
	}

	public int getUSERS() {
		return USERS;
	}

	public void setUSERS(int uSERS) {
		USERS = uSERS;
	}	
	
}
