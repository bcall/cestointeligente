package ar.com.itr.cestointeligente.services.api.imp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.itr.cestointeligente.DAO.ConcursoDAO;
import ar.com.itr.cestointeligente.DAO.IslaDAO;
import ar.com.itr.cestointeligente.api.DepositoUsuario;
import ar.com.itr.cestointeligente.api.UsuarioRanking;
import ar.com.itr.cestointeligente.entities.Concurso;
import ar.com.itr.cestointeligente.entities.ConcursoDeposito;
import ar.com.itr.cestointeligente.entities.ConcursoUsuario;
import ar.com.itr.cestointeligente.entities.Isla;
import ar.com.itr.cestointeligente.entities.Usuario;
import ar.com.itr.cestointeligente.services.api.UsuarioRankingService;

public class UsuarioRankingServiceImp implements UsuarioRankingService {

	private Logger LOGGER = LoggerFactory.getLogger(UsuarioRankingServiceImp.class);
	
	private ConcursoDAO consursoDao;	
	private IslaDAO islaDao;

	@Override
	public UsuarioRanking getRanking(int usuarioId, String codigoConcurso, String token) {
		if (codigoConcurso == null) {
			LOGGER.debug("No se recibe el codigo del concurso para el userid {}", usuarioId);
			List<Concurso> concursos = this.consursoDao.getByUsuarioId(usuarioId);
			if (concursos != null && !concursos.isEmpty()) {
				codigoConcurso = concursos.get(0).getCodigo();
			}
		}
		Concurso concurso = this.consursoDao.getByCodigo(codigoConcurso);
		ConcursoUsuario concursoUsuario = this.consursoDao.getConcursoUsuario(usuarioId, concurso.getId());
		List<ConcursoUsuario> integrantes = this.consursoDao.getConcursoUsuario(concurso.getId());

		UsuarioRanking usuarioRanking = new UsuarioRanking();
		usuarioRanking.setPuesto(concursoUsuario.getPosicionFinal());
		usuarioRanking.setTotalPuntos(concursoUsuario.getPuntosAcumulados());
		usuarioRanking.setTotalParticipantes(integrantes.size());
		usuarioRanking.setToken(token);
		
		usuarioRanking.add(transformarDepositos(usuarioId, concurso));

		return usuarioRanking;
	}
	
	//*** Private Methods ***//

	private List<DepositoUsuario> transformarDepositos(int usuarioId, Concurso concurso) {
		List<ConcursoDeposito> concursoDespositos = this.consursoDao.getConcursoDespositos(usuarioId, concurso.getId());
		ConcursoDeposito concursoDeposito;
		DepositoUsuario deposito;
		List<DepositoUsuario> listaDepositos = new ArrayList<DepositoUsuario>();
		if (concursoDespositos != null) {
			Iterator<ConcursoDeposito> iterator = concursoDespositos.iterator();
			while (iterator.hasNext()) {
				concursoDeposito = iterator.next();
				
				deposito = new DepositoUsuario();
				deposito.setFecha(concursoDeposito.getFecha());
				deposito.setPuntos(concursoDeposito.getPuntos());
				Isla isla = this.islaDao.getIslaById(concursoDeposito.getIslaId());
				String lugar = isla != null ? isla.getISLA_POSICION() : "";
				deposito.setLugar(lugar);
				listaDepositos.add(deposito);
			}
		}
		return listaDepositos;
	}
	
	//*** GETTERS AND SETTERS

	public ConcursoDAO getConsursoDao() {
		return consursoDao;
	}

	public void setConsursoDao(ConcursoDAO consursoDao) {
		this.consursoDao = consursoDao;
	}

	public IslaDAO getIslaDao() {
		return islaDao;
	}

	public void setIslaDao(IslaDAO islaDao) {
		this.islaDao = islaDao;
	}

	@Override
	public List<Usuario> getRankingByConcurso(int concursoid) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
