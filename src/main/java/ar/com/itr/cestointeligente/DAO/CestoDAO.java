package ar.com.itr.cestointeligente.DAO;

import java.util.List;

import ar.com.itr.cestointeligente.entities.Cesto;
import ar.com.itr.cestointeligente.entities.view.CestoNotAliveView;
import ar.com.itr.cestointeligente.entities.view.CestoView;

public interface CestoDAO {
	Cesto getCestoByID(int id);
	List<Cesto> getAllCestos();
	int getCountNotAliveCesto();
	List<CestoNotAliveView> getNotAliveCesto();
	List<CestoView> getCestoByIslaId(int proid,int ubiId);
	int getIslaIdByCestoId(int cestoId);
}