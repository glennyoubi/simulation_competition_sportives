/**
 * 
 */
package competitionTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import Competiton.Competitor;
import Competiton.League;
import Competiton.Master;
import Selection.*;
import spectateur.Bookmaker;
import spectateur.Journalist;
import spectateur.Spectator;
import util.HensCompetitorsException;
import util.PowerOfTwoException;
import spectateur.MatchListener;

/**
 * @author glennpeternicholasyoubidegnon
 *
 */
class MasterTest extends CompetitionTest{
	
	private Master master;
	
	@Test
	void buildHensTest() throws HensCompetitorsException {
		Selection selectionBasic = new SelectionBasicOne();
		this.createOneCompetition(this.competitors.size(), 2, selectionBasic);
		List<League> hens = this.master.buildHens(2, this.competitors);
		assertEquals(2,hens.size());
		
	}
	
	@Test
	void buildHensExceptionTest() {
		Competitor toomuch = new Competitor("toomuch");
		this.competitors.add(toomuch);
		Selection selectionBasic = new SelectionBasicOne();
		this.createOneCompetition(this.competitors.size(), 2, selectionBasic);
		assertThrows(HensCompetitorsException.class, () -> {master.buildHens(2, competitors);
		});
	
	}
	
	@Test
	void playHensTest() throws HensCompetitorsException, PowerOfTwoException{
		Selection selectionBasic = new SelectionBasicOne();
		this.createOneCompetition(this.competitors.size(), 2, selectionBasic);
		List<Competitor> hensCheck = this.master.playHens();
		assertEquals(2,hensCheck.size());
	}
	
	@Test
	void playPhaseFinalTest() {
		Selection selectionBasic = new SelectionBasicOne();
		this.createOneCompetition(this.competitors.size(), 2, selectionBasic);
		this.master.playHens();
		Competitor winner = this.master.playPhaseFinal();
		assertNotNull(winner);
		List<Competitor> checkOnlyOneWinner = new ArrayList<Competitor>();
		checkOnlyOneWinner.add(winner);
		assertEquals(1,checkOnlyOneWinner.size());
	}

	@Override
	public void createOneCompetition(int numberOfCompetitors, int numberOfHens, Selection selection) {
		Journalist HabibBeye = new Journalist("Habib Beye");
		Bookmaker Betclic = new Bookmaker("Betclic",this.competitors);
		List<MatchListener> spectators = new ArrayList<MatchListener>();
		spectators.add(HabibBeye);
		spectators.add(Betclic);
		this.master = new Master(this.competitors,numberOfCompetitors, numberOfHens, selection, spectators);
		
	}

	@Override
	public void createOneCompetition() {
		// TODO Auto-generated method stub
		
	}

}
