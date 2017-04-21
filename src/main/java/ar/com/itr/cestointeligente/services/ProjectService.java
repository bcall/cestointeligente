package ar.com.itr.cestointeligente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.itr.cestointeligente.DAO.ProjectDAO;
import ar.com.itr.cestointeligente.entities.Project;

@RestController
@RequestMapping(value = "/services")
public class ProjectService {
	@Autowired
	ProjectDAO prjDAO;
	
	@RequestMapping(value = "/projectTableData", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Project> getProjectByEst(@RequestParam(value="idest") int idest){
		
		List<Project> data = prjDAO.getAllProyectsByEst(idest);
		
		return data;
	}
}
