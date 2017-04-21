package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.ProjActivity;

public class ProjActRowMapper implements RowMapper<ProjActivity> {

	@Override
	public ProjActivity mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProjActivity pa = new ProjActivity();
		pa.setACT_ID(rs.getInt("ACT_ID"));
		pa.setIDENTIFIER(rs.getString("IDENTIFIER"));
		pa.setID(rs.getInt("ID"));
		pa.setOBJ_C_IN(rs.getDouble("OBJ_C_IN"));
		pa.setOBJ_C_OUT(rs.getInt("OBJ_C_OUT"));
		pa.setOBJ_INPUT(rs.getDouble("OBJ_INPUT"));
		pa.setOBJ_OUT(rs.getInt("OBJ_OUT"));
		pa.setOBS(rs.getString("OBS"));
		pa.setPROJ_ID(rs.getInt("PROJ_ID"));
		return pa;
	}

}
