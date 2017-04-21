package ar.com.itr.cestointeligente.DAOImpl.utils;

public class IndexGraphQueryBuilder {
	
	public String buildQueryByDay(final IndexGraphQueryCriteria filter) {
		if (filter == null) {
			return null;
		}
//		StringBuffer stringBuffer = new StringBuffer("SELECT DATE,SUM(DAY_IN) AS INPUT FROM proyect_med  PM ");
//	stringBuffer.append("inner join cesto on cesto.id = PM.P_ID  inner join tipo_residuo TP on TP.ID = cesto.tipo_residuo_id ");
//		stringBuffer.append("inner join corriente_residuo CR on CR.id = TP.corriente_residuo_id ");		
//		stringBuffer.append("inner join isla_cesto IC on IC.cesto_id = cesto.id ");
//		stringBuffer.append("inner join isla  on IC.isla_id = isla.id ");
//		stringBuffer.append("inner join comp_proyect  on isla.comp_proyect_id = comp_proyect.id ");		
//		stringBuffer.append((String.format("WHERE DATE > DATE_SUB(NOW(), INTERVAL 30 DAY) and CR.ID = %1$d ", filter.getCorrienteResiduoID())));
//		stringBuffer.append(this.builderConditionsBy(filter));
//		stringBuffer.append("GROUP BY DATE ");
//		return stringBuffer.toString();		
// tener en cuenta el periodo utilizado para el calculo, quizas hay que tomar el del proyecto
		StringBuffer stringBuffer = new StringBuffer("SELECT DATE,SUM(DAY_IN) AS INPUT FROM cesto_med CM ");
		stringBuffer.append("inner join cesto on cesto.id = CM.cesto_ID  inner join tipo_residuo TP on TP.ID = CM.tipo_residuo_id ");
		stringBuffer.append("inner join corriente_residuo CR on CR.id = CM.corriente_residuo_id ");		
		stringBuffer.append("inner join isla_cesto IC on IC.cesto_id = cesto.id ");
		stringBuffer.append("inner join isla  on IC.isla_id = isla.id ");
		stringBuffer.append("inner join comp_proyect  on CM.proyecto_id = comp_proyect.id ");		
		stringBuffer.append((String.format("WHERE DATE > DATE_SUB(NOW(), INTERVAL 30 DAY) and CR.ID = %1$d ", filter.getCorrienteResiduoID())));
		stringBuffer.append(this.builderConditionsBy(filter));
		stringBuffer.append("GROUP BY DATE ");
		return stringBuffer.toString();		
	}	

	public String buildQueryByTotal(final IndexGraphQueryCriteria filter) {
		if (filter == null) {
			return null;
		}
//		StringBuffer stringBuffer = new StringBuffer("SELECT SUM(((DATEDIFF(NOW()+INTERVAL 1 MONTH,NOW() )*CP.GR*CP.USUARIOS)/1000)) ");
//		stringBuffer.append("AS proy_total ");
//		stringBuffer.append("FROM (SELECT GR_U_DAY_PROY AS GR, INPUT_DAY_PROY AS INPUT, id as isla_id, USERS_ISLA AS usuarios, comp_proyect_id  FROM isla) AS CP ");
//		stringBuffer.append("inner join cesto on cesto.id = CP.isla_id  inner join tipo_residuo TP on TP.ID = cesto.tipo_residuo_id ");
//		stringBuffer.append("inner join corriente_residuo CR on CR.id = TP.corriente_residuo_id ");		
//		stringBuffer.append("inner join isla_cesto IC on IC.cesto_id = cesto.id ");
//		stringBuffer.append("inner join isla  on IC.isla_id = isla.id ");
//		stringBuffer.append("inner join comp_proyect  on cp.comp_proyect_id = comp_proyect.id ");		
		StringBuffer stringBuffer = new StringBuffer("SELECT SUM(((DATEDIFF(NOW()+INTERVAL 1 MONTH,NOW())*ic.GR_U_DAY_PROY*ISL.USUARIOS)/1000))");
		stringBuffer.append(" AS proy_total ");
		stringBuffer.append(" FROM (SELECT GR_U_DAY_PROY AS GR, INPUT_DAY_PROY AS INPUT, id AS isla_id, USERS_ISLA AS usuarios, comp_proyect_id FROM isla) AS isl");
		stringBuffer.append(" INNER JOIN comp_proyect ON isl.comp_proyect_id = comp_proyect.id");
		stringBuffer.append(" INNER JOIN isla_cesto IC ON isl.isla_id = ic.isla_id");
		stringBuffer.append(" INNER JOIN cesto on ic.CESTO_ID  = cesto.id");
		stringBuffer.append(" INNER JOIN tipo_residuo TP ON cesto.tipo_residuo_id = tp.id");
		stringBuffer.append(" INNER JOIN corriente_residuo CR on CR.id = TP.corriente_residuo_id ");		
		stringBuffer.append((String.format("WHERE  CR.ID = %1$d ", filter.getCorrienteResiduoID())));
		stringBuffer.append(this.builderConditionsBy(filter));
		return stringBuffer.toString();		
	}
	
	//Metodos privados
	
	private StringBuffer builderConditionsBy(IndexGraphQueryCriteria filter) {
		StringBuffer stringBuffer = new StringBuffer();
		if (filter.getEstablecimientoID() != null && filter.getEstablecimientoID() != -1) {
			stringBuffer.append(String.format(" comp_proyect.ESTAB_ID  = %1$d and ", filter.getEstablecimientoID()));
		}
		
		if (filter.getIslaID() != null && filter.getIslaID() != -1) {
			stringBuffer.append(String.format(" isla.id  = %1$d and ", filter.getIslaID()));
		}
		
		if (filter.getProyectoID() != null && filter.getProyectoID() != -1) {
			stringBuffer.append(String.format(" comp_proyect.id  = %1$d and ", filter.getProyectoID()));
		}
		
		if (filter.getTipoResiduoID() != null && filter.getTipoResiduoID() != -1) {
			stringBuffer.append(String.format(" TP.id  = %1$d  and ", filter.getTipoResiduoID()));			
		}
		
		if (stringBuffer.length() > 0) {
			stringBuffer.insert(0, " AND ");
			stringBuffer.replace(stringBuffer.length() - 4, stringBuffer.length(), " ");
		}
		
		return stringBuffer;
	}

}
