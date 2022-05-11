package observerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spectateur.*;
import Competiton.Competitor;
import Competiton.Match;

class OberserTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void updateTest() {
		Competitor competitor1 = new Competitor("First");
		Competitor competitor2 = new Competitor("Second");
		Match match = new Match(competitor1, competitor2);
		MockSpectator observerMock = new MockSpectator();
		int test = observerMock.getTest();
		observerMock.update(match);
		assertEquals(1 +test , observerMock.getTest());
	}
}
