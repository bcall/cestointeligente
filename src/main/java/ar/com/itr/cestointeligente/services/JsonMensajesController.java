package ar.com.itr.cestointeligente.services;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.itr.cestointeligente.DAO.CestoDAO;
import ar.com.itr.cestointeligente.DAO.ConcursoDAO;
import ar.com.itr.cestointeligente.DAOImpl.MessageDaoImp;
import ar.com.itr.cestointeligente.api.Mensaje;
import ar.com.itr.cestointeligente.api.Mensajes;
import ar.com.itr.cestointeligente.api.Usuario;
import ar.com.itr.cestointeligente.api.UsuarioRanking;
import ar.com.itr.cestointeligente.entities.Cesto;
import ar.com.itr.cestointeligente.entities.ConcursoDeposito;
import ar.com.itr.cestointeligente.entities.ConcursoPuntosVerdes;
import ar.com.itr.cestointeligente.services.api.LoginService;

@Controller
@RequestMapping(value = "/services")
public class JsonMensajesController {
	private static Logger LOGGER = LoggerFactory.getLogger(JsonMensajesController.class);

	@Resource
	private LoginService loginService;
	@Resource
	private ConcursoDAO concursoDao;
	@Resource
	private MessageDaoImp msgDAO;
	@Resource
	private CestoDAO cestoDao;
	

	@RequestMapping(value = "/mensaje", method = RequestMethod.GET)
	public ResponseEntity<UsuarioRanking> getRanking(
			@RequestParam(value = "userid") int user_id,
			@RequestParam(value = "cid") int compostera_id, @RequestParam(value = "w") Double peso,
			@RequestParam(value = "ev") int evento,
			@RequestParam(value = "conid", defaultValue = "1") int concurso_id) {
		try {
			LOGGER.info("SERVICE - Mensaje recibido");
//			boolean isLogin = this.loginService.isLogin(token);
//			if (isLogin) {
//				Usuario usuario = this.loginService.getUsuario(token);
				peso = peso / 1000;
				boolean result = msgDAO.insertMessage(compostera_id, peso, evento);
				if (result) {					
	
					ConcursoDeposito concursoDeposito = new ConcursoDeposito();
					concursoDeposito.setConcursoId(concurso_id);
					concursoDeposito.setFecha(new Date());
					concursoDeposito.setPeso(peso);
					concursoDeposito.setUsuarioId(user_id);
					//TODO completar
					concursoDeposito.setIslaId(1);
					concursoDeposito.setTipoResiduoId(5);
					
					this.concursoDao.insertConcursoDeposito(concursoDeposito);
					
					return new ResponseEntity<UsuarioRanking>(HttpStatus.CREATED);
				} else {
					return new ResponseEntity<UsuarioRanking>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
//			} else {
//				LOGGER.info("Usuario no logeado. token {}", token);
//				return new ResponseEntity<UsuarioRanking>(HttpStatus.UNAUTHORIZED);
//			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<UsuarioRanking>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/mensaje", method = RequestMethod.POST)
	public ResponseEntity<Void> putMessage(@RequestBody Mensajes mensajes) {
		try {
			LOGGER.info("SERVICE - Mensaje recibido");
//			boolean isLogin = this.loginService.isLogin(mensajes.getToken());
//			if (isLogin) {
				for (Mensaje mensaje : mensajes.getMessages()) {
					this.addMensaje(mensaje.getUsuarioId(), mensaje.getComposteraId(), mensaje.getPeso(),
							mensaje.getEvento(), mensaje.getConcursoId());
				}
//			} else {
//				LOGGER.info("Usuario no logeado. token {}", mensajes.getToken());
//				return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
//			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// *** Private Method ***//

	private ResponseEntity<Void> addMensaje(int usuarioId, int compostera_id, double peso, int evento, int concurso_id) {
//		Usuario usuario = this.loginService.getUsuario(token);
		//peso = peso / 1000;
		boolean result = msgDAO.insertMessage(compostera_id, peso, evento);
		if (result) {
			Cesto cesto = this.cestoDao.getCestoByID(compostera_id);
			ConcursoDeposito concursoDeposito = new ConcursoDeposito();
			concursoDeposito.setConcursoId(concurso_id);
			concursoDeposito.setFecha(new Date());
			concursoDeposito.setPeso(peso);
			concursoDeposito.setUsuarioId(usuarioId);
			ConcursoPuntosVerdes cursoPuntosVerdes = this.concursoDao.getCursoPuntosVerdesById(concurso_id,
					cesto.getTIPO_RESIDUO_ID());
			int puntos = (int) (cursoPuntosVerdes.getPuntos() * peso);
			concursoDeposito.setPuntos(puntos);
			concursoDeposito.setTipoResiduoId(cesto.getTIPO_RESIDUO_ID());
			concursoDeposito.setIslaId(this.cestoDao.getIslaIdByCestoId(compostera_id));

			this.concursoDao.insertConcursoDeposito(concursoDeposito);
			this.concursoDao.updatePuntos(concurso_id, usuarioId, puntos);

			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

