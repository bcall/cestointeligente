package ar.com.itr.cestointeligente.controller;

import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.com.itr.cestointeligente.Constants;
import ar.com.itr.cestointeligente.DAO.StatsDAO;
import ar.com.itr.cestointeligente.DAOImpl.MessageDaoImp;
import ar.com.itr.cestointeligente.entities.Message;
import ar.com.itr.cestointeligente.entities.Project;

@Controller
public class NavController {
	@Autowired
	MessageDaoImp msgDao;
	@Autowired
	StatsDAO stsDAO;
	@Autowired
	private Constants constants;
	private DateTimeFormatter df = DateTimeFormat
			.forPattern("yyyy-MM-dd HH:mm:ss.S");
	@RequestMapping(value = "includes/nav",method = RequestMethod.GET)
	public String nav(Model model) {

		List<Message> messages = msgDao.getTodayAlerts();
		List<Project> alerts = stsDAO.getWeightAlarms();
		List<Map<String,Object>> proyects = stsDAO.getProyectCompletion();
		
		String messagesContent = "";
		String alertsMessages = "";
		if (messages.size() != 0) {
			for (int i = 0; i < messages.size(); i++) {
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
		model.addAttribute("messages", messagesContent);
		model.addAttribute("alerts", alertsMessages);
		model.addAttribute("proyects", proyects);
		return "includes/nav";
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
