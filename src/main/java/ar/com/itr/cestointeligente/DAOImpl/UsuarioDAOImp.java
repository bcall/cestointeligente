package ar.com.itr.cestointeligente.DAOImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import ar.com.itr.cestointeligente.DAO.UsuarioDAO;
import ar.com.itr.cestointeligente.entities.Usuario;
import ar.com.itr.cestointeligente.entities.UsuarioTotem;
import ar.com.itr.cestointeligente.mapper.UsuarioRowMapper;
import ar.com.itr.cestointeligente.mapper.UsuarioTotemRowMapper;

public class UsuarioDAOImp extends GenericDAOImp implements UsuarioDAO {

	@Override
	public Usuario getByNombreUsuarioYPassword(String nombreUsuario, String password) {
		String sql = "select usuario.id,usuario.codigoqr, password, nombre, apellido, telefono, grupo_id, nombre_usuario from usuario where nombre_usuario= :nombreUsuario and password = :password";
		Usuario usuario = null;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("nombreUsuario", nombreUsuario);
			params.put("password", password);
			usuario = this.getJdbcTemplate().queryForObject(sql, params, new UsuarioRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return usuario;
	}

	@Override
	public Usuario getByNombreUsuario(String nombreUsuario) {
		String sql = "select id, password, nombre, apellido, telefono, grupo_id, nombre_usuario from usuario where nombre_usuario= :nombreUsuario";
		Usuario usuario = null;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("nombreUsuario", nombreUsuario);
			usuario = this.getJdbcTemplate().queryForObject(sql, params, new UsuarioRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return usuario;
	}
	
	@Override
	public Usuario getById(int id) {
		String sql = "select id, password, nombre, apellido, telefono, grupo_id, nombre_usuario from usuario where id= :id";
		Usuario usuario = null;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", id);
			usuario = this.getJdbcTemplate().queryForObject(sql, params, new UsuarioRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return usuario;
	}

	@Override
	public void create(String nombre, String password, String apellido, String telefono, String nombre_usuario, int grupo_id,String codigo_qr, String email) {
	      String sql = "insert into usuario (password,nombre,apellido,telefono,nombre_usuario,grupo_id,codigoqr,email) VALUES (:password, :nombre,:apellido,:telefono,:nombre_usuario,:grupo_id,:codigo_qr,:email)";
	      Map <String, Object> namedParameters = new HashMap<String, Object>();   
	      namedParameters.put("password", password);
	      namedParameters.put("nombre", nombre);
	      namedParameters.put("apellido", apellido);   
	      namedParameters.put("telefono", telefono);
	      namedParameters.put("nombre_usuario", nombre_usuario);
	      namedParameters.put("grupo_id", grupo_id);
	      namedParameters.put("codigo_qr", codigo_qr);
	      namedParameters.put("email", email);
	      this.getJdbcTemplate().update(sql, namedParameters);
	      
	System.out.println("Se creo el Usuario = " + nombre);
	}
	
	@Override
	public void delete(Integer id) {
	  String SQL = "delete from usuario where id = :id";
	  SqlParameterSource namedParameters = new MapSqlParameterSource("id", Integer.valueOf(id));
	  this.getJdbcTemplate().update(SQL, namedParameters);
	  System.out.println("Se borro Usuario = " + id);
	}

	@Override
	public void update(int id,String nombre, String password, String apellido, String telefono, String nombre_usuario, int grupo_id ) {
	      String sql = "update usuario set password=:password ,nombre=:nombre,apellido=:apellido,telefono=:telefono where id=:id";
	      Map <String, Object> namedParameters = new HashMap<String, Object>();   
	      namedParameters.put("password", password);
	      namedParameters.put("nombre", nombre);
	      namedParameters.put("apellido", apellido);   
	      namedParameters.put("telefono", telefono);
	      namedParameters.put("id", id);
	      this.getJdbcTemplate().update(sql, namedParameters);
	      
	System.out.println("Se modifico el Usuario = " + nombre);
	}
	
	@Override
	public List<Usuario> listaUsuarios() {
	   String SQL = "SELECT * FROM usuario";
	   List<Usuario> usuarios = (List<Usuario>)  this.getJdbcTemplate().query(SQL, new UsuarioRowMapper());
	     return usuarios;
	}
	
	@Override
	public UsuarioTotem getByCodeqr(String codigoqr) {
		String sql = "select codigoqr,usuario.id, nombre,telefono,email,concurso_usuario.puntos_acumulados as puntos from usuario inner join concurso_usuario on usuario.id=concurso_usuario.usuario_id where codigoqr=:codigoqr";
    
		UsuarioTotem usuario = null;
		logger.info("DAO - Consultando base");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("codigoqr", codigoqr);
			usuario = this.getJdbcTemplate().queryForObject(sql, params, new UsuarioTotemRowMapper());
		} catch (Exception e) {
			System.out.println("error - intente mas tarde. " + e);
		}
		return usuario;
	}

}
