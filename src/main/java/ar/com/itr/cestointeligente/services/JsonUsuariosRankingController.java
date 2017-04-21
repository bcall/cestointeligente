package ar.com.itr.cestointeligente.services;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.itr.cestointeligente.DAO.ConcursoDAO;
import ar.com.itr.cestointeligente.api.UsuarioRanking;
import ar.com.itr.cestointeligente.entities.Concurso;
import ar.com.itr.cestointeligente.services.api.LoginService;
import ar.com.itr.cestointeligente.services.api.UsuarioRankingService;

@Controller
@RequestMapping(value = "/services")
public class JsonUsuariosRankingController {
	private static Logger LOGGER = LoggerFactory.getLogger(JsonUsuariosRankingController.class);

	@Resource
	private LoginService loginService;
	@Resource
	private UsuarioRankingService usuarioRankingService;
	@Resource
	private ConcursoDAO concursoDao;	
	
	//TODO se podria evaluar usar aop para validar el login.
	
	@RequestMapping(value = "/ranking", method = RequestMethod.GET)
	public ResponseEntity<UsuarioRanking> getRanking(@RequestParam(value = "codigo_concurso", required = false)String concursoCode,
			                                                                     @RequestParam(value = "id", required=true) int id ) {
		try {
//			boolean isLogin = this.loginService.isLogin(token);
//			if (isLogin) {
//				Usuario usuario = this.loginService.getUsuario(token);
				return new ResponseEntity<UsuarioRanking>(this.usuarioRankingService.getRanking(id,"inicial", ""), HttpStatus.OK);
//			} else {
//				LOGGER.info("Usuario no logeado. token {}", token);
//				return new ResponseEntity<UsuarioRanking>(HttpStatus.UNAUTHORIZED);
//			}
	} catch (Exception e) {
//			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<UsuarioRanking>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@RequestMapping(value = "/concursos", method = RequestMethod.GET)
	public ResponseEntity<List<Concurso>> getConcursos(@RequestParam(value = "id", required=true) int id ) {
		try {
//			boolean isLogin = this.loginService.isLogin(token);
//			if (isLogin) {
//				Usuario usuario = this.loginService.getUsuario(token);
				return new ResponseEntity<List<Concurso>>(this.concursoDao.getByUsuarioId(id), HttpStatus.OK);
//			} else {
//				LOGGER.info("Usuario no logeado. token {}", token);
//				return new ResponseEntity<List<Concurso>>(HttpStatus.UNAUTHORIZED);
//			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<List<Concurso>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/ranking4Concurso", method = RequestMethod.GET)
	public ResponseEntity<List<ar.com.itr.cestointeligente.entities.UsuarioRanking>> getRankingAll(@RequestParam(value = "concursoid", required=false) Integer id ) {
		try {
				return new ResponseEntity<List<ar.com.itr.cestointeligente.entities.UsuarioRanking>>(this.concursoDao.getByConcurso(id), HttpStatus.OK);

	} catch (Exception e) {

		LOGGER.error(e.getMessage(), e);
		return new ResponseEntity<List<ar.com.itr.cestointeligente.entities.UsuarioRanking>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

}
