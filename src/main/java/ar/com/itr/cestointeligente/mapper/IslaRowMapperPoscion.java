package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.IslaUbicacion;

public class IslaRowMapperPoscion implements RowMapper<IslaUbicacion> {

	@Override
	public IslaUbicacion mapRow(ResultSet rs, int index) throws SQLException {
		IslaUbicacion isla = new IslaUbicacion();

		isla.setID(rs.getInt("id"));
		isla.setLATITUD(rs.getString("LATITUD"));
		isla.setLONGITUD(rs.getString("LONGITUD"));
		
		return isla;
	}

}
