package ar.com.itr.cestointeligente.DAOImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.itr.cestointeligente.DAO.ProjectDAO;
import ar.com.itr.cestointeligente.entities.Project;
import ar.com.itr.cestointeligente.mapper.ProjectRowMapper;

public class ProjectDAOImp extends GenericDAOImp implements ProjectDAO {

	@Override
	public Project getProyectByCompId(int id) {
		
		String sql = "select cp.*,e.NAME,ps.*,pt.* from comp_proyect cp left join proy_status ps on cp.STATUS_ID=ps.ID left join proy_turn pt on cp.turn_id=pt.ID left join establecimiento e on e.ID=cp.ESTAB_ID inner join (SELECT isl.comp_proyect_id FROM cestostest.isla_cesto ic left join cestostest.isla isl on isl.id = ic.isla_id  where cesto_id = :id) isla on isla.comp_proyect_id=cp.ID where ACTIVE=1;";
		Project p = null;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", new Integer(id));
			p = this.getJdbcTemplate().queryForObject(sql, params,
					new ProjectRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return p;
	}

	@Override
	public Project getProyectById(int id) {
		String sql = "select cp.*,e.NAME,ps.*,pt.* from comp_proyect cp left join proy_status ps on cp.STATUS_ID=ps.ID left join proy_turn pt on cp.turn_id=pt.ID left join establecimiento e on e.ID=cp.ESTAB_ID where cp.ID=:id AND ACTIVE=1;";
		Project p = null;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", new Integer(id));
			p = this.getJdbcTemplate().queryForObject(sql, params,
					new ProjectRowMapper());

		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return p;
	}

	@Override
	public List<Project> getAllActiveProyects() {
		String sql = "select cp.*,e.NAME,ps.*,pt.* from comp_proyect cp left join proy_status ps on cp.STATUS_ID=ps.ID left join proy_turn pt on cp.turn_id=pt.ID left join establecimiento e on e.ID=cp.ESTAB_ID where ACTIVE=1;";
		List<Project> p = null;
		logger.info("DAO - Consultando base");
		try {
			p = this.getJdbcTemplate().query(sql, new ProjectRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return p;
	}

	@Override
	public List<Project> getAllProyectsByEst(int id) {
		String sql = "select cp.*,e.NAME,ps.*,pt.*,cp.date_from as DATEFROM,cp.date_to as DATETO from comp_proyect cp left join proy_status ps on cp.STATUS_ID=ps.ID left join proy_turn pt on cp.turn_id=pt.ID left join establecimiento e on e.ID=cp.ESTAB_ID where ACTIVE=1 AND cp.ESTAB_ID=:id;";
		List<Project> p = null;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", new Integer(id));
			p = this.getJdbcTemplate().query(sql, params,
					new ProjectRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return p;
	}

	@Override
	public boolean cancelProject(int id) {
		String sql = "UPDATE comp_proyect SET ACTIVE = 0 WHERE COMP_ID = :id;";
		logger.info("DAO - Cancelando proyecto con id: " + id);
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", new Integer(id));
			this.getJdbcTemplate().update(sql, params);
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
			return false;
		}
		return true;
	}

}
