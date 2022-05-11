package game;

import java.util.ArrayList;
import java.util.List;

import Competiton.Competitor;
import Competiton.League;
import spectateur.*;

public class LeagueMain {

	/**
	 * Initialize the list of competitors for the tournament.
	 * @return The list of competitors which will be use for play the tournament.
	 */
	public static List<Competitor> initCompetitors () {
		Competitor roger = new Competitor("Roger");
		Competitor marco = new Competitor("Marco");
		Competitor rafael = new Competitor("Rafael");
		Competitor lonzo = new Competitor("Lonzo");
		Competitor serena = new Competitor("Serena");
		Competitor dulcy = new Competitor("Dulcy");
		Competitor maty = new Competitor("Maty");
		Competitor chiara = new Competitor("Chiara");
		List<Competitor> competitors = new ArrayList<Competitor>();
		competitors.add(roger);
		competitors.add(marco);
		competitors.add(rafael);
		competitors.add(serena);
		competitors.add(dulcy);
		competitors.add(maty);
		competitors.add(chiara);
		competitors.add(lonzo);
		return competitors;
	}
	
	/**
	 * Initialize the list of competitors for the tournament.
	 * @return The list of competitors which will be use for play the tournament.
	 */
	public static List<MatchListener> initListener() {
		
		List<MatchListener> competitors = new ArrayList<MatchListener>();
		return competitors;
	}

	public static void main(String[] args) {
		List<Competitor> competitors = initCompetitors();
		Journalist HabibBeye = new Journalist("Habib Beye");
		Bookmaker Betclic = new Bookmaker("Betclic", competitors);
		List<MatchListener> subscribers = new ArrayList<MatchListener>();
		League league = new League(competitors, subscribers);
		league.addCompetitionListener(HabibBeye);
		league.addCompetitionListener(Betclic);
		Betclic.displayAllOdds();
		league.playCompetition();
		Betclic.displayAllOdds();
	}

}
