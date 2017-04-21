package ar.com.itr.cestointeligente.DAOImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import ar.com.itr.cestointeligente.DAO.StatsDAO;
import ar.com.itr.cestointeligente.DAOImpl.utils.IndexGraphQueryBuilder;
import ar.com.itr.cestointeligente.DAOImpl.utils.IndexGraphQueryCriteria;
import ar.com.itr.cestointeligente.entities.Project;
import ar.com.itr.cestointeligente.entities.RankingTableItem;
import ar.com.itr.cestointeligente.mapper.ProjectRowMapper;
import ar.com.itr.cestointeligente.mapper.RankingTableItemRowMapper;

public class StatsDAOImp extends GenericDAOImp implements StatsDAO {
	
	private IndexGraphQueryBuilder indexGraphQueryBuilder = new IndexGraphQueryBuilder();

	@Override
	public Map<String, Integer> getIndexStats() {
		String sqlEst = "SELECT COUNT(*) FROM establecimiento;";
		String sqlProy = "SELECT COUNT(*) FROM comp_proyect WHERE ACTIVE=1;";
		String sqlAct = "SELECT COUNT(*) FROM activity;";
		Map<String, Integer> stats = new HashMap<String, Integer>();
		logger.info("DAO - Consultando base");
		try {
			int estCount = this.getJdbcTemplate().queryForObject(sqlEst,
					new HashMap<String, String>(), Integer.class);
			int proyCount = this.getJdbcTemplate().queryForObject(sqlProy,
					new HashMap<String, String>(), Integer.class);
			int actCount = this.getJdbcTemplate().queryForObject(sqlAct,
					new HashMap<String, String>(), Integer.class);
			stats.put("estCount", estCount);
			stats.put("proyCount", proyCount);
			stats.put("actCount", actCount);

		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}

		return stats;
	}

	
	public List<Map<String, Object>> getNotAlive(int id, String maxDate) {
		String sql1 = "CALL getNotAlive(" + id + ",'" + maxDate + "')";
		List<Map<String, Object>> list = null;
		logger.info("DAO - Consultando base");
		try {
			list = this.getJdbcTemplate().queryForList(sql1,
					new HashMap<String, String>());
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return list;
	}
	public List<Map<String, Object>> getCompostStats(int id, String maxDate) {
		String sql1 = "CALL getCompostDataTable(" + id + ",'" + maxDate + "')"; // getCompostDataTable
		List<Map<String, Object>> list = null;
		logger.info("DAO - Consultando base");
		try {
			list = this.getJdbcTemplate().queryForList(sql1,
					new HashMap<String, String>());
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return list;
	}

	public List<List<Map<String, Object>>> getIndexGraph(IndexGraphQueryCriteria filterReciclables, IndexGraphQueryCriteria filterNoReciclables) {
		//Reciclables
		String totalReciclables = this.indexGraphQueryBuilder.buildQueryByTotal(filterReciclables);
		String daysReciclables = this.indexGraphQueryBuilder.buildQueryByDay(filterReciclables);
		
		//No Reciclables
		String totalNoReciclables = this.indexGraphQueryBuilder.buildQueryByTotal(filterNoReciclables);
		String daysNoReciclables = this.indexGraphQueryBuilder.buildQueryByDay(filterNoReciclables);
		
		List<List<Map<String, Object>>> data = new ArrayList<List<Map<String, Object>>>();
		logger.info("DAO - Consultando base");
		try {
			//Reciclables
			if (totalReciclables != null)
			    data.add(this.getJdbcTemplate().queryForList(totalReciclables,
				    	new HashMap<String, String>()));
			if (daysReciclables != null)
			    data.add(this.getJdbcTemplate().queryForList(daysReciclables,
				    	new HashMap<String, String>()));
			
			//No Reciclables
			if (totalNoReciclables != null)
			    data.add(this.getJdbcTemplate().queryForList(totalNoReciclables,
					    new HashMap<String, String>()));
			if (daysNoReciclables != null)
			    data.add(this.getJdbcTemplate().queryForList(daysNoReciclables,
					    new HashMap<String, String>()));
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return data;
	}
	
	
	public List<List<Map<String, Object>>> getEvolGraph(int id) {
		String total = "SELECT GR_U_DAY_PROY AS PROY,DATE_TO,DATE_FROM,DATEDIFF(DATE_TO,DATE_FROM) AS DAYS FROM comp_proyect "
				+ "left join isla on isla.comp_proyect_id = comp_proyect.id WHERE comp_proyect.ID="+id;
		String days = "call getDaysProyect("+id+")";
		List<List<Map<String, Object>>> data = new ArrayList<List<Map<String, Object>>>();
		logger.info("DAO - Consultando base");
		try {
			data.add(this.getJdbcTemplate().queryForList(total,
					new HashMap<String, String>()));
			data.add(this.getJdbcTemplate().queryForList(days,
					new HashMap<String, String>()));
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return data;
	}

	public List<List<Map<String, Object>>> getProjActGraph(int pId,int aId) {
		String sql = "Call getDays("+pId+","+aId+")";
		List<List<Map<String, Object>>> data = new ArrayList<List<Map<String, Object>>>();
		logger.info("DAO - Consultando base");
		try {
			data.add(this.getJdbcTemplate().queryForList(sql,new HashMap<String, Object>()));
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return data;
	}

	@Override
	public List<Map<String, Object>> getProyectCompletion() {
		String total = "CALL getProyectCompletion()";
		List<Map<String, Object>> data = null;
		logger.info("DAO - Consultando base");
		try {
			data = this.getJdbcTemplate().queryForList(total,
					new HashMap<String, String>());
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return data;
	}

	@Override
	public List<RankingTableItem> getRankingItems(int value) {
		String total = "CALL getRankingData(" + value + ")";
		List<RankingTableItem> data = null;
		logger.info("DAO - Consultando base");
		try {
			data = this.getJdbcTemplate().query(total,
					new RankingTableItemRowMapper());
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return data;
	}

	@Override
	public List<Project> getWeightAlarms() {
		String query = "SELECT * FROM comp_proyect CP LEFT JOIN (SELECT C.ID,CM.ALARM_W, isla.comp_proyect_id FROM cesto C LEFT JOIN comp_model CM ON C.MODEL_ID=CM.ID left join (SELECT isl.comp_proyect_id, ic.cesto_id FROM cestostest.isla_cesto ic left join cestostest.isla isl on isl.id = ic.isla_id) isla on isla.cesto_id=C.ID) AS AL ON CP.COMP_ID=AL.id LEFT JOIN proy_turn PT ON CP.TURN_ID=PT.ID LEFT JOIN proy_status PS ON CP.STATUS_ID=PS.ID LEFT JOIN establecimiento E ON CP.ESTAB_ID=E.ID left join isla on isla.comp_proyect_id = CP.id WHERE isla.LAST_W >= AL.ALARM_W";
		
		List<Project> data = null;
		logger.info("DAO - Consultando base");
		try {
			data = this.getJdbcTemplate().query(query, new ProjectRowMapper());
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return data;
	}

	public List<Map<String, Object>> getActivityTable(int id) {
		String total = "CALL getActValues("+id+")";
		List<Map<String, Object>> data = null;
		logger.info("DAO - Consultando base");
		try {
			data = this.getJdbcTemplate().queryForList(total,
					new HashMap<String, String>());
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return data;
	}

}
