package ar.com.itr.cestointeligente.mapper.view;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.view.GenericView;

public class GenericViewRowMapper implements RowMapper<GenericView> {

	@Override
	public GenericView mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		GenericView c = new GenericView();
		c.setId(rs.getInt("ID"));
		
		return c;
	}

}
