package ar.com.itr.cestointeligente.mapper.view;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.itr.cestointeligente.entities.view.MessageView;


public class MessageViewRowMapper implements RowMapper<MessageView> {

    @Override
	public MessageView mapRow(ResultSet rs, int index) throws SQLException {
		MessageView msg = new MessageView();
		msg.setmensajeId(rs.getInt("ID"));
		msg.setcomposteraId(rs.getInt("COMPOST_ID"));
		msg.setEvento(rs.getString("MESSAGE"));
		msg.setFecha(rs.getTimestamp("DATE").toString());
		msg.setPeso(rs.getDouble("PESO"));
		return msg;
	}

}
