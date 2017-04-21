package ar.com.itr.cestointeligente.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.itr.cestointeligente.DAOImpl.StatsDAOImp;
import ar.com.itr.cestointeligente.DAOImpl.utils.IndexGraphQueryCriteria;
import ar.com.itr.cestointeligente.DAOImpl.utils.TipoCorriente;

@RestController
@RequestMapping(value = "/services")
public class GraphicsService {
	@Autowired
	StatsDAOImp stsDAO;

	@RequestMapping(value = "/indexGraph", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<List<Map<String, Object>>> getProyectionGraph(@RequestParam(value="establecimiento_id", required=false) Integer establecimientoId,
			@RequestParam(value="proyecto_id", required=false) Integer proyectoID, @RequestParam(value="isla_id" , required=false) Integer islaID,
			@RequestParam(value="corriente_residuo_id", required=false) Integer corrienteResiduoId,
			@RequestParam(value="tipo_residuo_id", required=false) Integer tipoResiduoId) {
		if (corrienteResiduoId == null || corrienteResiduoId == -1) {
			IndexGraphQueryCriteria filterReciclables = new IndexGraphQueryCriteria(TipoCorriente.RECICLABLES_ID, establecimientoId, proyectoID, islaID, tipoResiduoId);
			IndexGraphQueryCriteria filterNoReciclables = new IndexGraphQueryCriteria(TipoCorriente.NO_RECICLABLES_ID, establecimientoId, proyectoID, islaID, tipoResiduoId);
			return stsDAO.getIndexGraph(filterReciclables, filterNoReciclables);
		} else if (TipoCorriente.NO_RECICLABLES_ID == corrienteResiduoId) {
			IndexGraphQueryCriteria filterNoReciclables = new IndexGraphQueryCriteria(TipoCorriente.NO_RECICLABLES_ID, establecimientoId, proyectoID, islaID, tipoResiduoId);
			return stsDAO.getIndexGraph(null, filterNoReciclables);
		} else {
			IndexGraphQueryCriteria filterReciclables = new IndexGraphQueryCriteria(TipoCorriente.RECICLABLES_ID, establecimientoId, proyectoID, islaID, tipoResiduoId);
			return stsDAO.getIndexGraph(filterReciclables, null);
		}
		
	}
	@RequestMapping(value = "/evolGraph", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<List<Map<String, Object>>> getEvolGraph(int id) {
		return stsDAO.getEvolGraph(id);
	}
	@RequestMapping(value = "/PActGraph", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<List<Map<String, Object>>> getProjActGraph(@RequestParam(value="pId") int pId,@RequestParam(value="aId") int aId) {
		return stsDAO.getProjActGraph(pId, aId);
	}
}
