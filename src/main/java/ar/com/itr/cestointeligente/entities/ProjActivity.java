package ar.com.itr.cestointeligente.entities;

import java.util.Map;


public class ProjActivity {
private int ID;
private int PROJ_ID;
private int ACT_ID;
private String IDENTIFIER;
private String OBS;
private Double OBJ_INPUT;
private int OBJ_OUT;
private Double OBJ_C_IN;
private int OBJ_C_OUT;
private Map<String,Object> actDet;
private Activity act;

public ProjActivity(){
	
}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public int getPROJ_ID() {
	return PROJ_ID;
}
public void setPROJ_ID(int pROJ_ID) {
	PROJ_ID = pROJ_ID;
}
public int getACT_ID() {
	return ACT_ID;
}
public void setACT_ID(int aCT_ID) {
	ACT_ID = aCT_ID;
}
public String getOBS() {
	return OBS;
}
public void setOBS(String oBS) {
	OBS = oBS;
}
public Double getOBJ_INPUT() {
	return OBJ_INPUT;
}
public void setOBJ_INPUT(Double oBJ_INPUT) {
	OBJ_INPUT = oBJ_INPUT;
}
public int getOBJ_OUT() {
	return OBJ_OUT;
}
public void setOBJ_OUT(int oBJ_OUT) {
	OBJ_OUT = oBJ_OUT;
}
public Double getOBJ_C_IN() {
	return OBJ_C_IN;
}
public void setOBJ_C_IN(Double oBJ_C_IN) {
	OBJ_C_IN = oBJ_C_IN;
}
public int getOBJ_C_OUT() {
	return OBJ_C_OUT;
}
public void setOBJ_C_OUT(int oBJ_C_OUT) {
	OBJ_C_OUT = oBJ_C_OUT;
}
public Map<String,Object> getActDet() {
	return actDet;
}
public void setActDet(Map<String,Object> actDet) {
	this.actDet = actDet;
}
public Activity getAct() {
	return act;
}
public void setAct(Activity act) {
	this.act = act;
}
public String getIDENTIFIER() {
	return IDENTIFIER;
}
public void setIDENTIFIER(String iDENTIFIER) {
	IDENTIFIER = iDENTIFIER;
}
}
