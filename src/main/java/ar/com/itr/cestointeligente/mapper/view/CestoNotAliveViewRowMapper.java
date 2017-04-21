package ar.com.itr.cestointeligente.mapper.view;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.view.CestoNotAliveView;

public class CestoNotAliveViewRowMapper implements RowMapper<CestoNotAliveView> {

	@Override
	public CestoNotAliveView mapRow(ResultSet rs, int rowNum) throws SQLException {		
		CestoNotAliveView cestoNotAliveView = new CestoNotAliveView();		
		cestoNotAliveView.setCestoId(rs.getInt("cesto_id"));
		cestoNotAliveView.setEstablecimiento(rs.getString("establecimiento"));
		cestoNotAliveView.setEstablecimientoCalle(rs.getString("establecimiento_calle") + " " + rs.getString("establecimiento_numero"));
		cestoNotAliveView.setIsla(rs.getString("isla_name"));
		cestoNotAliveView.setUbicacion(rs.getString("ubicacion"));
		return cestoNotAliveView;
	}

}
