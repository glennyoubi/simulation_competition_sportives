package Competiton;

import java.util.ArrayList;
import java.util.List;

import spectateur.MatchListener;
import spectateur.Spectator;

import java.util.Iterator;

import util.PowerOfTwoException;
/*
 * This class represents a tournament which is a particular of competition.
 * Characterised by the fact that it is a knockout competition.  
 * 
 * @authors Glenn Youbi Degnon & Mohamed Kouriat
 * @version 1.0
 */


public class Tournament extends Competition{
	
	/*Winning Team of the tournament*/
	private Competitor tournamentWinner;
	
	
	/**
	 * @return
	 */
	public Competitor getTournamentWinner() {
		return tournamentWinner;
	}



	/**
	 * @param tournamentWinner
	 */
	public void setTournamentWinner(Competitor tournamentWinner) {
		this.tournamentWinner = tournamentWinner;
	}



	/**
	 * Creates a tournament with a specific list of competitors 
	 * And a specific list of spectator.
	 * @param competitors The list t of competitors that will compete.
	 * @param spects The list of spectators that will follow the tournament.
	 * @throws PowerOfTwoException Thrown if the number of competitors to play the competition is not a power of two.
	 */
	public Tournament(List <Competitor> competitors, List<MatchListener> spects) throws PowerOfTwoException {
		super(competitors,spects);
		if(!isPowerOfTwo(competitors.size())) {
			throw new PowerOfTwoException("	Thd number of competitor must be a power of two!");
		}
		this.tournamentWinner = null;
	}
	
	/**
	 * Creates a tournament with a specific list of competitors 
	 * @param competitors The list t of competitors that will compete.
	 * @throws PowerOfTwoException Thrown if the number of competitors to play the competition is not a power of two.
	 */
	public Tournament(List <Competitor> competitors) throws PowerOfTwoException {
		super(competitors);
		if(!isPowerOfTwo(competitors.size())) {
			throw new PowerOfTwoException("	Thd number of competitor must be a power of two!");
		}
		this.tournamentWinner = null;
	}



/**
 * This methods play the tournament by making play multiples round successively until a winner is found.
 * 
 */
@Override
public void play (List<Competitor> competitors){
	List<Competitor> firstRoundWinningTeams = playOneRound(competitors);
	while(firstRoundWinningTeams.size()>1) {
		firstRoundWinningTeams = playOneRound(firstRoundWinningTeams);
	}
	this.setTournamentWinner(firstRoundWinningTeams.get(0));
	System.out.println("The winner of the tournament is "+ this.tournamentWinner.getName()+" !");
	this.displayRanking();
	
}


/**
 * This methods play a round of the tournament by having all the teams,of the list competitors, 
 * compete against each other 
 * @param competitors List of teams that compete
 * @return a list that only contains the winners of the round played.
 */
public List<Competitor> playOneRound (List<Competitor> competitors){
	List<Competitor> winnerAfterOneRound = new ArrayList<Competitor>();
	Iterator<Competitor> it = competitors.iterator();
	while (it.hasNext()) {
		Competitor c1 = it.next();
		Competitor c2 = it.next();
		winnerAfterOneRound.add(this.playMatch(c1, c2));
		
	}
	return winnerAfterOneRound;
	}

/**
 * Check if a number is a power of two.
 * @param The integer on which the verification is done.
 */
public boolean isPowerOfTwo(int n) {
	return (n & (n - 1)) == 0 & n>1;
}

}