package ar.com.itr.cestointeligente.DAO;

import java.util.List;

import ar.com.itr.cestointeligente.entities.Establecimiento;

public interface EstablecimientoDAO {

	public List<Establecimiento> getAllEst();
	public List<Establecimiento> getAllEstByAct(int ID);
	public Establecimiento getEstByID(int ID);
}
