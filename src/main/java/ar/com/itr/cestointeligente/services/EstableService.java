package ar.com.itr.cestointeligente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.itr.cestointeligente.DAO.EstablecimientoDAO;
import ar.com.itr.cestointeligente.DAOImpl.StatsDAOImp;
import ar.com.itr.cestointeligente.entities.Establecimiento;

@RestController
@RequestMapping(value = "/services")
public class EstableService {
	@Autowired
	StatsDAOImp stsDAO;
	@Autowired
	EstablecimientoDAO estDAO;
	@RequestMapping(value = "/establecimientoTableData", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Establecimiento> getRanking(){
		
		List<Establecimiento> data = estDAO.getAllEst();
		
		
		return data;
	}
}
