package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.GrupoUsuario;

public class GrupoUsuarioRowMapper implements RowMapper<GrupoUsuario> {

	@Override
	public GrupoUsuario mapRow(ResultSet rs, int index) throws SQLException {
		GrupoUsuario grupoUsuario = new GrupoUsuario();
		grupoUsuario.setId(rs.getInt("id"));
		grupoUsuario.setDescripcion("descripcion");
		
		return grupoUsuario;
	}
}
