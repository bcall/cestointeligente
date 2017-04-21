package ar.com.itr.cestointeligente.entities.view;

import java.util.Date;

public class IslaView {
	private Date DATETO;
	private Date DATEFROM;
	private String ISLAPOSICION;
	private Double HINPUT;

	
	
	public String getNRSTATUS() {
		return " <i class='fa fa-thumbs-o-up fa-3x' ></i></span>";
	}
	
	public String getRSTATUS() {
		return "<i class='fa fa-thumbs-o-up fa-3x'></i>";
	}

	public Date getDATETO() {
		return DATETO;
	}
	public void setDATETO(Date dATETO) {
		DATETO = dATETO;
	}
	public Date getDATEFROM() {
		return DATEFROM;
	}
	public void setDATEFROM(Date dATEFROM) {
		DATEFROM = dATEFROM;
	}
	private Double HOUTPUT;
	private Double LASTW;
	private int    PROYECTOID;
	@SuppressWarnings("unused")
	private String link;
	
	public String getLink() {
		return "projectId="+ this.getPROYECTOID()+"&locationId="+this.getPOSITIONID();
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getPROYECTOID() {
		return PROYECTOID;
	}
	public void setPROYECTOID(int pROYECTOID) {
		PROYECTOID = pROYECTOID;
	}
	private int    POSITIONID;
	
	public int getPOSITIONID() {
		return POSITIONID;
	}
	public void setPOSITIONID(int pOSITIONID) {
		POSITIONID = pOSITIONID;
	}
	public String getISLAPOSICION() {
		return ISLAPOSICION;
	}
	public void setISLAPOSICION(String iSLAPOSICION) {
		ISLAPOSICION = iSLAPOSICION;
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
	
	
	
}
