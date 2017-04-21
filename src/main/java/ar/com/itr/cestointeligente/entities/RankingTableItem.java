package ar.com.itr.cestointeligente.entities;

public class RankingTableItem {
 private int ID;
 private String NAME;
 private String CGP;
 private String DIST;
 private String NIVEL;
 private String DIVISION;
 private String TURN;
 private Double INPUT;
 private int C_INPUT;
 private Double OUTPUT;
 private int C_OUTPUT;
 
 public RankingTableItem(){
	 
 }
 
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getNAME() {
	return NAME;
}
public void setNAME(String nAME) {
	NAME = nAME;
}
public String getCGP() {
	return CGP;
}
public void setCGP(String cGP) {
	CGP = cGP;
}
public String getDIST() {
	return DIST;
}
public void setDIST(String dIST) {
	DIST = dIST;
}
public String getNIVEL() {
	return NIVEL;
}
public void setNIVEL(String cURSO_NIVEL) {
	NIVEL = cURSO_NIVEL;
}
public String getDIVISION() {
	return DIVISION;
}
public void setDIVISION(String cURSO_DIVISION) {
	DIVISION = cURSO_DIVISION;
}
public String getTURN() {
	return TURN;
}
public void setTURN(String tURN) {
	TURN = tURN;
}
public Double getINPUT() {
	return INPUT;
}
public void setINPUT(Double iNPUT) {
	INPUT = iNPUT;
}
public int getC_INPUT() {
	return C_INPUT;
}
public void setC_INPUT(int c_INPU) {
	C_INPUT = c_INPU;
}
public Double getOUTPUT() {
	return OUTPUT;
}
public void setOUTPUT(Double oUTPUT) {
	OUTPUT = oUTPUT;
}
public int getC_OUTPUT() {
	return C_OUTPUT;
}
public void setC_OUTPUT(int c_OUTPUT) {
	C_OUTPUT = c_OUTPUT;
}


}
