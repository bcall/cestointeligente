package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.UsuarioRanking;

public class UsuarioRowMapperRanking implements RowMapper<UsuarioRanking> {

	@Override
	public UsuarioRanking mapRow(ResultSet rs, int index) throws SQLException {
		UsuarioRanking usuario = new UsuarioRanking();
		
		usuario.setId(rs.getInt("Id"));
		usuario.setApellido(rs.getString("apellido"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setNombreUsuario(rs.getString("nombre_usuario"));
		usuario.setPuntos(rs.getInt("puntos_acumulados"));
		return usuario;
	}

}
