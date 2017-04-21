package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.Activity;

public class ActivityRowMapper implements RowMapper<Activity> {

	@Override
	public Activity mapRow(ResultSet rs, int rowNum) throws SQLException {
		DateTimeFormatter df = DateTimeFormat
				.forPattern("yyyy-MM-dd");
		Activity act = new Activity();
		act.setASIST(rs.getInt("ASIST"));
		act.setDATE_FROM(df.parseDateTime(rs.getString("DATE_FROM")).toString(
				"dd/MM/yyyy"));
		act.setDATE_TO(df.parseDateTime(rs.getString("DATE_TO")).toString(
				"dd/MM/yyyy"));
		act.setDAYS_PASSED(Days.daysBetween(df.parseDateTime(rs.getString("DATE_FROM")).toLocalDate(),new LocalDate()).getDays());
		act.setDAYS_LEFT(Days.daysBetween(new LocalDate(), df.parseDateTime(rs.getString("DATE_TO")).toLocalDate()).getDays());
		act.setID(rs.getInt("ID"));
		act.setMOTIVE(rs.getString("MOTIVE"));
		act.setOBS(rs.getString("OBS"));
		act.setRES(rs.getString("RES"));
		act.setRESP(rs.getString("RESP"));
		act.setTYPE(rs.getString("TYPE"));
		act.setUSERS(rs.getInt("USERS"));
		act.setIDENTIFIER(rs.getString("IDENTIFIER"));
		return act;
	}

}
