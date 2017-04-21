package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.UsuarioTotem;

public class UsuarioTotemRowMapper implements RowMapper<UsuarioTotem> {

	@Override
	public UsuarioTotem mapRow(ResultSet rs, int index) throws SQLException {
		UsuarioTotem usuario = new UsuarioTotem();
		
		usuario.setId(rs.getInt("Id"));
		usuario.setQrCode(rs.getString("codigoqr"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setTelefono(rs.getString("telefono"));
		usuario.setEmail(rs.getString("email"));
		usuario.setPesoA(usuario.getId()*10);
		usuario.setPesoB(usuario.getId()*5);
		usuario.setPesoC(usuario.getId()*2);
		usuario.setPuntos(rs.getLong("puntos"));
		
		return usuario;
	}

}
