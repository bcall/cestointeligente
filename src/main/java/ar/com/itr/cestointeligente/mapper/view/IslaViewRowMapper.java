package ar.com.itr.cestointeligente.mapper.view;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.view.IslaView;

public class IslaViewRowMapper implements RowMapper<IslaView> {

	@Override
	public IslaView mapRow(ResultSet rs, int index) throws SQLException {
		@SuppressWarnings("unused")
		DateTimeFormatter df = DateTimeFormat
				.forPattern("yyyy-MM-dd HH:mm:ss.S");
		IslaView islaView = new IslaView();
		islaView.setISLAPOSICION((rs.getString("POSICION")));
		islaView.setHINPUT(rs.getDouble("H_INPUT"));
		islaView.setHOUTPUT(rs.getDouble("H_OUTPUT"));
		islaView.setLASTW(rs.getDouble("LAST_W"));
		islaView.setPOSITIONID(rs.getInt("isla_posicion_id"));
		islaView.setPROYECTOID(rs.getInt("comp_proyect_id"));
		
		//TODO
//		int days= Days.daysBetween(df.parseDateTime(rs.getString("DATE_FROM")).toLocalDate(),new LocalDate()).getDays();
//		Double actual=days*rs.getDouble("INPUT_DAY_PROY");
//		Double status = actual /rs.getDouble("H_INPUT"); 
		return islaView;
	}

}
