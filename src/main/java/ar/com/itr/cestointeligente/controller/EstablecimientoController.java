package ar.com.itr.cestointeligente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.itr.cestointeligente.DAOImpl.EstablecimientoDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.ProjectDAOImp;
import ar.com.itr.cestointeligente.entities.Establecimiento;
@Controller
public class EstablecimientoController extends ControllersCore{
	private static final long serialVersionUID = -2514961821049900624L;
	@Autowired
	EstablecimientoDAOImp estDAO;
	@Autowired
	ProjectDAOImp proyDAO;
	
	@RequestMapping(value = "/sections/establecimiento", method = RequestMethod.GET)
	public String viewEst(@RequestParam(value = "id", required=false) Integer estId,Model model){
		logger.info("SECCIONES - Ingresando a Establecimiento");
		Establecimiento est = null;
		List<Establecimiento> lista = estDAO.getAllEst();
		if(estId == null){
			est = lista.get(0);
			estId = est.getID();
		}else{
			est = estDAO.getEstByID(estId);
		}

		int pos = getEstPos(lista,est);
		int prev = (pos == 0)?lista.get(lista.size()-1).getID():lista.get(pos-1).getID();
		int next = (pos+1 == lista.size())?lista.get(0).getID():lista.get(pos+1).getID();
		
		
		est.setPROYECTS(proyDAO.getAllProyectsByEst(estId));
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		model.addAttribute("est", est);		
		return "sections/establecimiento";
	}
	
	@RequestMapping(value = "/sections/establecimientodetails", method = RequestMethod.GET)
	public String viewEstDetails(@RequestParam(value = "id", required=true) Integer estId,Model model){
		logger.info("SECCIONES - Ingresando a Establecimiento");
		Establecimiento est = null;
		List<Establecimiento> lista = estDAO.getAllEst();
		if(estId == null){
			est = lista.get(0);
			estId = est.getID();
		}else{
			est = estDAO.getEstByID(estId);
		}

		int pos = getEstPos(lista,est);
		int prev = (pos == 0)?lista.get(lista.size()-1).getID():lista.get(pos-1).getID();
		int next = (pos+1 == lista.size())?lista.get(0).getID():lista.get(pos+1).getID();
		
		
		est.setPROYECTS(proyDAO.getAllProyectsByEst(estId));
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		model.addAttribute("est", est);		
		return "details/establecimiento";
	}
	public int getEstPos(List<Establecimiento> est,Establecimiento item){
		int pos=0;
		for(int i = 0;i<est.size();i++){
			if(est.get(i).getID() == item.getID()){
				pos = i;
				break;
			}
		}
		return pos;
	}
}
