package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.ConcursoDeposito;

public class ConcursoDepositoRowMapper implements RowMapper<ConcursoDeposito> {

	@Override
	public ConcursoDeposito mapRow(ResultSet rs, int index) throws SQLException {
		ConcursoDeposito deposito = new ConcursoDeposito();
		deposito.setConcursoId(rs.getInt("concurso_id"));
		deposito.setId(rs.getInt("id"));
		deposito.setUsuarioId(rs.getInt("usuario_id"));
		deposito.setFecha(rs.getDate("fecha"));
		deposito.setIslaId(rs.getInt("isla_id"));
		deposito.setPeso(rs.getDouble("peso"));
		deposito.setPuntos(rs.getInt("puntos"));
		deposito.setTipoResiduoId(rs.getInt("tipo_residuo_id"));
		
		return deposito;
	}

}
