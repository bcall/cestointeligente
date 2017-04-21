package ar.com.itr.cestointeligente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.itr.cestointeligente.DAO.IslaDAO;
import ar.com.itr.cestointeligente.entities.view.IslaView;
@Controller
public class IslaController extends ControllersCore{
	private static final long serialVersionUID = -2514961821049900624L;

	@Autowired
	IslaDAO islDAO;

	@RequestMapping(value = "/sections/isladetails", method = RequestMethod.GET)
	public String viewIslaDetails(@RequestParam(value = "projectId", required=true) int projectId,
			                      @RequestParam(value = "locationId", required=true) int locationId,Model model){
		logger.info("SECCIONES - Ingresando a Islas");
		IslaView isla = null;
		isla = islDAO.getIslaByProjectToView(projectId, locationId);
	    model.addAttribute("isla", isla);		
		return "details/isla";
	}

}
