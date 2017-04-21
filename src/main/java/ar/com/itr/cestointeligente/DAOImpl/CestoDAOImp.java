package ar.com.itr.cestointeligente.DAOImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;

import ar.com.itr.cestointeligente.DAO.CestoDAO;
import ar.com.itr.cestointeligente.entities.Cesto;
import ar.com.itr.cestointeligente.entities.view.CestoNotAliveView;
import ar.com.itr.cestointeligente.entities.view.CestoView;
import ar.com.itr.cestointeligente.mapper.CestoRowMapper;
import ar.com.itr.cestointeligente.mapper.view.CestoNotAliveViewRowMapper;
import ar.com.itr.cestointeligente.mapper.view.CestoViewRowMapper;

public class CestoDAOImp extends GenericDAOImp implements CestoDAO {

	private static final String SUBQUERY_NOT_ALIVE_CESTO = "  where ( select count(*) from messages where " +
				              "messages.compost_id = cesto.id  and ( date(messages.DATE) between date_sub(date(now()), interval 1 day ) and date(now())) " +
				              "and cesto.status_id  = 1 ) = 0 " ;

	@Override
	public Cesto getCestoByID(int id) {
		String sql = "SELECT C.ID,C.IMAGE,CS.STATUS,CM.NAME AS MODEL_NAME,CM.VOLUME,CM.ALARM_W,H.DESCR AS HARD_D,C.FIRMWARE,DATE(C.FAB_DATE) AS FAB_DATE, CORRIENTE_RESIDUO.NAME AS CORRIENTE_RESIDUO, TIPO_RESIDUO.NAME AS TIPO_RESIDUO,TIPO_RESIDUO_ID FROM cesto C LEFT JOIN comp_model CM ON C.MODEL_ID=CM.ID LEFT JOIN hardware H ON CM.HARD_ID=H.ID LEFT JOIN comp_status CS ON C.STATUS_ID=CS.ID LEFT JOIN tipo_residuo TIPO_RESIDUO ON TIPO_RESIDUO.ID = C.tipo_residuo_id left join corriente_residuo CORRIENTE_RESIDUO on CORRIENTE_RESIDUO.id = TIPO_RESIDUO.corriente_residuo_id WHERE C.ID=:id ;";
		Cesto c = null;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", new Integer(id));
			c = this.getJdbcTemplate().queryForObject(sql, params,
					new CestoRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			logger.warn("No se encontro cesto con id: " + id);
			return null;
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return c;
	}

	@Override
	public List<Cesto> getAllCestos() {
		String sql = "SELECT C.ID,C.IMAGE,CS.STATUS,CM.NAME AS MODEL_NAME,CM.VOLUME,CM.ALARM_W,H.DESCR AS HARD_D,C.FIRMWARE,DATE(C.FAB_DATE) AS FAB_DATE, CORRIENTE_RESIDUO.NAME AS CORRIENTE_RESIDUO, TIPO_RESIDUO.NAME AS TIPO_RESIDUO,TIPO_RESIDUO.ID AS TIPO_RESIDUO_ID FROM cesto C LEFT JOIN comp_model CM ON C.MODEL_ID=CM.ID LEFT JOIN hardware H ON CM.HARD_ID=H.ID LEFT JOIN comp_status CS ON C.STATUS_ID=CS.ID LEFT JOIN tipo_residuo TIPO_RESIDUO ON TIPO_RESIDUO.ID = C.tipo_residuo_id left join corriente_residuo CORRIENTE_RESIDUO on CORRIENTE_RESIDUO.id = TIPO_RESIDUO.corriente_residuo_id order by ID ;";
		List<Cesto> comps = null;
		logger.info("DAO - Consultando base");
		try {
			comps = this.getJdbcTemplate().query(sql, new CestoRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			logger.warn("No se encontraron cestos: ");
			return null;
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return comps;
	}
	
	@Override
	public List<CestoView> getCestoByIslaId(int proId,int ubiId) {
		String sql = "SELECT C.ID,C.IMAGE,CS.STATUS,CM.NAME AS MODEL_NAME,CM.VOLUME,CM.ALARM_W,H.DESCR AS HARD_D,C.FIRMWARE,DATE(C.FAB_DATE) AS FAB_DATE, CORRIENTE_RESIDUO.NAME AS CORRIENTE_RESIDUO, TIPO_RESIDUO.NAME AS TIPO_RESIDUO,C.WEIGTH FROM cesto C LEFT JOIN comp_model CM ON C.MODEL_ID=CM.ID LEFT JOIN hardware H ON CM.HARD_ID=H.ID LEFT JOIN comp_status CS ON C.STATUS_ID=CS.ID LEFT JOIN tipo_residuo TIPO_RESIDUO ON TIPO_RESIDUO.ID = C.tipo_residuo_id left join corriente_residuo CORRIENTE_RESIDUO on CORRIENTE_RESIDUO.id = TIPO_RESIDUO.corriente_residuo_id WHERE C.ID IN (SELECT cesto_id FROM isla_cesto WHERE isla_id in (SELECT isla.id FROM isla WHERE comp_proyect_id =:proId AND  isla_posicion_id =:ubiId));";
		List<CestoView> cestos = null;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("proId", new Integer(proId));
			params.put("ubiId", new Integer(ubiId));
			cestos = this.getJdbcTemplate().query(sql, params,
					new CestoViewRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			logger.warn("No se encontro cesto con id: " + proId + " y ubicacion Id: "+ubiId);
			return null;
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return cestos;
	}
	
	@Override
	public int getCountNotAliveCesto() {
		String sql = "SELECT count(*) FROM cesto " + SUBQUERY_NOT_ALIVE_CESTO;
		int comps = 0;
		logger.info("DAO - Obteniendo Cestos Activos No Vivos");
		try {
			comps = this.getJdbcTemplate().queryForObject(sql, new HashMap<String, String>(), Integer.class);
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return comps;
	}

	@Override
	public List<CestoNotAliveView> getNotAliveCesto() {
		String sql = "SELECT cesto.ID as cesto_id, establecimiento.NAME as establecimiento, establecimiento.CALLE as establecimiento_calle, establecimiento.NUM as establecimiento_numero, " +
                     "corriente_residuo.NAME as isla_name, isla_posicion.posicion  as ubicacion FROM cesto left join isla_cesto on isla_cesto.cesto_id = cesto.ID " +
				     "left join isla on isla.ID = isla_cesto.isla_id left join isla_posicion on isla_posicion.ID = isla.isla_posicion_id left join comp_proyect on isla.comp_proyect_id = comp_proyect.ID " +
                     "left join establecimiento on comp_proyect.ESTAB_ID = establecimiento.ID left join corriente_residuo on corriente_residuo.ID = isla.corriente_residuo_id " +
				     SUBQUERY_NOT_ALIVE_CESTO;				
		List<CestoNotAliveView> cestos = null;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			cestos = this.getJdbcTemplate().query(sql, params,
					new CestoNotAliveViewRowMapper());
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return cestos;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getIslaIdByCestoId(int cestoId) {
		String sql = "SELECT isla_id FROM isla_cesto where cesto_id = :id;";
		int islaId = 0;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", cestoId);
			islaId = this.getJdbcTemplate().queryForInt(sql, params);
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return islaId;
	}

}
