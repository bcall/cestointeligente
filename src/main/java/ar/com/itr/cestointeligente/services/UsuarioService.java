package ar.com.itr.cestointeligente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.itr.cestointeligente.DAO.UsuarioDAO;
import ar.com.itr.cestointeligente.entities.Usuario;
import ar.com.itr.cestointeligente.entities.UsuarioTotem;

@RestController
@RequestMapping(value = "/services")
public class UsuarioService {
	@Autowired
	UsuarioDAO usuDAO;
	@RequestMapping(value = "/usuarioTableData", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Usuario> getRanking(){
		
		List<Usuario> data = usuDAO.listaUsuarios();		
		
		return data;
	}
	
	@RequestMapping(value = "/loginqr", method = RequestMethod.GET,headers="Accept=application/json")
	public UsuarioTotem login(@RequestParam(value="qrCode") String qrCode) {

			UsuarioTotem data=usuDAO.getByCodeqr(qrCode);
	
		     return data;
	}
}
