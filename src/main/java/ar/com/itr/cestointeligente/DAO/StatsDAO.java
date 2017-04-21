package ar.com.itr.cestointeligente.DAO;

import java.util.List;
import java.util.Map;

import ar.com.itr.cestointeligente.entities.Project;
import ar.com.itr.cestointeligente.entities.RankingTableItem;

public interface StatsDAO {
	
	public Map<String,Integer> getIndexStats();
	public List<Map<String, Object>> getProyectCompletion();
	public List<RankingTableItem> getRankingItems(int value);
	public List<Project> getWeightAlarms();
}
