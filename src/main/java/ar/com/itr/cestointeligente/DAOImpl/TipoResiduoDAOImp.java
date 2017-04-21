package ar.com.itr.cestointeligente.DAOImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.itr.cestointeligente.DAO.TipoResiduoDAO;
import ar.com.itr.cestointeligente.entities.TipoResiduo;
import ar.com.itr.cestointeligente.mapper.TipoResiduoRowMapper;

public class TipoResiduoDAOImp extends GenericDAOImp implements TipoResiduoDAO {

	@Override
	public List<TipoResiduo> getAllTipoResiduoBy(int islaID) {
		StringBuffer stringBuffer = new StringBuffer("select TR.id, TR.name from tipo_residuo TR left join corriente_residuo CR on CR.id = TR.corriente_residuo_id ");
		stringBuffer.append(" left join isla on isla.corriente_residuo_id = CR.id  ");
		stringBuffer.append( String.format( " where isla.id =  :islaID" , islaID));
		String sql = stringBuffer.toString();
		List<TipoResiduo> tiposResiduos = null;
		logger.info("DAO - Consultando base ");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("islaID", new Integer(islaID));
	
			tiposResiduos = this.getJdbcTemplate().query(sql, params,
					new TipoResiduoRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return tiposResiduos;
	}
	@Override
		public List<TipoResiduo> getAllTipoResiduo() {
			StringBuffer stringBuffer = new StringBuffer("select TR.id, TR.name from tipo_residuo");
			String sql = stringBuffer.toString();
			List<TipoResiduo> tiposResiduos = null;
			logger.info("DAO - Consultando base ");
			try {
				Map<String, Object> params = new HashMap<String, Object>();
				tiposResiduos = this.getJdbcTemplate().query(sql, params,
						new TipoResiduoRowMapper());
			} catch (Exception e) {
				logger.error("error - intente mas tarde. ", e);
	 		}
	 		return tiposResiduos;
	 	}

}
