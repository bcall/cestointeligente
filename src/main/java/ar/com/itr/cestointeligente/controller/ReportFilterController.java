package ar.com.itr.cestointeligente.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.itr.cestointeligente.DAOImpl.EstablecimientoDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.IslaDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.ProjectDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.TipoResiduoDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.utils.TipoCorriente;
import ar.com.itr.cestointeligente.entities.Establecimiento;
import ar.com.itr.cestointeligente.entities.Isla;
import ar.com.itr.cestointeligente.entities.Project;
import ar.com.itr.cestointeligente.entities.TipoResiduo;

@Controller
@RequestMapping(value="/reporte")
public class ReportFilterController extends ControllersCore {

	/**
	 * The serial version
	 */
	private static final long serialVersionUID = -2562012883757646115L;
	
	@Autowired
	private EstablecimientoDAOImp establecimientoDAO;
	@Autowired
	private ProjectDAOImp proyectoDAO;
	@Autowired
	private IslaDAOImp islaDAO;
	@Autowired
	private TipoResiduoDAOImp tipoResiduoDAO;
	
	@RequestMapping(value = "/establecimiento", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getEstablecimientos() {
		logger.info("Reporte - Se obtienen los establecimientos");
		List<Establecimiento> lista = this.establecimientoDAO.getAllEst();
		Map<String,Object> map = new HashMap<String, Object>(); 
		map.put("establecimientos", lista);
	      
	    return map; 		
	}
	
	@RequestMapping(value = "/proyecto", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getProyectos(@RequestParam(value="establecimiento_id") int establecimientoID) {
		logger.info("Reporte - Se obtienen los proyectos");
		List<Project> lista = this.proyectoDAO.getAllProyectsByEst(establecimientoID);
		Map<String,Object> map = new HashMap<String, Object>(); 
		map.put("proyectos", lista);
	      
	    return map; 		
	}
	
	@RequestMapping(value = "/isla", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getIslas(@RequestParam(value="proyecto_id") int proyectoID) {
		logger.info("Reporte - Se obtienen las islas");
		List<Isla> lista = this.islaDAO.getAllIslaByProject(proyectoID);
		Map<String,Object> map = new HashMap<String, Object>(); 
		map.put("islas", lista);
	      
	    return map; 		
	}
	
	@RequestMapping(value = "/corriente_residuo", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getCorrientesResiduos() {
		logger.info("Reporte - Se obtienen las corrientes residuos");
		List<TipoCorriente> lista = Arrays.asList(TipoCorriente.NORECICLABLES, TipoCorriente.RECICLABLES);
		Map<String,Object> map = new HashMap<String, Object>(); 
		map.put("tipo_corrientes", lista);
	      
	    return map; 		
	}
	
	@RequestMapping(value = "/tipo_residuo", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getTiposResiduos(@RequestParam(value="isla_id") int islaID) {
		logger.info("Reporte - Se obtienen los tipos de residuos");
		List<TipoResiduo> lista = this.tipoResiduoDAO.getAllTipoResiduoBy(islaID);
		Map<String,Object> map = new HashMap<String, Object>(); 
		map.put("tipo_residuos", lista);
	      
	    return map; 		
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showFilter(ModelMap model) {
		model.addAttribute("establecimientos", this.establecimientoDAO.getAllEst());
        return "sections/reporte";
    }

}
