package ar.com.itr.cestointeligente.mapper.view;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.RowMapper;
import ar.com.itr.cestointeligente.entities.view.CestoView;

public class CestoViewRowMapper implements RowMapper<CestoView> {

	@Override
	public CestoView mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		DateTimeFormatter df = DateTimeFormat
				.forPattern("yyyy-MM-dd");
		CestoView c = new CestoView();
		c.setID(rs.getInt("ID"));
		c.setMODELNAME(rs.getString("MODEL_NAME"));
		c.setFABDATE(df.parseDateTime(rs.getString("FAB_DATE")).toString(
				"dd/MM/yyyy"));
		c.setFIRMWARE(rs.getString("FIRMWARE"));
		c.setHARDD(rs.getString("HARD_D"));
		c.setSTATUS(rs.getString("STATUS"));
		c.setVOLUME(rs.getDouble("VOLUME"));
		c.setALARMW(rs.getDouble("ALARM_W"));
		c.setIMAGE(rs.getString("IMAGE"));
		c.setCORRIENTERESIDUO(rs.getString("CORRIENTE_RESIDUO"));
		c.setTIPORESIDUO(rs.getString("TIPO_RESIDUO"));
		c.setWEIGTH(rs.getDouble("WEIGTH"));
		return c;
	}

}
