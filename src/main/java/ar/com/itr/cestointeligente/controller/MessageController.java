package ar.com.itr.cestointeligente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.com.itr.cestointeligente.DAO.MessageDAO;
import ar.com.itr.cestointeligente.DAOImpl.CestoDAOImp;
import ar.com.itr.cestointeligente.entities.Cesto;

@Controller
public class MessageController extends ControllersCore{
	private static final long serialVersionUID = -2514961821049900624L;

	@Autowired
	MessageDAO messageDAO;
	@Autowired
	CestoDAOImp cestDAO;

	@RequestMapping(value = "/sections/message", method = RequestMethod.GET)
	public String viewMessages( Model model){
		List<Cesto> listComp = cestDAO.getAllCestos();
		model.addAttribute("cestos", listComp);
		logger.info("SECCIONES - Ingresando a Seccion de mensajes");
		return "sections/message";
	}

}
