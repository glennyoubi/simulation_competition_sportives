package spectateur;

import Competiton.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

public class Bookmaker implements Spectator, CompetitionListener, MatchListener{
	
	
	/**
	 * The name of bookmaker.
	 */
	private String name;
	
	/**
	 * The map that contains all the competitors and their odds.
	 */
	private Map<Competitor,Integer> CompetitorsAndOdds;
	
	/**
	 * Creates a bookmaker with a name
	 * and initialize the map CompetitorsAndOdds with the lost comps.
	 * @param name The name of the bookmaker
	 * @param comps the list of competitors.
	 */
	public Bookmaker(String name, List<Competitor> comps) {
		this.name = name;
		this.CompetitorsAndOdds = this.createBookmakerMap(comps);
	}
	
	/**
	 * Returns the name of the bookmaker.
	 * @return he name of the bookmaker.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Assign a name to the bookmaker.
	 * @param name the name which is assigned.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the map of CompetitorsAndOdds. 
	 * @return the map of CompetitorsAndOdds.
	 */
	public Map<Competitor, Integer> getCompetitorsAndOdds() {
		return CompetitorsAndOdds;
	}

	/**
	 * Set the map of competitorsAndOdds.
	 * @param competitorsAndOdds the map to set.
	 */
	public void setCompetitorsAndOdds(Map<Competitor, Integer> competitorsAndOdds) {
		CompetitorsAndOdds = competitorsAndOdds;
	}
	
	/**
	 * This method modified the behavior of the soectator
	 * Due to the match result.
	 * @param match Match that modified the behavior of the spectator.
	 */
	/**
	 *
	 */
	@Override
	public void update(Match match) {
		int oldOddTeam1 = this.CompetitorsAndOdds.get(match.getTeam1());
		int oldOddTeam2 = this.CompetitorsAndOdds.get(match.getTeam2());
		System.out.println("The Bookmaker "+this.getName()+" show you the following game");
		System.out.println("\\ "+match.getTeam1().getName()+" ( Odd "+oldOddTeam1+") vs "+match.getTeam2().getName()+"( Odd "+oldOddTeam2+") "+" -> "+match.getWinner().getName()+" wins ! /");
		this.reduceOdd(match.getWinner());
		this.increaseOdd(match.getLoser());
		System.out.println("The bookmaker "+this.name+" odds after the game are");
		System.out.println("| "+match.getWinner().getName()+" odd is now"+this.CompetitorsAndOdds.get(match.getWinner())+" |");
		System.out.println("| "+match.getLoser().getName()+" odd is now"+this.CompetitorsAndOdds.get(match.getLoser())+" |");
	}

	/**
	 * This methods updates the behavior of the bookmaker by 
	 * Displaying the following match and his winner
	 * And updating the odd of each competitor.
	 */
	@Override
	public void matchPalyed(MatchEvent e) {
		Match updatingMatch = (Match) e.getSource();
		Competitor team1 = updatingMatch.getTeam1();
		Competitor team2 = updatingMatch.getTeam2();
		Competitor winner = updatingMatch.getWinner(); 
		Competitor loser = updatingMatch.getLoser();
		int oldOddTeam1 = CompetitorsAndOdds.get(team1);
		int oldOddTeam2 = CompetitorsAndOdds.get(team2);
		System.out.println("|--------------------------------------------------------------------|");
		System.out.println("The Bookmaker "+this.getName()+" show you the following game");
		System.out.println("| "+team1.getName()+"(Odd "+oldOddTeam1+") vs "+team2.getName()+"(Odd "+oldOddTeam2+") -> "+winner.getName()+" wins ! |");
		this.reduceOdd(winner);
		this.increaseOdd(loser);
		System.out.println("The bookmaker "+this.name+" odds after the game are");
		System.out.println("");
		System.out.println("| "+winner.getName()+" odd is now "+this.CompetitorsAndOdds.get(winner)+" |");
		System.out.println("| "+loser.getName()+" odd is now "+this.CompetitorsAndOdds.get(loser)+"   |");
		System.out.println("");
		System.out.println("|--------------------------------------------------------------------|");
		
	}

	/**
	 * This methods display the start of the competition by the Bookmaker.
	 */
	@Override
	public void competitionStarted(CompetitionEvent e) {
		System.out.println("|--------------------------------------------------------------------|");
		System.out.println("");
		System.out.println("| The following competition will be broadcast to you by "+this.name+"|");
		System.out.println("");
		displayAllOdds();
		System.out.println("|--------------------------------------------------------------------|");
		
	}

	/**
	 * This methods display the end of the competition by the Bookmaker.
	 */
	@Override
	public void competitionFinished(CompetitionEvent e) {
		System.out.println("|--------------------------------------------------------------------------------------|");
		System.out.println("");
		System.out.println("| This competition is coming to an end, "+this.name+" was happy to be with you bye bye!|");
		System.out.println("");
		displayAllOdds();
		System.out.println("|--------------------------------------------------------------------------------------|");
		
	}
	
	
	/**
	 * Returns the odd of a competitor presents in the hashmap of the bookmaker.
	 * @param c the competitor for which we take the odd.
	 * @return
	 */
	public int getCompetitorOdd(Competitor c) {
		return this.CompetitorsAndOdds.get(c);
	}
	
	/*
	 * This methods generate a random integer between 1 and 10.
	 */
	private int generateRandomOdd() {
		int max = 11;
		int min = 1;
		int randomNumber = min + (int)(Math.random()* (max - min)) - max;
		return (-1)*randomNumber;
	}
	
	/**
	 * Decreases by 1 the odd of a competitor.
	 * @param comptthe competitor that undergoes the decrease.
	 */
	private void reduceOdd(Competitor compt) {
		int oldOdd = this.CompetitorsAndOdds.get(compt);
		if(oldOdd > 1) {
			this.CompetitorsAndOdds.replace(compt, oldOdd - 1);
		}
	}
	
	/**
	 * Increases by 1 the odd of a competitor.
	 * @param compt the competitor that undergoes the increase.
	 */
	private void increaseOdd(Competitor compt) {
		int oldOdd = this.CompetitorsAndOdds.get(compt);
		this.CompetitorsAndOdds.replace(compt, oldOdd + 1);
	}
	
	/**
	 * Create a HashMap of pair Competitor,Integer from a list of competitors.
	 * @param comps a list of competitors.
	 * @return HashMap a hashmap of pair competitor, integer.
	 */
	private Map<Competitor,Integer> createBookmakerMap(List<Competitor> comps) {
		Iterator<Competitor> it = comps.iterator();
		Map<Competitor,Integer> CompetitorsWithOdds = new HashMap<Competitor,Integer>();
		while(it.hasNext()) {
			Competitor c1 = it.next();
			CompetitorsWithOdds.put(c1, this.generateRandomOdd());
		}
		return CompetitorsWithOdds;
	}
	
	/**
	 * Displays all the competitors and their odds attributes by the bookmaker.
	 */
	public void displayAllOdds() {
		Map<Competitor, Integer> rank = this.CompetitorsAndOdds;
		System.out.println("|----------------- COMPETITORS AND THEIR ODD-----------------|");
		for (Map.Entry<Competitor, Integer> entry : rank.entrySet()) {
			System.out.println("");
			System.out.println("| "+entry.getKey().getName() + " : "+ entry.getValue()+" |");
			System.out.println("");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		}
		System.out.println("|------------------------------------------------------------|");
	}

	

}
