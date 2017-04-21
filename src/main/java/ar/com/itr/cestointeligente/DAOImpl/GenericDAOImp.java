package ar.com.itr.cestointeligente.DAOImpl;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import ar.com.itr.cestointeligente.entities.Concurso;
import ar.com.itr.cestointeligente.entities.ConcursoPuntosVerdes;
import ar.com.itr.cestointeligente.entities.IslaUbicacion;
import ar.com.itr.cestointeligente.entities.UsuarioTotem;

public class GenericDAOImp {
	@Autowired
	private DataSource dataSource;
	private NamedParameterJdbcTemplate jdbcTemplate;
	final public Logger logger = Logger.getLogger(this.getClass());
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void create(String nombre, String password, String apellido,
			String telefono, String nombre_usuario, int grupo_id) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Integer empid) {
		// TODO Auto-generated method stub
		
	}

	public void update(Integer empid, Integer age) {
		// TODO Auto-generated method stub
		
	}

	public void update(String nombre, String password, String apellido,
			String telefono, String nombre_usuario, int grupo_id) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("rawtypes")
	public List listaUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Concurso> listaConcurso() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ar.com.itr.cestointeligente.entities.UsuarioRanking> getByConcurso(Integer concursoid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IslaUbicacion> getAllIslaByPosicion(String lon, String lat) {
		// TODO Auto-generated method stub
		return null;
	}

	public UsuarioTotem getByCodeqr(String codigoqr) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ConcursoPuntosVerdes getCursoPuntosVerdesById(int concursoId, int tipoResiduoId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(String nombre, String password, String apellido, String telefono, String nombre_usuario,
			int grupo_id, String codigo_qr) {
		// TODO Auto-generated method stub
		
	}

}
