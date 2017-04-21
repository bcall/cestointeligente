package ar.com.itr.cestointeligente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.itr.cestointeligente.DAOImpl.StatsDAOImp;
import ar.com.itr.cestointeligente.entities.RankingTableItem;

@RestController
@RequestMapping(value = "/services")
public class RankingService {
	@Autowired
	StatsDAOImp stsDAO;
	@RequestMapping(value = "/rankingTableData", method = RequestMethod.GET,headers="Accept=application/json")
	public List<RankingTableItem> getRanking(@RequestParam(value="val") int value){
		
		List<RankingTableItem> data = stsDAO.getRankingItems(value);
		
		return data;
	}
}
