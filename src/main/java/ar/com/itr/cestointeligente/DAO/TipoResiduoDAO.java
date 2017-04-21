package ar.com.itr.cestointeligente.DAO;

import java.util.List;

import ar.com.itr.cestointeligente.entities.TipoResiduo;

public interface TipoResiduoDAO {
	
	List<TipoResiduo> getAllTipoResiduoBy(int islaID);	

	List<TipoResiduo> getAllTipoResiduo();
}
