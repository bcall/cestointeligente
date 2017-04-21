package ar.com.itr.cestointeligente.DAOImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.itr.cestointeligente.DAO.ConcursoDAO;
import ar.com.itr.cestointeligente.entities.Concurso;
import ar.com.itr.cestointeligente.entities.ConcursoDeposito;
import ar.com.itr.cestointeligente.entities.ConcursoPuntosVerdes;
import ar.com.itr.cestointeligente.entities.ConcursoUsuario;
import ar.com.itr.cestointeligente.mapper.ConcursoDepositoRowMapper;
import ar.com.itr.cestointeligente.mapper.ConcursoPuntosVerdesRowMapper;
import ar.com.itr.cestointeligente.mapper.ConcursoRowMapper;
import ar.com.itr.cestointeligente.mapper.ConcursoUsuarioRowMapper;
import ar.com.itr.cestointeligente.mapper.UsuarioRowMapperRanking;

public class ConcursoDAOImp extends GenericDAOImp implements ConcursoDAO {
	
	private Logger LOGGER = LoggerFactory.getLogger(ConcursoDAOImp.class);

	@Override
	public List<Concurso> getByUsuarioId(int id) {
		String sql = "SELECT c.id, c.descripcion, c.fecha_inicio, c.fecha_fin, c.codigo, c.responsable FROM concurso c left join concurso_usuario cu on c.id = cu.concurso_id where usuario_id = :id";
		List<Concurso> concursos = null;
		LOGGER.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", id);
			concursos = this.getJdbcTemplate().query(sql, params, new ConcursoRowMapper() );
		} catch (Exception e) {
			LOGGER.error("error - intente mas tarde. ", e);
		}
		return concursos;
	}
	
	@Override
	public List<ar.com.itr.cestointeligente.entities.UsuarioRanking> getByConcurso(Integer concursoid) {
		
		if (concursoid==null) {
			concursoid=1;
		}
		
		String sql = "SELECT * FROM concurso_usuario inner join usuario on concurso_usuario.usuario_id=usuario.id where concurso_id = :concursoid order by puntos_acumulados desc";
		 List<ar.com.itr.cestointeligente.entities.UsuarioRanking> usuarios = null;
		LOGGER.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("concursoid", concursoid);
			usuarios = this.getJdbcTemplate().query(sql, params, new UsuarioRowMapperRanking());
		} catch (Exception e) {
			LOGGER.error("error - intente mas tarde. ", e);
		}
		return usuarios;
	}

	@Override
	public Concurso getByCodigo(String codigo) {
		String sql = "SELECT c.id, c.descripcion, c.fecha_inicio, c.fecha_fin, c.codigo, c.responsable FROM concurso c where codigo = :codigo";
		Concurso concurso = null;
		LOGGER.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("codigo", codigo);
			concurso = this.getJdbcTemplate().queryForObject(sql, params, new ConcursoRowMapper());
		} catch (Exception e) {
			LOGGER.error("error - intente mas tarde. ", e);
		}
		return concurso;
	}
	
