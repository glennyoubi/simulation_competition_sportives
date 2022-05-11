package game;
import java.util.ArrayList;
import java.util.List;
import spectateur.Journalist;
import spectateur.MatchListener;
import spectateur.Spectator;
import Competiton.Competitor;
import Competiton.Tournament;
import util.PowerOfTwoException;
import spectateur.Bookmaker;
/**
 * @author glennpeternicholasyoubidegnon
 *
 */
public class TournamentMain {

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
	 * @param args
	 */
	public static void main(String[] args) {
		List<Competitor> competitors = initCompetitors();
		Journalist HabibBeye = new Journalist("Habib Beye");
		Bookmaker Betclic = new Bookmaker("Betclic", competitors);
		List<MatchListener> subscribers = new ArrayList<MatchListener>();
		Tournament tournament = null;
		try {
			tournament = new Tournament(competitors,subscribers);
			tournament.addCompetitionListener(HabibBeye);
			tournament.addCompetitionListener(Betclic);
		} catch (PowerOfTwoException e) {
			System.out.println("The number of competitor must be a power of two!");;
		}
		Betclic.displayAllOdds();
		tournament.playCompetition();
		Betclic.displayAllOdds();
	}

	

}
