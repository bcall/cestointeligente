package ar.com.itr.cestointeligente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.itr.cestointeligente.DAO.IslaDAO;
import ar.com.itr.cestointeligente.entities.IslaUbicacion;
import ar.com.itr.cestointeligente.entities.view.IslaView;
import ar.com.itr.cestointeligente.entities.Isla;

@RestController
@RequestMapping(value = "/services")
public class IslaService {
	@Autowired
	IslaDAO islaDAO;
	
	@RequestMapping(value = "/islaTableData", method = RequestMethod.GET,headers="Accept=application/json")
	public List<IslaView> getProjectByEst(@RequestParam(value="idpro") int idpro){
		
		List<IslaView> data = islaDAO.getAllIslaByProjectToView(idpro);
		
		return data;
	}
	
	@RequestMapping(value = "/puntosverdesubicacionescercanas", method = RequestMethod.GET,headers="Accept=application/json")
	public List<IslaUbicacion> getPuntosVerdesByUbicacion(@RequestParam(value="lon") String lon,
			                                         @RequestParam(value="lat") String lat){
		
		List<IslaUbicacion> data = islaDAO.getAllIslaByPosicion(lon, lat);
		return data;
	}
	@RequestMapping(value = "/islas", method = RequestMethod.GET, headers = "Accept=application/json")
		public List<Isla> getAllIslas() {
			List<Isla> data = this.islaDAO.getAllIsla();
	
			return data;

	}
}