//*** Concurso usuario ***//
	
	@Override
	public ConcursoUsuario getConcursoUsuario(int usuarioId, int concursoId) {
		String sql = "SELECT id, usuario_id,posicion_final,concurso_id,puntos_acumulados FROM(SELECT id,usuario_id,@rownum:=@rownum+1 as posicion_final,concurso_id,puntos_acumulados FROM (SELECT @rownum:=0) r,concurso_usuario where concurso_id = :concurso_id order by puntos_acumulados desc) a where usuario_id=:usuario_id;";
		ConcursoUsuario concursoUsuario = null;
		LOGGER.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("usuario_id", usuarioId);
			params.put("concurso_id", concursoId);
			concursoUsuario = this.getJdbcTemplate().queryForObject(sql, params, new ConcursoUsuarioRowMapper());
		} catch (Exception e) {
			LOGGER.error("error - intente mas tarde. ", e);
		}
		return concursoUsuario;
	}
	
	@Override
	public List<ConcursoUsuario> getConcursoUsuario(int concursoId) {
		String sql = "SELECT id, usuario_id, puntos_acumulados, usuario_id as posicion_final, concurso_id FROM concurso_usuario where concurso_id = :concurso_id order by puntos_acumulados desc";
		List<ConcursoUsuario> concursosUsuario = null; 
		LOGGER.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("concurso_id", concursoId);
			concursosUsuario = this.getJdbcTemplate().query(sql, params, new ConcursoUsuarioRowMapper());
		} catch (Exception e) {
			LOGGER.error("error - intente mas tarde. ", e);
		}
		return concursosUsuario;
	}

	@Override
	public List<ConcursoDeposito> getConcursoDespositos(int usuarioId, int concursoId) {
		String sql = "SELECT id, usuario_id, fecha, isla_id, tipo_residuo_id, peso, puntos, concurso_id FROM concurso_deposito where usuario_id = :usuario_id and concurso_id = :concurso_id order by id desc limit 10;";
		List<ConcursoDeposito> depositos = null; 
		LOGGER.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("concurso_id", concursoId);
			params.put("usuario_id", usuarioId);
			depositos = this.getJdbcTemplate().query(sql, params, new ConcursoDepositoRowMapper());
		} catch (Exception e) {
			LOGGER.error("error - intente mas tarde. ", e);
		}
		return depositos;
	}
	
	//*** Concurso puntos verdes ***//

	@Override
	public ConcursoPuntosVerdes getCursoPuntosVerdesById(int id) {
		String sql = "SELECT id, concurso_id, puntos FROM concurso_puntos_verde where id=:id;";
		ConcursoPuntosVerdes concursoUsuario = null; 
		LOGGER.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", id);
			concursoUsuario = this.getJdbcTemplate().queryForObject(sql, params, new ConcursoPuntosVerdesRowMapper());
		} catch (Exception e) {
			LOGGER.error("error - intente mas tarde. ", e);
		}
		return concursoUsuario;
	}

	@Override
	public boolean insertConcursoDeposito(ConcursoDeposito concurso) {
		String sql = "insert into concurso_deposito(concurso_id, usuario_id, fecha, isla_id, tipo_residuo_id, peso, puntos) values(:concurso_id, :usuario_id, :fecha, :isla_id, :tipo_residuo_id, :peso, :puntos)";
		LOGGER.info("DAO - insertando tupla");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("concurso_id", concurso.getConcursoId());
		params.put("usuario_id",concurso.getUsuarioId());
		params.put("fecha", concurso.getFecha());
		params.put("isla_id", concurso.getIslaId());
		params.put("tipo_residuo_id", concurso.getTipoResiduoId());		
		params.put("peso", concurso.getPeso());
		params.put("puntos", concurso.getPuntos());
		try {
			this.getJdbcTemplate().update(sql, params);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return false;
		}

		return true;
	}
	
	@Override
	public List<Concurso> listaConcurso() {
	   String SQL = "SELECT * FROM concurso";
	   List<Concurso> concursos = (List<Concurso>)  this.getJdbcTemplate().query(SQL, new ConcursoRowMapper());
	     return concursos;
	}
		@Override
	public boolean updatePuntos(int concursoId, int usuarioId, int puntos) {
		String preSql = "SET SQL_SAFE_UPDATES = 0;";
		String sql = "update concurso_usuario set puntos_acumulados = puntos_acumulados + :puntos where concurso_id = :concurso_id and usuario_id = :usuario_id;";
        String postSql = "SET SQL_SAFE_UPDATES = 1;";
		
		LOGGER.info("DAO - actualizando puntos");

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("puntos", puntos);
		params.put("usuario_id", usuarioId);
		params.put("concurso_id", concursoId);
		
		try {
			this.getJdbcTemplate().update(preSql, new HashMap<String, Object>());
			this.getJdbcTemplate().update(sql, params);
			this.getJdbcTemplate().update(postSql, new HashMap<String, Object>());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return false;
		}

		return true;
	}

		@Override
		public ConcursoPuntosVerdes getCursoPuntosVerdesById(int concursoId, int tipoResiduoId) {
			String sql = "SELECT concurso_id, residuo_id, puntos FROM concurso_puntaje where concurso_id=:concursoId and residuo_id=:tipoResiduoId";
			ConcursoPuntosVerdes concursoUsuario = null;
			LOGGER.info("DAO - Consultando base");
			try {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("concursoId", concursoId);
				params.put("tipoResiduoId", tipoResiduoId);
				concursoUsuario = this.getJdbcTemplate().queryForObject(sql, params, new ConcursoPuntosVerdesRowMapper());
			} catch (Exception e) {
				LOGGER.error("error - intente mas tarde. ", e);
			}
			return concursoUsuario;
		}


	
}
