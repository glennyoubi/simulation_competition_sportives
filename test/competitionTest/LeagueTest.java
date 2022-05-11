package competitionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Competiton.*;
import spectateur.Bookmaker;
import spectateur.Journalist;
import spectateur.Spectator;
import util.PowerOfTwoException;
import spectateur.MatchListener;

public class LeagueTest extends CompetitionTest{
	
	
	private League league ;
	
    @Test
    public void playTest(){

        int Taille= this.competitors.size();
		this.league.play(this.competitors);
		int allpts=this.league.allpoints(this.competitors);
		Taille = Taille * (Taille-1);
		assertEquals(Taille,allpts); 

        /*int Taille= this.competitors.size();
        int allpts=this.competition.allpoints(this.competitors);*/
        /*Taille = Taille * (Taille-1);
        assertEquals(Taille,allpts);*/


    }

	@Override
	public void createOneCompetition() {
		Journalist HabibBeye = new Journalist("Habib Beye");
		Bookmaker Betclic = new Bookmaker("Betclic",this.competitors);
		List<MatchListener> spectators = new ArrayList<MatchListener>();
		spectators.add(HabibBeye);
		spectators.add(Betclic);
		this.league = new League(this.competitors,spectators);
		
	}

    



}
