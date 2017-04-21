package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.Establecimiento;

public class EstablecimientoRowMapper implements RowMapper<Establecimiento>{

	@Override
	public Establecimiento mapRow(ResultSet rs, int index) throws SQLException {
		Establecimiento e = new Establecimiento();	
		e.setID(rs.getInt("ID"));
		e.setID_NIVEL(rs.getInt("ID_NIVEL"));
		e.setID_DISTRITO(rs.getInt("ID_DISTRITO"));
		e.setID_CGP(rs.getInt("ID_CGP"));
		e.setNAME(rs.getString("NAME"));
		e.setCALLE(rs.getString("CALLE"));
		e.setNUM(rs.getString("NUM"));
		e.setLAT(rs.getString("LAT"));
		e.setLONG(rs.getString("LONG"));
		e.setCP(rs.getString("CP"));
		e.setHORARIO(rs.getString("HORARIO"));
		if((Integer)rs.getInt("COMP")!=null){
			e.setCOMP(rs.getInt("COMP"));
		}
		return e;
	}

	
}
