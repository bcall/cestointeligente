package ar.com.itr.cestointeligente.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.com.itr.cestointeligente.api.LoginRequest;
import ar.com.itr.cestointeligente.api.LogoutRequest;
import ar.com.itr.cestointeligente.api.Usuario;
import ar.com.itr.cestointeligente.services.api.LoginService;

@Controller
@RequestMapping(value = "/services")
public class JsonLoginController {

	private Logger LOGGER = LoggerFactory.getLogger(JsonLoginController.class);

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Usuario> login(@RequestBody LoginRequest request) {
		try {
			Optional<Usuario> usuario = this.loginService.login(request);
			if (usuario.isPresent()) {
				return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
			} else {
				LOGGER.info("Usuario no autorizado {} ", request.getUsername());
				return new ResponseEntity<Usuario>(HttpStatus.UNAUTHORIZED);
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<Void> logout(@RequestBody LogoutRequest request) {
		try {
			boolean status = this.loginService.logout(request);
			if (status) {
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
