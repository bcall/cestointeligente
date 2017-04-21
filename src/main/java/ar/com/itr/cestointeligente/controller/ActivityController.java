package ar.com.itr.cestointeligente.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.itr.cestointeligente.DAOImpl.ActivityDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.EstablecimientoDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.StatsDAOImp;
import ar.com.itr.cestointeligente.entities.Activity;
import ar.com.itr.cestointeligente.entities.Establecimiento;
@Controller
public class ActivityController extends ControllersCore {
	private static final long serialVersionUID = -5398618380214670137L;

	@Autowired
	StatsDAOImp stsDAO;
	@Autowired
	ActivityDAOImp actDAO;
	@Autowired
	EstablecimientoDAOImp estDAO;
	
	@RequestMapping(value = "/sections/actividades", method = RequestMethod.GET)
	public String viewEst(@RequestParam(value = "id", required=false) Integer id,Model model) {
		logger.info("SECCIONES - Ingresando a Actividades");
		List<Map<String, Object>> data = null;
		List<Establecimiento> est = null;
		Activity act = null;
		String estItems = "";
		if(id == null){
			id = actDAO.getAllActivities().get(0).getID();
			data = stsDAO.getActivityTable(id);
			est = estDAO.getAllEstByAct(id);
			act = actDAO.getActivityById(id);
		}else{
			data = stsDAO.getActivityTable(id);
			est = estDAO.getAllEstByAct(id);
			act = actDAO.getActivityById(id);
		}
		
		
		for (int i = 0; i < est.size(); i++) {
			estItems = estItems + "<input type=\"hidden\" class=\"est\" id=\"est_item_"+i+"\" value=\""+est.get(i).getLAT()+"@"+est.get(i).getLONG()+"@"+est.get(i).getID()+"@"+est.get(i).getCALLE()+" N°"+est.get(i).getNUM()+"\">";
		}
		model.addAttribute("activity", act);
		model.addAttribute("estItems", estItems);
		model.addAttribute("tableData", data);
		return "sections/actividades";
	}
}
