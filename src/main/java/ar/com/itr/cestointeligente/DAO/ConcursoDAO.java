package ar.com.itr.cestointeligente.DAO;

import java.util.List;

import ar.com.itr.cestointeligente.entities.Concurso;
import ar.com.itr.cestointeligente.entities.ConcursoDeposito;
import ar.com.itr.cestointeligente.entities.ConcursoPuntosVerdes;
import ar.com.itr.cestointeligente.entities.ConcursoUsuario;

public interface ConcursoDAO {
	List<Concurso> getByUsuarioId(int id);
	Concurso getByCodigo(String codigo);
	
	ConcursoUsuario getConcursoUsuario(int usuarioId, int concurso_id);
	List<ConcursoUsuario> getConcursoUsuario(int concurso_id);
	boolean updatePuntos(int concursoId, int usuarioId, int puntos);
	
	List<ConcursoDeposito> getConcursoDespositos(int usuarioId, int concurso_id);
	boolean insertConcursoDeposito(ConcursoDeposito concurso);
	
	List<Concurso> listaConcurso();
	List<ar.com.itr.cestointeligente.entities.UsuarioRanking> getByConcurso(Integer id);
	ConcursoPuntosVerdes getCursoPuntosVerdesById(int id);
	ConcursoPuntosVerdes getCursoPuntosVerdesById(int concurso_id, int tipo_RESIDUO_ID);
}