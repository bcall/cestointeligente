package ar.com.itr.cestointeligente.DAOImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ar.com.itr.cestointeligente.DAO.UsuarioSesionDAO;
import ar.com.itr.cestointeligente.entities.EstadoSesion;
import ar.com.itr.cestointeligente.entities.UsuarioSesion;
import ar.com.itr.cestointeligente.mapper.UsuarioSesionRowMapper;

public class UsuarioSesionDaoImp extends GenericDAOImp implements UsuarioSesionDAO {

	@Override
	public UsuarioSesion getByToken(String token) {
		String sql = "SELECT id, inicio, estado, token, nombre_usuario, usuario_id FROM usuario_sesion where token = :token";
		UsuarioSesion sesion = null;
		logger.info("DAO - Consultando base");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("token", token);
		try {
			sesion = this.getJdbcTemplate().queryForObject(sql, params, new UsuarioSesionRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return sesion;
	}

	@Override
	public boolean insertMessage(String nombreUsuario, String token, EstadoSesion estado, Date inicio, int usuarioId) {
		String sql = "insert into usuario_sesion (inicio, estado, token, nombre_usuario, usuario_id) values(:inicio,:estado,:token,:nombre_usuario,:usuario_id)";
		logger.info("DAO - insertando tupla");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("inicio", inicio);
		params.put("estado", estado.name());
		params.put("token", token);
		params.put("nombre_usuario", nombreUsuario);
		params.put("usuario_id", usuarioId);
		try {
			this.getJdbcTemplate().update(sql, params);
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
			return false;
		}

		return true;
	}

	@Override
	public boolean closeSession(String token, Date fin) {
		String sql = "UPDATE usuario_sesion SET fin=:fin, estado=:estado WHERE token=:token";
		logger.info("DAO - actualizando tupla");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fin", fin);
		params.put("token", token);
		params.put("estado", EstadoSesion.INACTIVA.name());
		try {
			this.getJdbcTemplate().update(sql, params);
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
			return false;
		}

		return true;
	}

}
