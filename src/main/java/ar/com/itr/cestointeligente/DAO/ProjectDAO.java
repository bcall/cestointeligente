package ar.com.itr.cestointeligente.DAO;

import java.util.List;

import ar.com.itr.cestointeligente.entities.Project;

public interface ProjectDAO {

	public Project getProyectByCompId(int id);
	public Project getProyectById(int id);
	public List<Project> getAllActiveProyects();
	public List<Project> getAllProyectsByEst(int id);
	public boolean cancelProject(int id);
}
