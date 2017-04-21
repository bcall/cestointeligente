package ar.com.itr.cestointeligente.DAOImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.itr.cestointeligente.DAO.ActivityDAO;
import ar.com.itr.cestointeligente.entities.Activity;
import ar.com.itr.cestointeligente.entities.ProjActivity;
import ar.com.itr.cestointeligente.mapper.ActivityRowMapper;
import ar.com.itr.cestointeligente.mapper.ProjActRowMapper;

public class ActivityDAOImp extends GenericDAOImp implements ActivityDAO {

	@Override
	public List<Activity> getAllActivities() {
		String query = "SELECT A.*,AR.DESC AS RES,ACT.DESC AS TYPE FROM activity A LEFT JOIN act_type ACT ON A.TYPE_ID=ACT.ID LEFT JOIN act_res AR ON A.RES_ID=AR.ID;";
		List<Activity> a = null;
		logger.info("DAO - Consultando base");
		try {
			a = this.getJdbcTemplate().query(query, new ActivityRowMapper());
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return a;
	}

	@Override
	public List<ProjActivity> getProjActByAct(int id) {
		String query = "SELECT * FROM proj_act WHERE ACT_ID=:id";
		List<ProjActivity> pa = null;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", new Integer(id));
			pa = this.getJdbcTemplate().query(query,params, new ProjActRowMapper());
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return pa;
	}

	@Override
	public List<ProjActivity> getProjActByProj(int id) {
		String query = "SELECT PA.*,A.IDENTIFIER FROM proj_act PA LEFT JOIN activity A ON PA.ACT_ID=A.ID WHERE PA.PROJ_ID=:id";
		List<ProjActivity> pa = null;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", new Integer(id));
			pa = this.getJdbcTemplate().query(query,params, new ProjActRowMapper());
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return pa;
	}

	@Override
	public Map<String, Object> getProjActDet(int id) {
		String query = "CALL getProjectActValues(:id);";
		Map<String, Object> a = null;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", new Integer(id));
			a = this.getJdbcTemplate().queryForMap(query, params);
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return a;
	}
	@Override
	public Activity getActivityById(int id) {
		String query = "SELECT A.*,AR.DESC AS RES,ACT.DESC AS TYPE FROM activity A LEFT JOIN act_type ACT ON A.TYPE_ID=ACT.ID LEFT JOIN act_res AR ON A.RES_ID=AR.ID WHERE A.ID=:id;";
		Activity a = null;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", new Integer(id));
			a = this.getJdbcTemplate().queryForObject(query, params,new ActivityRowMapper());
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return a;
	}

}
