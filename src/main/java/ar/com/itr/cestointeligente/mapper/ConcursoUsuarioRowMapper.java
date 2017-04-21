package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.ConcursoUsuario;

public class ConcursoUsuarioRowMapper implements RowMapper<ConcursoUsuario> {

	@Override
	public ConcursoUsuario mapRow(ResultSet rs, int index) throws SQLException {
		ConcursoUsuario c = new ConcursoUsuario();
		c.setConcursoId(rs.getInt("concurso_id"));
		c.setId(rs.getInt("id"));
		c.setPosicionFinal(rs.getInt("posicion_final"));
		c.setPuntosAcumulados(rs.getInt("puntos_acumulados"));
        c.setUsuarioId(rs.getInt("usuario_id"));
		return c;
	}

}
