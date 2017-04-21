package ar.com.itr.cestointeligente.DAO;

import java.util.List;

import ar.com.itr.cestointeligente.entities.Message;
import ar.com.itr.cestointeligente.entities.view.MessageView;

public interface  MessageDAO {

	public boolean insertMessage(int compostera_id,Double peso, int evento);
	public List<Message> getCompMsgs(int compostera_id);
	public void getCompMsgsDate(int compostera_id, String fecha);
	public List<Message> getTodayMsgs(int compostera_id);
	public List<MessageView> getAllMsgs();
	
}
