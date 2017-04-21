package ar.com.itr.cestointeligente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.itr.cestointeligente.DAO.ConcursoDAO;
import ar.com.itr.cestointeligente.entities.Concurso;

@RestController
@RequestMapping(value = "/services")
public class ConcursoService {
	@Autowired
	ConcursoDAO concursoDAO;
	@RequestMapping(value = "/concursoTableData", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Concurso> getRanking(){
		
		List<Concurso> data = concursoDAO.listaConcurso();	
		
		return data;
	}
}
