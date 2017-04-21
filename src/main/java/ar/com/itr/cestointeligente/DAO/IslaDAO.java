package ar.com.itr.cestointeligente.DAO;

import java.util.List;

import ar.com.itr.cestointeligente.entities.Isla;
import ar.com.itr.cestointeligente.entities.IslaPosicion;
import ar.com.itr.cestointeligente.entities.IslaUbicacion;
import ar.com.itr.cestointeligente.entities.view.IslaView;

public interface IslaDAO {

	List<Isla> getAllIslaByProject(final int projectID);
	
	Isla getIslaById(final int islaId);

	List<IslaView> getAllIslaByProjectToView(int projectID);

	IslaView getIslaByProjectToView(int projectID, int isla_posicion_id);
	
	List<IslaUbicacion> getAllIslaByPosicion(String lon, String lat);
	
	boolean insertIsla(int grUDayProy, int inputDayProy, int comProyectId, int corrienteResiduoId, int islaPosicionId,
	Double hInput, Double hOutput, Double lastw);
	
	List<Isla> getAllIsla();
	
	boolean updateIsla(int id, int grUDayProy, int inputDayProy, int comProyectId, int corrienteResiduoId, int islaPosicionId,
					Double hInput, Double hOutput, Double lastw);
	
	List<IslaPosicion> getAllIslaPosicion();
}
