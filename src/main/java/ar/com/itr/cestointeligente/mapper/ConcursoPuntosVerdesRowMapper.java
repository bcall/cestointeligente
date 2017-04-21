package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.ConcursoPuntosVerdes;

public class ConcursoPuntosVerdesRowMapper implements RowMapper<ConcursoPuntosVerdes> {

	@Override
	public ConcursoPuntosVerdes mapRow(ResultSet rs, int index) throws SQLException {
		ConcursoPuntosVerdes concurso = new ConcursoPuntosVerdes();
		concurso.setConcursoId(rs.getInt("concurso_id"));
		concurso.setPuntos(rs.getInt("puntos"));
		return concurso;
	}

}
