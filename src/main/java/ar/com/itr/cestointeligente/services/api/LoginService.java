package ar.com.itr.cestointeligente.services.api;

import java.util.Optional;

import ar.com.itr.cestointeligente.api.LoginRequest;
import ar.com.itr.cestointeligente.api.LogoutRequest;
import ar.com.itr.cestointeligente.api.Usuario;
import ar.com.itr.cestointeligente.entities.UsuarioTotem;

public interface LoginService {
	
	Optional<Usuario> login(LoginRequest request);

	boolean logout(LogoutRequest request);
	
	boolean isLogin(String token);

	Usuario getUsuario(String token);

	UsuarioTotem loginByQr(String codigoqr);

}
