package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.IslaPosicion;

public class IslaPosicionRowMapper implements RowMapper<IslaPosicion> {

	@Override
	public IslaPosicion mapRow(ResultSet rs, int index) throws SQLException {
		IslaPosicion isla = new IslaPosicion();
		isla.setPOSICION(rs.getString("posicion"));
		isla.setID(rs.getInt("id"));

		return isla;
	}

}