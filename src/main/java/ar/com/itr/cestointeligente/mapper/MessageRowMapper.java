package ar.com.itr.cestointeligente.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.Message;


public class MessageRowMapper implements RowMapper<Message> {

	@Override
	public Message mapRow(ResultSet rs, int index) throws SQLException {
		Message msg = new Message();
		msg.setMensaje_id(rs.getInt("ID"));
		msg.setCompostera_id(rs.getInt("COMPOST_ID"));
		msg.setEvento(rs.getInt("EVENT"));
		msg.setFecha(rs.getTimestamp("DATE").toString());
		msg.setPeso(rs.getDouble("PESO"));
		return msg;
	}

}
