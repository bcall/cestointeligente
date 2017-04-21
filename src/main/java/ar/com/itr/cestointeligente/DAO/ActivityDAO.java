package ar.com.itr.cestointeligente.DAO;

import java.util.List;
import java.util.Map;

import ar.com.itr.cestointeligente.entities.Activity;
import ar.com.itr.cestointeligente.entities.ProjActivity;

public interface ActivityDAO {
	
	public List<Activity> getAllActivities();
	public Activity getActivityById(int id);
	public List<ProjActivity> getProjActByAct(int id);
	public List<ProjActivity> getProjActByProj(int id);
	public Map<String,Object> getProjActDet(int id);
	
}
