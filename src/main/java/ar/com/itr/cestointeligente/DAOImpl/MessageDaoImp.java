package ar.com.itr.cestointeligente.DAOImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.itr.cestointeligente.DAO.MessageDAO;
import ar.com.itr.cestointeligente.entities.Message;
import ar.com.itr.cestointeligente.entities.view.MessageView;
import ar.com.itr.cestointeligente.mapper.MessageRowMapper;
import ar.com.itr.cestointeligente.mapper.view.MessageViewRowMapper;

public class MessageDaoImp extends GenericDAOImp implements MessageDAO {

	public boolean insertMessage(int compostera_id, Double peso, int evento) {
		String sql = "CALL insertMessage(:c_id,NOW(),:peso,:ev);";
		logger.info("DAO - Consultando base");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_id", compostera_id);
		params.put("peso", peso);
		params.put("ev", evento);
		try {
			this.getJdbcTemplate().update(sql, params);
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
			return false;
		}

		return true;
	}

	public List<Message> getCompMsgs(int compostera_id) {
		String sql = "SELECT * FROM messages WHERE COMPOST_ID=:id;";
		List<Message> messages = null;
		logger.info("DAO - Consultando base");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", compostera_id);
		try {
			messages = this.getJdbcTemplate().query(sql, new MessageRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return messages;
	}
	
	public List<MessageView> getCestoMsgs(int compostera_id) {
		String sql = "SELECT a.id,a.compost_id,a.date,a.peso,b.message FROM messages a inner join msg_status b on a.event=b.id where a.compost_id=:id;";
		List<MessageView> messages = null;
		logger.info("DAO - Consultando base");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", compostera_id);
		try {
			messages = this.getJdbcTemplate().query(sql,params, new MessageViewRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return messages;
	}

	public void getCompMsgsDate(int compostera_id, String fecha) {

	}
	
	public List<MessageView> getAllMsgs() {
		String sql = "SELECT a.id,a.compost_id,a.date,a.peso,b.message FROM messages a inner join msg_status b on a.event=b.id;";
		List<MessageView> messages = null;
		logger.info("DAO - Consultando base");
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			messages = this.getJdbcTemplate().query(sql, params, new MessageViewRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		} 
		return messages;
	}
	
	public List<MessageView> getFilterMsgs(int cestoId, String fromperiod, String toperiod) {
		String sql;
		if (cestoId==-1){
		    sql = "SELECT a.id,a.compost_id,a.date,a.peso,b.message FROM messages a inner join msg_status b on a.event=b.id where a.date BETWEEN(STR_TO_DATE(:datein, '%d/%m/%Y'))AND(STR_TO_DATE(:dateout, '%d/%m/%Y'));";
		}else{
			sql = "SELECT a.id,a.compost_id,a.date,a.peso,b.message FROM messages a inner join msg_status b on a.event=b.id where a.compost_id=:id and a.date BETWEEN(STR_TO_DATE(:datein, '%d/%m/%Y'))AND(STR_TO_DATE(:dateout, '%d/%m/%Y'));";

		}
		
		List<MessageView> messages = null;
		logger.info("DAO - Consultando base");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", cestoId);
		params.put("datein", fromperiod);
		params.put("dateout", toperiod);
		
		try {
			messages = this.getJdbcTemplate().query(sql, params, new MessageViewRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		} 
		return messages;
	}
	public List<Message> getTodayMsgs(int compostera_id) {
		String sql = "SELECT * FROM messages WHERE COMPOST_ID=:id AND DATE(DATE) = DATE(NOW());";
		List<Message> messages = null;
		logger.info("DAO - Consultando base");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", compostera_id);
		try {
			messages = this.getJdbcTemplate().query(sql, params, new MessageRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		} 
		return messages;
	}

	public List<Message> getTodayAlerts() {
		String sql = "SELECT * FROM messages WHERE DATE(DATE) = DATE(NOW()) ORDER BY DATE DESC limit 5;";
		List<Message> messages = null;
		logger.info("DAO - Consultando base");
		try {
			messages = this.getJdbcTemplate().query(sql, new MessageRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return messages;
	}
}
