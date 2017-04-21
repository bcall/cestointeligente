package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.Cesto;

public class CestoRowMapper implements RowMapper<Cesto> {

	@Override
	public Cesto mapRow(ResultSet rs, int index) throws SQLException {
		DateTimeFormatter df = DateTimeFormat
				.forPattern("yyyy-MM-dd");
		Cesto c = new Cesto();
		c.setID(rs.getInt("ID"));
		c.setMODEL_NAME(rs.getString("MODEL_NAME"));
		c.setFAB_DATE(df.parseDateTime(rs.getString("FAB_DATE")).toString(
				"dd/MM/yyyy"));
		c.setFIRMWARE(rs.getString("FIRMWARE"));
		c.setHARD_D(rs.getString("HARD_D"));
		c.setSTATUS(rs.getString("STATUS"));
		c.setVOLUME(rs.getDouble("VOLUME"));
		c.setALARM_W(rs.getDouble("ALARM_W"));
		c.setIMAGE(rs.getString("IMAGE"));
		c.setCORRIENTE_RESIDUO(rs.getString("CORRIENTE_RESIDUO"));
		c.setTIPO_RESIDUO(rs.getString("TIPO_RESIDUO"));
		c.setTIPO_RESIDUO_ID(rs.getInt("TIPO_RESIDUO_ID"));
		
		return c;
	}

}
