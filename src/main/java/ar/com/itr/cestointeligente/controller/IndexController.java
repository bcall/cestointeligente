package ar.com.itr.cestointeligente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.com.itr.cestointeligente.DAO.CestoDAO;
import ar.com.itr.cestointeligente.DAO.EstablecimientoDAO;
import ar.com.itr.cestointeligente.DAO.ProjectDAO;
import ar.com.itr.cestointeligente.DAO.StatsDAO;
import ar.com.itr.cestointeligente.DAOImpl.EstablecimientoDAOImp;
import ar.com.itr.cestointeligente.entities.Establecimiento;

@Controller
public class IndexController extends ControllersCore{
	private static final long serialVersionUID = -8047768995255906188L;
	@Autowired
	EstablecimientoDAO estDAO;
	@Autowired
	StatsDAO stsDAO;
	@Autowired
	ProjectDAO proyDAO;
	@Autowired
	CestoDAO cestoDAO;
	@Autowired
	private EstablecimientoDAOImp establecimientoDAO;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		logger.info("SECCIONES - Ingresando a Index");
		List<Establecimiento> est = estDAO.getAllEst();
		String listItems = "";
		
		int cestosNoVivos= cestoDAO.getCountNotAliveCesto();
		model.addAttribute("countCestosNotAlive", cestosNoVivos);
		model.addAllAttributes(stsDAO.getIndexStats());
		for (int i = 0; i < est.size(); i++) {
			listItems = listItems + "<a id=\"est_item_"+i+"\" style=\"width: 240px;\" class=\"list-group-item\">"+est.get(i).getNAME()+"</a>"
					+ "<input type=\"hidden\" id=\"est_item_"+i+"_hidden\" value=\""+est.get(i).getLAT()+"@"+est.get(i).getLONG()+"@"+est.get(i).getID()+"@"+est.get(i).getCALLE()+" N°"+est.get(i).getNUM()+"@"+est.get(i).getCOMP()+"\">";
		}
		model.addAttribute("listItems", listItems);
		model.addAttribute("estItems", est);
		model.addAttribute("establecimientos", this.establecimientoDAO.getAllEst());
		return "index";
	}	
}
