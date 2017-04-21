package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.Isla;

public class IslaRowMapper implements RowMapper<Isla> {

	@Override
	public Isla mapRow(ResultSet rs, int index) throws SQLException {
		Isla isla = new Isla();
		isla.setCORRIENTE_RESIDUO_NAME(rs.getString("CORRIENTE_RESIDUO_NAME"));
		isla.setGR_U_DAY_PROY(rs.getInt("gR_U_DAY_PROY"));
		isla.setINPUT_DAY_PROY(rs.getInt("iNPUT_DAY_PROY"));		
		isla.setGR_DAY_PROY(isla.getGR_U_DAY_PROY() * isla.getINPUT_DAY_PROY());
		isla.setISLA_POSICION(rs.getString("ISLA_POSICION"));
		isla.setHINPUT(rs.getDouble("H_INPUT"));
		isla.setHOUTPUT(rs.getDouble("H_OUTPUT"));
		isla.setLASTW(rs.getDouble("LAST_W"));	
		isla.setID(rs.getInt("ID"));
		
		return isla;
	}

}
