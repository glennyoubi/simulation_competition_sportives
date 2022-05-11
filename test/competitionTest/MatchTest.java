package competitionTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Competiton.*;
class MatchTest {

	@Test
	void pickWinnertest() {
		Competitor c1 = new Competitor("Carlos");
		Competitor c2 = new Competitor("Roberto");
		Match match = new Match(c1,c2);
		assertNotNull(match.pickWinner());
	}

}
