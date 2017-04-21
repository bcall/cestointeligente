package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.Concurso;

public class ConcursoRowMapper implements RowMapper<Concurso> {

	@Override
	public Concurso mapRow(ResultSet rs, int index) throws SQLException {
		Concurso c = new Concurso();
		c.setCodigo(rs.getString("codigo"));
		c.setDescripcion(rs.getString("descripcion"));
		c.setFechaFin(rs.getDate("fecha_fin"));
		c.setFechaInicio(rs.getDate("fecha_inicio"));
		c.setId(rs.getInt("id"));
		c.setResponsable(rs.getString("responsable"));
		return c;
	}

}
