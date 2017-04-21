package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.Usuario;

public class UsuarioRowMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int index) throws SQLException {
		Usuario usuario = new Usuario();
		
		usuario.setId(rs.getInt("Id"));
		usuario.setApellido(rs.getString("apellido"));
		usuario.setGrupoUsuarioId(rs.getInt("grupo_id"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setNombreUsuario(rs.getString("nombre_usuario"));
		usuario.setPassword(rs.getString("password"));
		usuario.setTelefono(rs.getString("telefono"));
		
		return usuario;
	}

}
