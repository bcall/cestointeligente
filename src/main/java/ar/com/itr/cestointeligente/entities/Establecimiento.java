package ar.com.itr.cestointeligente.entities;

import java.util.List;

public class Establecimiento {
	private int ID;
	private int ID_NIVEL;
	private int ID_DISTRITO;
	private int ID_CGP;
	private int COMP;
	private String NAME;
	private String CALLE;
	private String NUM;
	private String LAT;
	private String LONG;
	private String CP;
	private String HORARIO;
	private List<Project> PROYECTS;

	public Establecimiento(int id, int nivel, int distrito, int cgp,
			String name, String calle, String num, String lat, String lng,
			String cp, String horario) {
		ID = id;
		ID_NIVEL = nivel;
		ID_DISTRITO = distrito;
		ID_CGP = cgp;
		NAME = name;
		CALLE = calle;
		NUM = num;
		LAT = lat;
		LONG = lng;
		CP = cp;
		HORARIO = horario;
	}
	
	public Establecimiento() {
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getID_NIVEL() {
		return ID_NIVEL;
	}

	public void setID_NIVEL(int iD_NIVEL) {
		ID_NIVEL = iD_NIVEL;
	}

	public int getID_DISTRITO() {
		return ID_DISTRITO;
	}

	public void setID_DISTRITO(int iD_DISTRITO) {
		ID_DISTRITO = iD_DISTRITO;
	}

	public int getID_CGP() {
		return ID_CGP;
	}

	public void setID_CGP(int iD_CGP) {
		ID_CGP = iD_CGP;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getCALLE() {
		return CALLE;
	}

	public void setCALLE(String cALLE) {
		CALLE = cALLE;
	}

	public String getNUM() {
		return NUM;
	}

	public void setNUM(String nUM) {
		NUM = nUM;
	}

	public String getLAT() {
		return LAT;
	}

	public void setLAT(String lAT) {
		LAT = lAT;
	}

	public String getLONG() {
		return LONG;
	}

	public void setLONG(String lONG) {
		LONG = lONG;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String cP) {
		CP = cP;
	}

	public String getHORARIO() {
		return HORARIO;
	}

	public void setHORARIO(String hORARIO) {
		HORARIO = hORARIO;
	}
	public List<Project> getPROYECTS() {
		return PROYECTS;
	}
	public void setPROYECTS(List<Project> pROYECTS) {
		PROYECTS = pROYECTS;
	}

	public int getCOMP() {
		return COMP;
	}

	public void setCOMP(int cOMP) {
		COMP = cOMP;
	}

}
