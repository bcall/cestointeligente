package ar.com.itr.cestointeligente.entities;

public class Activity {
	private int ID;
	private String IDENTIFIER;
	private String TYPE;
	private String RES;
	private String DATE_FROM;
	private String DATE_TO;
	private int USERS;
	private int ASIST;
	private String RESP;
	private String OBS;
	private String MOTIVE;
	private int DAYS_LEFT;
	private int DAYS_PASSED;

	public Activity() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public String getRES() {
		return RES;
	}

	public void setRES(String rES) {
		RES = rES;
	}

	public String getDATE_FROM() {
		return DATE_FROM;
	}

	public void setDATE_FROM(String dATE_FROM) {
		DATE_FROM = dATE_FROM;
	}

	public String getDATE_TO() {
		return DATE_TO;
	}

	public void setDATE_TO(String dATE_TO) {
		DATE_TO = dATE_TO;
	}

	public int getUSERS() {
		return USERS;
	}

	public void setUSERS(int uSERS) {
		USERS = uSERS;
	}

	public int getASIST() {
		return ASIST;
	}

	public void setASIST(int aSIST) {
		ASIST = aSIST;
	}

	public String getRESP() {
		return RESP;
	}

	public void setRESP(String rESP) {
		RESP = rESP;
	}

	public String getOBS() {
		return OBS;
	}

	public void setOBS(String oBS) {
		OBS = oBS;
	}

	public String getMOTIVE() {
		return MOTIVE;
	}

	public void setMOTIVE(String mOTIVE) {
		MOTIVE = mOTIVE;
	}
	public int getDAYS_LEFT() {
		return DAYS_LEFT;
	}

	public void setDAYS_LEFT(int dAYS_LEFT) {
		DAYS_LEFT = dAYS_LEFT;
	}

	public int getDAYS_PASSED() {
		return DAYS_PASSED;
	}

	public void setDAYS_PASSED(int dAYS_PASSED) {
		DAYS_PASSED = dAYS_PASSED;
	}

	public String getIDENTIFIER() {
		return IDENTIFIER;
	}

	public void setIDENTIFIER(String iDENTIFIER) {
		IDENTIFIER = iDENTIFIER;
	}
}
