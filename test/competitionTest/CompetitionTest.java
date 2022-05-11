/**
 * 
 */
package competitionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Competiton.Competition;
import Competiton.Competitor;
import Competiton.MockCompetition;
import Selection.Selection;
import spectateur.*;


/**
 * @author glennpeternicholasyoubidegnon
 *
 */
public abstract class CompetitionTest {
	
	protected Competition competition;
	protected List<Competitor> competitors;
	protected List<Spectator> specs;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		Competitor roger = new Competitor("Roger");
		Competitor marco = new Competitor("Marco");
		Competitor rafael = new Competitor("Rafael");
		Competitor lonzo = new Competitor("Lonzo");
		this.competitors = new ArrayList<Competitor>();
		/*Journalist HabibBeye = new Journalist("Habib Beye");
		Bookmaker Betclic = new Bookmaker("Betclic",this.competitors);
		List<Spectator> spectators = new ArrayList<Spectator>();
		spectators.add(HabibBeye);
		spectators.add(Betclic);*/
		competitors.add(roger);
		competitors.add(marco);
		competitors.add(rafael);
		competitors.add(lonzo);
		this.createOneCompetition();
		
	}
	
	@Test
	public void playCompetitionTest() {
		MockCompetition competitionMock = new MockCompetition(this.competitors);
		System.out.println();
		System.out.println("playCompetitionTest");
		System.out.println();
		int test = competitionMock.getTest();
		competitionMock.playCompetition();
		assertEquals(test + 1 , competitionMock.getTest());
	}
	
	public abstract void createOneCompetition();

	public void createOneCompetition(int numberOfCompetitors, int numberOfHens, Selection selection) {
		// TODO Auto-generated method stub
		
	}

	

}
