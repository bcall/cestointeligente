package ar.com.itr.cestointeligente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.itr.cestointeligente.DAOImpl.ActivityDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.CestoDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.EstablecimientoDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.IslaDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.ProjectDAOImp;
import ar.com.itr.cestointeligente.entities.Isla;
import ar.com.itr.cestointeligente.entities.ProjActivity;
import ar.com.itr.cestointeligente.entities.Project;

@Controller
public class ProjectController extends ControllersCore{
	
	private static final long serialVersionUID = 8111960091609000482L;
	@Autowired
	CestoDAOImp compDAO;
	@Autowired
	EstablecimientoDAOImp estDAO;
	@Autowired
	ProjectDAOImp proyDAO;
	@Autowired
	ActivityDAOImp actDAO;
	@Autowired
	IslaDAOImp islaDAO;
	
	@RequestMapping(value = "/sections/proyecto", method = RequestMethod.GET)
	public String viewEst(@RequestParam(value = "id",required = true) Integer id, Model model) {
		logger.info("SECCIONES - Ingresando a Proyecto");
		Project proyect = null;
		
		proyect = proyDAO.getProyectById(id);

		List<ProjActivity> activities = actDAO.getProjActByProj(id);
		for (ProjActivity act : activities) {
			act.setActDet(actDAO.getProjActDet(act.getID()));
			act.setAct(actDAO.getActivityById(act.getACT_ID()));
		}
		if (proyect != null) {
			List<Isla> islas = this.islaDAO.getAllIslaByProject(proyect.getID());
			model.addAttribute("islas", islas);
			model.addAttribute("comp", compDAO.getCestoByID(proyect.getCOMP_ID()));
			model.addAttribute("estab", estDAO.getEstByID(proyect.getESTAB_ID()));
			if (proyect.getDAYS_LEFT() < 0) {
				model.addAttribute("project_expired", Boolean.TRUE);
			} else {
				model.addAttribute("project_expired", Boolean.FALSE);
			}
		}		
		
		model.addAttribute("proyect", proyect);		
		model.addAttribute("activities", activities);
		
		
		return "sections/proyecto";
	}
	
	@RequestMapping(value = "/sections/proyecto", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean cancel(@RequestParam(value = "id",required = false) Integer id, Model model) {
		logger.info("SECCIONES - Ingresando a cancelar proyecto");
		boolean isCancel = false;
		if(id != null){
			isCancel = this.proyDAO.cancelProject(id);
		}
		return isCancel;
	}
}
