package ar.com.itr.cestointeligente.DAOImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;

import ar.com.itr.cestointeligente.DAO.GrupoUsuarioDAO;
import ar.com.itr.cestointeligente.entities.GrupoUsuario;
import ar.com.itr.cestointeligente.mapper.GrupoUsuarioRowMapper;

public class GrupoUsuarioDAOImp extends GenericDAOImp implements GrupoUsuarioDAO {
	
	@Override
	public GrupoUsuario getGrupoUsuarioByID(int id) {
		String sql = "select id, descripcion from grupo_usuario where id = :id";
		GrupoUsuario grupoUsuario = null;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", new Integer(id));
			grupoUsuario = this.getJdbcTemplate().queryForObject(sql, params,
					new GrupoUsuarioRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			logger.warn("No se encontro grupo de usuario con id: " + id);
			return null;
		} catch (Exception e) {
			logger.error("error - intente mas tarde. " + e);
		}
		return grupoUsuario;
	}	
}
