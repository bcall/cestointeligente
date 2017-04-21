package ar.com.itr.cestointeligente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RankingsController {

	@RequestMapping(value="/sections/rankings",method=RequestMethod.GET)
	public String getRankings(){
		return "sections/rankings";
	}
}
