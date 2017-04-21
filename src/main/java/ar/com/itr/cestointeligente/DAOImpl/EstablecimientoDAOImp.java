package ar.com.itr.cestointeligente.DAOImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.itr.cestointeligente.DAO.EstablecimientoDAO;
import ar.com.itr.cestointeligente.entities.Establecimiento;
import ar.com.itr.cestointeligente.mapper.EstablecimientoRowMapper;

public class EstablecimientoDAOImp extends GenericDAOImp implements
		EstablecimientoDAO {

	public List<Establecimiento> getAllEst() {
		String sql = "SELECT E.*,C.COMP FROM establecimiento E LEFT JOIN (SELECT COUNT(*) AS COMP,ESTAB_ID FROM comp_proyect GROUP BY ESTAB_ID) AS C ON C.ESTAB_ID=E.ID;";
		List<Establecimiento> establishments = null;
		logger.info("DAO - Consultando base");
		try {
			establishments = this.getJdbcTemplate().query(sql,
					new HashMap<String, Object>(),
					new EstablecimientoRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return establishments;
	}

	public List<Establecimiento> getAllEstByAct(int ID) {
		String sql = "SELECT E.*,CP.COMP_ID AS COMP FROM proj_act PA LEFT JOIN comp_proyect CP ON PA.PROJ_ID=CP.ID LEFT JOIN establecimiento E ON CP.ESTAB_ID=E.ID WHERE ACT_ID=:id GROUP BY E.ID;";
		List<Establecimiento> establishments = null;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", new Integer(ID));
			establishments = this.getJdbcTemplate().query(sql, params,
					new EstablecimientoRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return establishments;
	}

	@Override
	public Establecimiento getEstByID(int ID) {
		String sql = "SELECT E.*,C.COMP FROM establecimiento E LEFT JOIN (SELECT COUNT(*) AS COMP,ESTAB_ID FROM comp_proyect GROUP BY ESTAB_ID) AS C ON C.ESTAB_ID=E.ID WHERE E.ID=:id";
		Establecimiento establishment = null;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", new Integer(ID));
			establishment = this.getJdbcTemplate().queryForObject(sql, params,
					new EstablecimientoRowMapper());
		}

		catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return establishment;
	}
}
