package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.Project;

public class ProjectRowMapper implements RowMapper<Project> {

	@Override
	public Project mapRow(ResultSet rs, int index) throws SQLException {
		Project p = new Project();
		DateTimeFormatter df = DateTimeFormat
				.forPattern("yyyy-MM-dd HH:mm:ss.S");
		p.setID(rs.getInt(1));
		p.setIDENTIFIER(rs.getString("IDENTIFIER"));
		p.setCOMP_ID(rs.getInt("COMP_ID"));
		p.setTURN(rs.getString("TURN"));
		p.setESTAB_ID(rs.getInt("ESTAB_ID"));
		p.setSTATUS(rs.getString("STATUS"));
		p.setACTIVE((rs.getInt("ACTIVE") == 1) ? true : false);
		p.setUSERS(rs.getInt("USERS"));
		//p.setGR_U_DAY_PROY(rs.getInt("GR_U_DAY_PROY"));
		//p.setINPUT_DAY_PROY(rs.getInt("INPUT_DAY_PROY"));
		p.setDATEFROM(df.parseDateTime(rs.getString("DATE_FROM")).toString(
				"dd/MM/yyyy"));
		p.setDATETO(df.parseDateTime(rs.getString("DATE_TO")).toString(
				"dd/MM/yyyy"));
		p.setRESPNAME(rs.getString("RESP_NAME"));
		p.setRESPPHONE(rs.getString("RESP_PHONE"));
		p.setINST_DATE(df.parseDateTime(rs.getString("INST_DATE")).toString(
				"dd/MM/yyyy"));
		p.setINST_RESP_NAME(rs.getString("INST_RESP_NAME"));
		p.setSUPERV_NAME(rs.getString("SUPERV_NAME"));
		p.setSUPERV_PHONE(rs.getString("SUPERV_PHONE"));
		//p.setGR_DAY_PROY(p.getGR_U_DAY_PROY() * p.getINPUT_DAY_PROY());
		p.setDAYS_PASSED(Days.daysBetween(df.parseDateTime(rs.getString("DATE_FROM")).toLocalDate(),new LocalDate()).getDays());
		p.setDAYS_LEFT(Days.daysBetween(new LocalDate(), df.parseDateTime(rs.getString("DATE_TO")).toLocalDate()).getDays());
		p.setEST_NAME(rs.getString("NAME"));		
		return p;
	}

}
