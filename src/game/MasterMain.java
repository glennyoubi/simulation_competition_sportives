package game;

import java.util.ArrayList;
import java.util.List;
import Selection.*;
import spectateur.Bookmaker;
import spectateur.Journalist;
import spectateur.MatchListener;
import Competiton.Competitor;
import util.PowerOfTwoException;
import Competiton.Master;
public class MasterMain{
	
	
	/*
	 * Initialize the list of competitors for the tournament.
	 * @return The list of competitors wbhich will be use for play the Master.
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
	
	
	public static void main(String[] args) {
		Selection selection = new SelectionBasicTwo();
		List<Competitor> comps = initCompetitors();
		Journalist HabibBeye = new Journalist("Habib Beye");
		Bookmaker Betclic = new Bookmaker("Betclic", comps);
		List<MatchListener> subscribers = new ArrayList<MatchListener>();
		int numberOfCompetitors = comps.size();
		Master master = new Master(comps, numberOfCompetitors, 2, selection, subscribers);
		master.addCompetitionListener(HabibBeye);
		master.addCompetitionListener(Betclic);
		try{
			Betclic.displayAllOdds();
			master.play();
			Betclic.displayAllOdds();

		}catch(PowerOfTwoException e){
			System.out.println("The number of competitor must be a power of two!");
		}

	}
}
