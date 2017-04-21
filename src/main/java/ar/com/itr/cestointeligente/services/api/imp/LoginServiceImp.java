package ar.com.itr.cestointeligente.services.api.imp;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.itr.cestointeligente.DAO.UsuarioDAO;
import ar.com.itr.cestointeligente.DAO.UsuarioSesionDAO;
import ar.com.itr.cestointeligente.api.LoginRequest;
import ar.com.itr.cestointeligente.api.LogoutRequest;
import ar.com.itr.cestointeligente.api.Usuario;
import ar.com.itr.cestointeligente.entities.EstadoSesion;
import ar.com.itr.cestointeligente.entities.UsuarioSesion;
import ar.com.itr.cestointeligente.entities.UsuarioTotem;
import ar.com.itr.cestointeligente.services.api.LoginService;
import ar.com.itr.cestointeligente.utils.PasswordUtils;

public class LoginServiceImp implements LoginService {
	private static Logger LOGGER = LoggerFactory.getLogger(LoginServiceImp.class);
	private UsuarioDAO usuarioDao;
	private UsuarioSesionDAO usuarioSesionDao;

	@Override
	public Optional<Usuario> login(LoginRequest request) {
		String password = PasswordUtils.encriptar(request.getPassword());
		ar.com.itr.cestointeligente.entities.Usuario usuarioEntidad = this.usuarioDao
				.getByNombreUsuarioYPassword(request.getUsername(), password);

		if (usuarioEntidad != null) {
			String token = UUID.randomUUID().toString();
			boolean estado = this.usuarioSesionDao.insertMessage(usuarioEntidad.getNombreUsuario(), token,
					EstadoSesion.ACTIVA, new Date(), usuarioEntidad.getId());
			if (estado) {
				return Optional.of(this.transformarUsuarioApi(usuarioEntidad, token));
			} else {
				LOGGER.error("Error al guardar la sesión del usuario {}", request.getUsername());
			}
		}

		return Optional.empty();
	}

	@Override
	public boolean logout(LogoutRequest request) {
		boolean status = false;
		try {
			status = this.usuarioSesionDao.closeSession(request.getToken(), new Date());
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		return status;
	}

	@Override
	public boolean isLogin(String token) {
		UsuarioSesion sesion = this.getUsuarioSesionDao().getByToken(token);
		boolean isLogin = false;
		if (sesion != null) {
			isLogin = sesion.getEstado() == EstadoSesion.ACTIVA ? true : false;
		}

		return isLogin;
	}

	@Override
	public Usuario getUsuario(String token) {
		UsuarioSesion sesion = this.getUsuarioSesionDao().getByToken(token);
		return this.transformarUsuarioApi(this.usuarioDao.getByNombreUsuario(sesion.getNombreUsuario()), token);
	}

	// *** Getters and Setters

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public UsuarioSesionDAO getUsuarioSesionDao() {
		return usuarioSesionDao;
	}

	public void setUsuarioSesionDao(UsuarioSesionDAO usuarioSesionDao) {
		this.usuarioSesionDao = usuarioSesionDao;
	}

	// Private Methods

	private Usuario transformarUsuarioApi(ar.com.itr.cestointeligente.entities.Usuario usuarioEntidad, String token) {
		Usuario usuario = new Usuario();
		usuario.setApellido(usuarioEntidad.getApellido());
		usuario.setNombre(usuarioEntidad.getNombre());
		usuario.setNombreUsuario(usuarioEntidad.getNombreUsuario());
		usuario.setTelefono(usuarioEntidad.getTelefono());
		usuario.setToken(token);
		usuario.setId(usuarioEntidad.getId());

		return usuario;
	}
	
	@Override
	public UsuarioTotem loginByQr(String codigoqr) {
		
		UsuarioTotem UsuarioTotem = this.usuarioDao.getByCodeqr(codigoqr);
		return UsuarioTotem;

	}

}
