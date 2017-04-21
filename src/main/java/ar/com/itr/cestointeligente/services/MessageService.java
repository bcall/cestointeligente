package ar.com.itr.cestointeligente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.itr.cestointeligente.DAOImpl.MessageDaoImp;
import ar.com.itr.cestointeligente.controller.ControllersCore;
import ar.com.itr.cestointeligente.entities.view.MessageView;

@RestController
@RequestMapping(value = "/services")
public class MessageService extends ControllersCore{
	private static final long serialVersionUID = 2643921610819919546L;
	@Autowired
	MessageDaoImp msgDAO;

	@RequestMapping(value = "/createMsg", method = RequestMethod.GET)
	public String insertMessage(@RequestParam(value = "cid") int compostera_id,
			@RequestParam(value = "w") Double peso,
			@RequestParam(value = "ev") int evento) {
		logger.info("SERVICE - Mensaje recibido");
		peso = peso/1000;
		return (msgDAO.insertMessage(compostera_id, peso, evento)) ? "insertado"
				: "error";
	}
	
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public List<MessageView> getMessage() {
		logger.info("SERVICE - obtenieno mensajes");
        List<MessageView> data = msgDAO.getAllMsgs();
		return data;
	}
	
	@RequestMapping(value = "/messagesbycesto", method = RequestMethod.GET)
	public List<MessageView> getMessageByCesto(@RequestParam(value = "cestoId") int cestoId) {
		logger.info("SERVICE - obtenieno mensajes");
        List<MessageView> data = msgDAO.getCestoMsgs(cestoId);
		return data;
	}
	
	@RequestMapping(value = "/messagesfilter", method = RequestMethod.GET)
	public List<MessageView> messagesfilter(@RequestParam(value = "cestoId") int cestoId,
			                             @RequestParam(value = "fromperiod") String fromperiod,
			                             @RequestParam(value = "toperiod") String toperiod) {
		
		logger.info("SERVICE - obtenieno mensajes");
        List<MessageView> data = msgDAO.getFilterMsgs(cestoId, fromperiod, toperiod);
		return data;
	}
}
