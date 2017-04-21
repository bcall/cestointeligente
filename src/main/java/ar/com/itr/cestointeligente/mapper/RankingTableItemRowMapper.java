package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.RankingTableItem;

public class RankingTableItemRowMapper implements RowMapper<RankingTableItem> {

	@Override
	public RankingTableItem mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		RankingTableItem item = new RankingTableItem();
		item.setID(rs.getInt("ID"));
		item.setNAME(rs.getString("NAME"));
		item.setCGP(rs.getString("CGP"));
		item.setDIST(rs.getString("DIST"));
		item.setNIVEL(rs.getString("NIVEL"));
		item.setDIVISION(rs.getString("DIVISION"));
		item.setTURN(rs.getString("TURN"));
		item.setINPUT(rs.getDouble("INPUT"));
		item.setC_INPUT(rs.getInt("C_INPUT"));
		item.setOUTPUT(rs.getDouble("OUTPUT"));
		item.setC_OUTPUT(rs.getInt("C_OUTPUT"));
		
		return item;
	}

}
