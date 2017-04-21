package ar.com.itr.cestointeligente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.itr.cestointeligente.DAO.CestoDAO;
import ar.com.itr.cestointeligente.entities.view.CestoView;

@RestController
@RequestMapping(value = "/services")
public class CestoService {
	@Autowired
	CestoDAO CestoDAO;
	
	@RequestMapping(value = "/cestoTableData", method = RequestMethod.GET,headers="Accept=application/json")
	public List<CestoView> getProjectByEst(@RequestParam(value="proId") int proId,@RequestParam(value="ubiId") int ubiId){
		
		List<CestoView> data = CestoDAO.getCestoByIslaId(proId, ubiId);
		
		return data;
	}
}
