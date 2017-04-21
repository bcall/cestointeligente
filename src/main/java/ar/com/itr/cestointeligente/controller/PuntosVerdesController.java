package ar.com.itr.cestointeligente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.com.itr.cestointeligente.DAO.IslaDAO;

@Controller
public class PuntosVerdesController extends ControllersCore{
	private static final long serialVersionUID = -4165363534136560040L;
	
	@Autowired
	private IslaDAO islaPosicion;
		
	@RequestMapping(value = "/sections/puntos-verdes", method = RequestMethod.GET)
	public String viewEst(Model model){
		logger.info("SECCIONES - Ingresando a Puntos Verdes");
			
		return "sections/puntos-verdes";
	}
	
	@RequestMapping(value = "/sections/punto-verde", method = RequestMethod.GET)
	public String viewNewPuntoVerde(Model model){
		logger.info("SECCIONES - Ingresando a Punto Verde");		
		model.addAttribute("posicion", this.islaPosicion.getAllIslaPosicion());
			
		return "sections/punto-verde";
	}
	
}
