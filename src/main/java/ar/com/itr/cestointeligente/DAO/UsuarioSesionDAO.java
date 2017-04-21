package ar.com.itr.cestointeligente.DAO;

import java.util.Date;

import ar.com.itr.cestointeligente.entities.EstadoSesion;
import ar.com.itr.cestointeligente.entities.UsuarioSesion;

public interface UsuarioSesionDAO {
	UsuarioSesion getByToken(String token);

	boolean insertMessage(String nombreUsuario, String token, EstadoSesion estado, Date inicio, int usuarioId);

	boolean closeSession(String token, Date fin);

}