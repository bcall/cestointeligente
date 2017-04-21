package ar.com.itr.cestointeligente.DAOImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.itr.cestointeligente.DAO.IslaDAO;
import ar.com.itr.cestointeligente.entities.Isla;
import ar.com.itr.cestointeligente.entities.IslaUbicacion;
import ar.com.itr.cestointeligente.entities.view.IslaView;
import ar.com.itr.cestointeligente.mapper.IslaRowMapper;
import ar.com.itr.cestointeligente.mapper.IslaRowMapperPoscion;
import ar.com.itr.cestointeligente.mapper.view.IslaViewRowMapper;
import ar.com.itr.cestointeligente.entities.IslaPosicion;
import ar.com.itr.cestointeligente.mapper.IslaPosicionRowMapper;

public class IslaDAOImp extends GenericDAOImp implements IslaDAO {

	@Override
	public List<Isla> getAllIslaByProject(final int projectID) {
		StringBuffer stringBuffer = new StringBuffer("SELECT isla.ID, GR_U_DAY_PROY, INPUT_DAY_PROY, NAME AS CORRIENTE_RESIDUO_NAME, isla_posicion.posicion as ISLA_POSICION, H_INPUT, H_OUTPUT, LAST_W  ");
		stringBuffer.append(" FROM  isla ");
		stringBuffer.append("left join corriente_residuo cr ");
		stringBuffer.append("on cr.id = corriente_residuo_id ");
		stringBuffer.append("left join isla_posicion ");
		stringBuffer.append("on isla_posicion.id = isla.isla_posicion_id ");
		stringBuffer.append("where isla.comp_proyect_id=:projectID ");
		String sql = stringBuffer.toString();
		List<Isla> islas = null;
		logger.info("DAO - Consultando base de islas: " + sql);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("projectID", new Integer(projectID));
		try {
			islas = this.getJdbcTemplate().query(sql, params, new IslaRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return islas;
	}
	
	@Override
	public List<IslaUbicacion> getAllIslaByPosicion(String lon, String lat) {
		String sql = "select id,latitud,longitud from isla";
		List<IslaUbicacion> islas = null;
		logger.info("DAO - Consultando base de islas: " + sql);
		Map<String, Object> params = new HashMap<String, Object>();
				try {
			islas = this.getJdbcTemplate().query(sql,params, new IslaRowMapperPoscion());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return islas;
	}
	
	
	@Override
	public List<IslaView> getAllIslaByProjectToView(final int projectID) {
		StringBuffer stringBuffer = new StringBuffer("SELECT input_day_proy,p.date_from,p.date_to,posicion,sum(h_input)as h_input, sum(h_output) as h_output, sum(last_w) last_w, comp_proyect_id, isla_posicion_id ");
		stringBuffer.append(" FROM  isla ");
		stringBuffer.append("left join comp_proyect p ");
		stringBuffer.append("on p.id = isla.comp_proyect_id ");
		stringBuffer.append("left join corriente_residuo cr ");
		stringBuffer.append("on cr.id = corriente_residuo_id ");
		stringBuffer.append("left join isla_posicion ");
		stringBuffer.append("on isla_posicion.id = isla.isla_posicion_id ");
		stringBuffer.append("where isla.comp_proyect_id=:projectID ");
		stringBuffer.append("group by isla_posicion_id "); 
		String sql = stringBuffer.toString();
		List<IslaView> islas = null;
		logger.info("DAO - Consultando base de islas: " + sql);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("projectID", new Integer(projectID));
		try {
			islas = this.getJdbcTemplate().query(sql, params, new IslaViewRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return islas;
	}
	
	@Override
	public IslaView getIslaByProjectToView(final int projectId, final int posicionId) {
		StringBuffer stringBuffer = new StringBuffer("SELECT posicion,sum(h_input)as h_input, sum(h_output) as h_output, sum(last_w) last_w, comp_proyect_id, isla_posicion_id ");
		stringBuffer.append(" FROM  isla ");
		stringBuffer.append("left join corriente_residuo cr ");
		stringBuffer.append("on cr.id = corriente_residuo_id ");
		stringBuffer.append("left join isla_posicion ");
		stringBuffer.append("on isla_posicion.id = isla.isla_posicion_id ");
		
		stringBuffer.append("where isla.comp_proyect_id=:projectID ");
		stringBuffer.append("and isla.isla_posicion_id =:posicionId ");
		stringBuffer.append("group by isla_posicion_id "); 
		String sql = stringBuffer.toString();
		IslaView isla = null;
		logger.info("DAO - Consultando base de islas: " + sql);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("projectID", new Integer(projectId));
		params.put("posicionId", new Integer(posicionId));
		try {
			isla = this.getJdbcTemplate().queryForObject(sql, params, new IslaViewRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return isla;
	}

	@Override
	public Isla getIslaById(int islaId) {
		StringBuffer stringBuffer = new StringBuffer("SELECT isla.ID, GR_U_DAY_PROY, INPUT_DAY_PROY, NAME AS CORRIENTE_RESIDUO_NAME, isla_posicion.posicion as ISLA_POSICION, H_INPUT, H_OUTPUT, LAST_W  ");
		stringBuffer.append(" FROM  isla ");
		stringBuffer.append("left join corriente_residuo cr ");
		stringBuffer.append("on cr.id = corriente_residuo_id ");
		stringBuffer.append("left join isla_posicion ");
		stringBuffer.append("on isla_posicion.id = isla.isla_posicion_id ");
		stringBuffer.append("where isla.ID=:islaID ");
		String sql = stringBuffer.toString();
		Isla isla = null;
		logger.info("DAO - Consultando base de islas: " + sql);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("islaID", islaId);
		try {
			isla = this.getJdbcTemplate().queryForObject(sql, params, new IslaRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return isla;
	}
	
	@Override
		public boolean insertIsla(int grUDayProy, int inputDayProy, int comProyectId, int corrienteResiduoId, int islaPosicionId,
				Double hInput, Double hOutput, Double lastw) {
			String sql = "INSERT INTO isla (GR_U_DAY_PROY, INPUT_DAY_PROY, COMP_PROYECT_ID, CORRIENTE_RESIDUO_ID, ISLA_POSICION_ID, H_INPUT, H_OUTPUT, LAST_W ) "
					+ "VALUES (:grUDayProy, :inputDayProy, :comProyectId, :corrienteResiduoId, :islaPosicionId, :hInput, :hOutput, :lastw )";
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("grUDayProy", grUDayProy);		
			params.put("inputDayProy", inputDayProy);		
			params.put("comProyectId", comProyectId);		
			params.put("corrienteResiduoId", corrienteResiduoId);		
			params.put("islaPosicionId", islaPosicionId);		
			params.put("hInput", hInput);		
			params.put("hOutput", hOutput);
			params.put("lastw", lastw);
			
			logger.info("DAO - guardando base de islas: " + sql);
			
			try {
				this.getJdbcTemplate().update(sql, params);
			} catch (Exception e) {
				logger.error("error - intente mas tarde. " + e);
			}
			return true;
		}
	
	@Override
		public List<Isla> getAllIsla() {
			StringBuffer stringBuffer = new StringBuffer("SELECT isla.ID, GR_U_DAY_PROY, INPUT_DAY_PROY, NAME AS CORRIENTE_RESIDUO_NAME, isla_posicion.posicion as ISLA_POSICION, H_INPUT, H_OUTPUT, LAST_W  ");
			stringBuffer.append(" FROM  isla ");
			stringBuffer.append("left join corriente_residuo cr ");
			stringBuffer.append("on cr.id = corriente_residuo_id ");
			stringBuffer.append("left join isla_posicion ");
			stringBuffer.append("on isla_posicion.id = isla.isla_posicion_id ");
			String sql = stringBuffer.toString();
			List<Isla> islas = null;
			logger.info("DAO - Consultando base de islas: " + sql);
			Map<String, Object> params = new HashMap<String, Object>();
			try {
				islas = this.getJdbcTemplate().query(sql, params, new IslaRowMapper());
			} catch (Exception e) {
				logger.error("error - intente mas tarde. ", e);
		}
			return islas;
		}
	
	
	@Override
		public boolean updateIsla(int id, int grUDayProy, int inputDayProy, int comProyectId, int corrienteResiduoId,
				int islaPosicionId, Double hInput, Double hOutput, Double lastw) {
			String preSql = "SET SQL_SAFE_UPDATES = 0;";
			String sql = "update isla set GR_U_DAY_PROY=:grUDayProy, INPUT_DAY_PROY=:inputDayProy, COMP_PROYECT_ID=comProyectId " +
				"CORRIENTE_RESIDUO_ID=:corrienteResiduoId, ISLA_POSICION_ID=:islaPosicionId, HINPUT=:hInput, HOUTPUT=:hOutput, LASTW=lastw " +
					"WHERE ID=:id";
			String postSql = "SET SQL_SAFE_UPDATES = 1;";
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("grUDayProy", grUDayProy);		
			params.put("inputDayProy", inputDayProy);		
			params.put("comProyectId", comProyectId);		
			params.put("corrienteResiduoId", corrienteResiduoId);		
			params.put("islaPosicionId", islaPosicionId);		
			params.put("hInput", hInput);		
			params.put("hOutput", hOutput);
			params.put("lastw", lastw);
			params.put("id", id);
			
			logger.info("DAO - guardando base de islas: " + sql);
			
			try {
				this.getJdbcTemplate().update(preSql, new HashMap<String, Object>());
				this.getJdbcTemplate().update(sql, params);
				this.getJdbcTemplate().update(postSql, new HashMap<String, Object>());
			} catch (Exception e) {
				logger.error("error - intente mas tarde. ", e);
			}
			return true;
		}
	
	@Override
		public List<IslaPosicion> getAllIslaPosicion() {
			String sql = "select id, posicion from isla_posicion";
			List<IslaPosicion> islas = null;
		logger.info("DAO - Consultando base de islas: " + sql);
			Map<String, Object> params = new HashMap<String, Object>();
			try {
				islas = this.getJdbcTemplate().query(sql, params, new IslaPosicionRowMapper());
			} catch (Exception e) {
				logger.error("error - intente mas tarde. ", e);
			}
			return islas;
		}

}
