package ar.com.itr.cestointeligente.services.api;

import java.util.List;

import ar.com.itr.cestointeligente.api.UsuarioRanking;
import ar.com.itr.cestointeligente.entities.Usuario;

public interface UsuarioRankingService {
	UsuarioRanking getRanking(int usuarioId, String codigoConcurso, String token);

	List<Usuario> getRankingByConcurso(int concursoid);
}
