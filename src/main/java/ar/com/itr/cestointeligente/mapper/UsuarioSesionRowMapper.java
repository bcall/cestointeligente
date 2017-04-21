package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.EstadoSesion;
import ar.com.itr.cestointeligente.entities.UsuarioSesion;

public class UsuarioSesionRowMapper implements RowMapper<UsuarioSesion> {

	@Override
	public UsuarioSesion mapRow(ResultSet rs, int index) throws SQLException {
		UsuarioSesion sesion = new UsuarioSesion();
		
		sesion.setId(rs.getInt("id"));
		sesion.setNombreUsuario(rs.getString("nombre_usuario"));
		sesion.setToken(rs.getString("token"));
		sesion.setEstado(EstadoSesion.valueOf(rs.getString("estado")));
		sesion.setInicio(rs.getTimestamp("inicio"));	
		sesion.setUsuarioId(rs.getInt("usuario_id"));
		
		return sesion;
	}

}
