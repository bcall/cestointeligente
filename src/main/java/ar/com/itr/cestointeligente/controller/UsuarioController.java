package ar.com.itr.cestointeligente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.itr.cestointeligente.DAOImpl.UsuarioDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.utils.GenerateQRCode;
import ar.com.itr.cestointeligente.entities.Usuario;
import ar.com.itr.cestointeligente.utils.PasswordUtils;
@Controller
public class UsuarioController extends ControllersCore{
	private static final long serialVersionUID = -2514961821049900624L;
	@Autowired
	UsuarioDAOImp usuDAO;

	
	@RequestMapping(value = "/sections/usuario", method = RequestMethod.GET)
	public String viewUsuarios(Model model){
		logger.info("SECCIONES - Ingresando a Usuario");
		List<Usuario> listaUsuarios = usuDAO.listaUsuarios();
	
    	model.addAttribute("listaUsuarios", listaUsuarios);		
		return "sections/usuario";
	}
	
	@RequestMapping(value = "/sections/crearusuario", method = RequestMethod.POST)
	public String createUser(@RequestParam(value = "nombre", required=true) String nombre,
                             @RequestParam(value = "apellido", required=true) String apellido,
                             @RequestParam(value = "telefono", required=true) String telefono,
                             @RequestParam(value = "password", required=true) String password,
                             @RequestParam(value = "email", required=true) String email,Model model){
	
		String codigoqr=PasswordUtils.encriptar(apellido+telefono+nombre);
		usuDAO.create(nombre, PasswordUtils.encriptar(password), apellido, telefono,nombre+"."+apellido,1,codigoqr, email);
	    Usuario usuario=usuDAO.getByNombreUsuario(nombre+"."+apellido);
	    GenerateQRCode.createQR(codigoqr,usuario.getId());
	    return "sections/usuario";
	}
	
	@RequestMapping(value = "/sections/modificarusuario", method = RequestMethod.POST)
	public String modificarUser(@RequestParam(value = "id", required=true) int id,
			                 @RequestParam(value = "nombre", required=true) String nombre,
                             @RequestParam(value = "apellido", required=true) String apellido,
                             @RequestParam(value = "telefono", required=true) String telefono,
                             @RequestParam(value = "password", required=true) String password,Model model){
	
	    usuDAO.update(id,nombre, password, apellido, telefono,"" , 1);
	  	return "sections/usuario";
	}
	
	@RequestMapping(value = "/sections/borrarusuario", method = RequestMethod.GET)
	public String borrarUser(@RequestParam(value = "id", required=true) int id){
	
	    usuDAO.delete(id);
	  	return "sections/usuario";
	}
	
	@RequestMapping(value = "/sections/nuevousuario", method = RequestMethod.GET)
	public String nuevoUsuario(Model model){

	  	return "sections/usuarioCrear";
	}
	
	@RequestMapping(value = "/sections/obtenerusuario", method = RequestMethod.GET)
	public String obtenerUser(@RequestParam(value = "id", required=true) int id,Model model){
	
	    Usuario user= usuDAO.getById(id);
	    model.addAttribute("usuario", user);
	  	return "sections/usuarioModificar";
	}

}
