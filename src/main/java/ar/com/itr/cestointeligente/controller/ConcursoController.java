package ar.com.itr.cestointeligente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.itr.cestointeligente.DAOImpl.ConcursoDAOImp;
import ar.com.itr.cestointeligente.entities.Concurso;
import ar.com.itr.cestointeligente.utils.PasswordUtils;
@Controller
public class ConcursoController extends ControllersCore{
	private static final long serialVersionUID = -2514961821049900624L;
	@Autowired
	ConcursoDAOImp concursoDAO;

	
	@RequestMapping(value = "/sections/concurso", method = RequestMethod.GET)
	public String viewConcursos(Model model){
		logger.info("SECCIONES - Ingresando a Usuario");
		List<Concurso> listaConcursos = concursoDAO.listaConcurso();
	
    	model.addAttribute("listaConcursos", listaConcursos);		
		return "sections/concurso";
	}
	
	@RequestMapping(value = "/sections/crearconcurso", method = RequestMethod.POST)
	public String createUser(@RequestParam(value = "nombre", required=true) String nombre,
			Model model){
	
	  	return "sections/concurso";
	}
	
	@RequestMapping(value = "/sections/modificarconcurso", method = RequestMethod.POST)
	public String modificarUser(@RequestParam(value = "id", required=true) int id,
			                 @RequestParam(value = "nombre", required=true) String nombre,
                             @RequestParam(value = "apellido", required=true) String apellido,
                             @RequestParam(value = "telefono", required=true) String telefono,
                             @RequestParam(value = "password", required=true) String password,Model model){
	
//		concursoDAO.update(id,nombre, password, apellido, telefono,"" , 1);
	  	return "sections/usuario";
	}
	
	@RequestMapping(value = "/sections/borrarconcurso", method = RequestMethod.GET)
	public String borrarUser(@RequestParam(value = "id", required=true) int id){
	
		concursoDAO.delete(id);
	  	return "sections/usuario";
	}
	
	@RequestMapping(value = "/sections/nuevoconcurso", method = RequestMethod.GET)
	public String nuevoUsuario(Model model){

	  	return "sections/concursoCrear";
	}
	
	@RequestMapping(value = "/sections/obtenerconcurso", method = RequestMethod.GET)
	public String obtenerUser(@RequestParam(value = "codigo", required=true) String codigo,Model model){
	
	    Concurso concurso= concursoDAO.getByCodigo(codigo);
	    model.addAttribute("concurso", concurso);
	  	return "details/concurso";
	}
	
}
