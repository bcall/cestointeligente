package ar.com.itr.cestointeligente.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.itr.cestointeligente.Constants;
import ar.com.itr.cestointeligente.DAO.StatsDAO;
import ar.com.itr.cestointeligente.DAOImpl.MessageDaoImp;
import ar.com.itr.cestointeligente.controller.ControllersCore;
import ar.com.itr.cestointeligente.entities.Message;
import ar.com.itr.cestointeligente.entities.Project;

@RestController
@RequestMapping(value = "/services")
public class NavAlertsService extends ControllersCore {

	private static final long serialVersionUID = 5739563759273955056L;

	@Autowired
	MessageDaoImp msgDao;
	@Autowired
	StatsDAO stsDAO;
	@Autowired
	private Constants constants;
	private DateTimeFormatter df = DateTimeFormat
			.forPattern("yyyy-MM-dd HH:mm:ss.S");
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/navAlerts", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<String> navAlerts(HttpServletRequest request) {
		logger.info("SERVICE - Actualizando nav");
		
		List<Integer> msgIds = (request.getSession().getAttribute("msgIds")==null)?new ArrayList<Integer>():(ArrayList<Integer>)request.getSession().getAttribute("msgIds");
		
		List<Message> messages = msgDao.getTodayAlerts();
		List<Project> alerts = stsDAO.getWeightAlarms();
		List<String> response = new ArrayList<String>();
		
		String messagesContent = "";
		String alertsMessages = "";
		String showMessageAlert = "N";
		String showAlertsAlert = "N";
		if (messages.size() != 0) {
			for (int i = 0; i < messages.size(); i++) {
				if(!msgIds.contains(messages.get(i).getMensaje_id())){
					msgIds.add(messages.get(i).getMensaje_id());
					showMessageAlert = "Y";
				}
					
				messagesContent = messagesContent + createAlert(messages.get(i));
			}
		} else {
			messagesContent = "<li><a class=\"text-center\" href=\"#\">"
					+ "<strong>No hay mensajes</strong></a></li>";
		}
		if (alerts.size() != 0) {
			for (int i = 0; i < alerts.size(); i++) {
				alertsMessages = alertsMessages + createAlert(alerts.get(i));
			}
		} else {
			alertsMessages = "<li><a class=\"text-center\" href=\"#\">"
					+ "<strong>No hay alertas</strong></a></li>";
		}
		request.getSession().setAttribute("msgIds",msgIds);
		response.add(showMessageAlert);
		response.add(showAlertsAlert);
		response.add(alertsMessages);
		response.add(messagesContent);
		return response;
	}
	public String createAlert(Message msg) {
		DateTime msgDate = df.parseDateTime(msg.getFecha());
		Duration diff = new Duration(msgDate, new Instant());
		String minutes = diff.toStandardMinutes().getMinutes()+"";
		return "<li><div class=\"alert " + constants.getMsgColor().get(msg.getEvento())
				+ " navAlert\"><p><i class=\""
				+ constants.getMsgIcon().get(msg.getEvento()) + "\"></i>"
				+ "   ID: "+msg.getCompostera_id()+" - "+ constants.getMsgStatus().get(msg.getEvento())
				+ "<small class=\"pull-right text-muted\">"
				+ "<i class=\"fa fa-clock-o fa-fw\"></i>"+minutes+" min</small>"
				+ "</p></li><li class=\"divider\"></li></div>";
	}
	public String createAlert(Project msg) {
		return "<li><div class=\"alert alert-danger navAlert\">"
				+"<p>ID: "+msg.getCOMP_ID()+" - Alerta de peso.</p></div></li>"
				+"<li class=\"divider\"></li>";
	}
}
