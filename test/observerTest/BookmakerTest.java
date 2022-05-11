package observerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Competiton.*;
import spectateur.Bookmaker;
import spectateur.Spectator;
import util.PowerOfTwoException;

import java.util.ArrayList;
import java.util.List;
import spectateur.MatchListener;
class BookmakerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void oddsUpdateTest() {
		List<Competitor> comps = new ArrayList<Competitor>();
		List<MatchListener> specs = new ArrayList<MatchListener>();
		Competitor c1 = new Competitor("c1");
		Competitor c2 = new Competitor("c2");
		comps.add(c1);
		comps.add(c2);
		Bookmaker bm = new Bookmaker("Betclic",comps);
		specs.add(bm);
		Competition compet = null;
		try {
			compet = new Tournament(comps,specs);
		} catch (PowerOfTwoException e) {
			e.printStackTrace();
		}
		int oddC1Before = bm.getCompetitorOdd(c1);
		int oddC2Before = bm.getCompetitorOdd(c2);
		compet.playMatch(c1,c2);
		Competitor winner = compet.getMatch().getWinner();
		Competitor loser = compet.getMatch().getLoser();
		if(winner == c1) {
			assertEquals(bm.getCompetitorOdd(c1), oddC1Before - 1);
			assertEquals(bm.getCompetitorOdd(c2), oddC2Before + 1);
		}
		else {
			assertEquals(bm.getCompetitorOdd(c1), oddC1Before + 1);
			assertEquals(bm.getCompetitorOdd(c2), oddC2Before - 1);
		}
		
		
	}

}
