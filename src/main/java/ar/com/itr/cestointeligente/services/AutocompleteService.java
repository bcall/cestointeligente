package ar.com.itr.cestointeligente.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.itr.cestointeligente.DAOImpl.ActivityDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.CestoDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.EstablecimientoDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.ProjectDAOImp;
import ar.com.itr.cestointeligente.controller.ControllersCore;
import ar.com.itr.cestointeligente.entities.Activity;
import ar.com.itr.cestointeligente.entities.AutocompleteJSON;
import ar.com.itr.cestointeligente.entities.Establecimiento;
import ar.com.itr.cestointeligente.entities.Project;

@RestController
@RequestMapping(value = "/services")
public class AutocompleteService extends ControllersCore {
	private static final long serialVersionUID = 3975849488503207878L;
	@Autowired
	EstablecimientoDAOImp estDAO;
	@Autowired
	CestoDAOImp compDAO;
	@Autowired
	ProjectDAOImp proyDAO;
	@Autowired
	ActivityDAOImp actDAO;
	
	@RequestMapping(value = "/allEstAutocomplete", method = RequestMethod.GET,headers="Accept=application/json")
	public List<AutocompleteJSON> estAutocomplete(@RequestParam(value = "q") String query) {
		logger.info("SERVICE - Establecimientos solicitados");
		List<AutocompleteJSON> data = new ArrayList<AutocompleteJSON>();
		List<Establecimiento> est = estDAO.getAllEst();
		for (Establecimiento e : est) {
			data.add(new AutocompleteJSON(e.getNAME(),e.getID()+""));
		}
		return data;
	}
	@RequestMapping(value = "/allProyAutocomplete", method = RequestMethod.GET,headers="Accept=application/json")
	public List<AutocompleteJSON> proyAutocomplete(@RequestParam(value = "q") String query) {
		List<AutocompleteJSON> data = new ArrayList<AutocompleteJSON>();
		List<Project> proy = proyDAO.getAllActiveProyects();
		for (Project p : proy) {
			data.add(new AutocompleteJSON(p.getEST_NAME(),p.getID()+""));
		}
		return data;
	}
	@RequestMapping(value = "/allCompAutocomplete", method = RequestMethod.GET,headers="Accept=application/json")
	public List<AutocompleteJSON> compAutocomplete(@RequestParam(value = "q") String query) {
		List<AutocompleteJSON> data = new ArrayList<AutocompleteJSON>();
		List<Project> proy = proyDAO.getAllActiveProyects();
		for (Project p : proy) {
			data.add(new AutocompleteJSON(p.getEST_NAME() ,p.getCOMP_ID()+""));
		}
		return data;
	}
	@RequestMapping(value = "/allActAutocomplete", method = RequestMethod.GET,headers="Accept=application/json")
	public List<AutocompleteJSON> actAutocomplete(@RequestParam(value = "q") String query) {
		List<AutocompleteJSON> data = new ArrayList<AutocompleteJSON>();
		List<Activity> act = actDAO.getAllActivities();
		for (Activity a : act) {
			data.add(new AutocompleteJSON(a.getIDENTIFIER(),""+a.getID()));
		}
		return data;
	}
}
