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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.itr.cestointeligente.Constants;
import ar.com.itr.cestointeligente.DAOImpl.CestoDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.EstablecimientoDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.MessageDaoImp;
import ar.com.itr.cestointeligente.DAOImpl.ProjectDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.StatsDAOImp;
import ar.com.itr.cestointeligente.entities.Cesto;
import ar.com.itr.cestointeligente.entities.Message;
import ar.com.itr.cestointeligente.entities.Project;
import ar.com.itr.cestointeligente.entities.view.CestoNotAliveView;

@Controller
public class CestoController extends ControllersCore{

	private static final long serialVersionUID = -3554111768362226609L;
	@Autowired
	CestoDAOImp cestDAO;
	@Autowired
	EstablecimientoDAOImp estDAO;
	@Autowired
	ProjectDAOImp proyDAO;
	@Autowired
	MessageDaoImp msgDao;
	@Autowired
	StatsDAOImp stsDao;
	@Autowired
	private Constants constants;
	private DateTimeFormatter df = DateTimeFormat
			.forPattern("yyyy-MM-dd HH:mm:ss.S");

	@RequestMapping(value = "/sections/cesto", method = RequestMethod.GET)
	public String viewEst(@RequestParam(value = "id" , required=false) Integer id, 
			              @RequestParam(value = "status" , required=false) Integer status,Model model) {
		logger.info("SECCIONES - Ingresando a cesto");
		Project proyect = null;
		List<Cesto> listComp = cestDAO.getAllCestos();
		if(id==null){
			List<Project> lista = proyDAO.getAllActiveProyects();
			proyect = lista.get(0);
			id = proyect.getCOMP_ID();
		}else{
			proyect = proyDAO.getProyectByCompId(id);
		}
		List<Message> alerts = msgDao.getTodayMsgs(id);
		String alertContent = "";
		if (alerts.size() != 0) {
			for (int i = 0; i < alerts.size(); i++) {
				alertContent = alertContent + createAlert(alerts.get(i));
			}
		} else {
			alertContent = "<li><a style=\"text-decoration: none;text-align:center;\">"
					+ "<strong>No hay mensajes</strong></a></li>";
		}
		List<Map<String, Object>> nAlive = stsDao.getNotAlive(id,proyect.getDATEFROM());
		List<Map<String, Object>> stats = stsDao.getCompostStats(id,proyect.getDATEFROM());
		
		Cesto cesto=cestDAO.getCestoByID(id);
		if ( null!=status && status==0){
			cesto.setSTATUS("INACTIVO");
		}
		int pos = getCompPos(listComp,id);
		int prev = (pos == 0)?listComp.get(listComp.size()-1).getID():listComp.get(pos-1).getID();
		int next = (pos+1 == listComp.size())?listComp.get(0).getID():listComp.get(pos+1).getID();
		
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		model.addAttribute("nAlive", nAlive);
		model.addAttribute("stats", stats);
		model.addAttribute("compAlert", alertContent);
		model.addAttribute("comp",cesto);
		model.addAttribute("proyect", proyect);
		model.addAttribute("estab", estDAO.getEstByID(proyect.getESTAB_ID()));
		return "sections/cesto";
	}

	@RequestMapping(value = "/cestosNoVivos", method = RequestMethod.GET)
	@ResponseBody
	public List<CestoNotAliveView> getCestosNoVivos(Model model) {
		logger.info("SECCIONES Cestos No Vivos - Ingresando a Index");				
		List<CestoNotAliveView> noVivos= cestDAO.getNotAliveCesto();
		return noVivos;
	}
	
	@RequestMapping(value = "/sections/cestosnovivos", method = RequestMethod.GET)
	public String viewEst(@RequestParam(value = "id", required=false) Integer estId,Model model){
		logger.info("SECCIONES - Ingresando a cestos no vivos");
		return "sections/cestosNoVivos";
	}
	
	public String createAlert(Message msg) {
		DateTime msgDate = df.parseDateTime(msg.getFecha());
		Duration diff = new Duration(msgDate, new Instant());
		String minutes = diff.toStandardMinutes().getMinutes()+"";
		
		return "<li><div class=\"alert " + constants.getMsgColor().get(msg.getEvento())
				+ " navAlert\">" + "<span class=\"chat-img pull-left "
				+ constants.getMsgIcon().get(msg.getEvento()) + "\"></span>"
				+ "<div class=\"chat-body clearfix\">"
				+ "<div class=\"header\">"
				+ "<small class=\"pull-right text-muted\">"
				+ "<i class=\"fa fa-clock-o fa-fw\"></i>"+minutes+" min</small>"
				+ "</div><p>" + constants.getMsgStatus().get(msg.getEvento())
				+ "</p></li>";
	}
	
	public int getCompPos(List<Cesto> comp,int id){
		int pos=0;
		for(int i = 0;i<comp.size();i++){
			if(comp.get(i).getID() == id){
				pos = i;
				break;
			}
		}
		return pos;
	}
}
