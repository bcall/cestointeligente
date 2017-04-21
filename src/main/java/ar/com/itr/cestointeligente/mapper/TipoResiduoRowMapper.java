package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import ar.com.itr.cestointeligente.entities.TipoResiduo;

public class TipoResiduoRowMapper implements RowMapper<TipoResiduo>{

	@Override
	public TipoResiduo mapRow(ResultSet rs, int index) throws SQLException {
		TipoResiduo tipoResiduo = new TipoResiduo();	
		tipoResiduo.setID(rs.getInt("id"));
		tipoResiduo.setName(rs.getString("name"));
		return tipoResiduo;
	}

	
}
