package competitionTest;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;

import Competiton.Competitor;
import Competiton.Tournament;
import spectateur.Bookmaker;
import spectateur.Journalist;
import util.PowerOfTwoException;
import spectateur.MatchListener;
public class TournamentTest extends CompetitionTest{
	
	private Tournament tournament;
	@Override
	public void createOneCompetition() {
		Journalist HabibBeye = new Journalist("Habib Beye");
		Bookmaker Betclic = new Bookmaker("Betclic",this.competitors);
		List<MatchListener> spectators = new ArrayList<MatchListener>();
		spectators.add(HabibBeye);
		spectators.add(Betclic);
		try {
			this.tournament = new Tournament(this.competitors,spectators);
		} catch (PowerOfTwoException e) {
			System.out.println("The number of competitor must be a power of two!");
		}
	};
	
	
	
	@Test
	public void playTest() {
		System.out.println();
		System.out.println("playTest");
		System.out.println();
		this.createOneCompetition();
		this.tournament.play(this.competitors);
		assertNotNull(this.tournament.getTournamentWinner());
	}
	

	@Test
	public void playOneRoundtest() {
		System.out.println();
		System.out.println("playOneRoundTest");
		System.out.println();
		List<Competitor> winnerAfterOneRound = tournament.playOneRound(competitors);
		this.createOneCompetition();
		assertEquals(2,winnerAfterOneRound.size());
		
	}
	
	@Test
	public void powerOfTwoExceptionTest() {
		Competitor toomuch = new Competitor("toomuch");
		competitors.add(toomuch);
		this.createOneCompetition();
		assertThrows(PowerOfTwoException.class, () -> {tournament.play();
		});
		
	}


}
