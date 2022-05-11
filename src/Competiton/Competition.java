package Competiton;

import java.util.*;
import spectateur.*;
import util.MapUtil;
import util.PowerOfTwoException;
import spectateur.Spectator;
import spectateur.CompetitionListener;
/*
 * This class represents a competition characterised by her competitors and her type of match.
 * 
 * @authors Glenn Youbi Degnon & Mohamed Kouriat
 * @version 1.0
 */

public abstract class Competition {
	
	// Attributes
	/* matches play during the competition */
	protected Match match;
	
	/* List of the competiton's competitors */
	protected final List<Competitor> competitors;
	
	/*List of spectator */
	/*protected List<Spectator> spectators;*/
	
	/**
	 * List of listener that follows the competition.
	 */
	protected List<MatchListener> MatchListeners = new ArrayList<MatchListener>();
	
	//Constructors 
	
	/**
	 * Create a competition with a specified list of competitors
	 * And a specified list of spectators. 
	 * @param competitors The list of competitors.
	 * @param spects The list of spectators that will follow the competition.
	 */
	public Competition(List<Competitor> competitors,List<MatchListener> spects) {
		this.competitors = competitors;
		this.match = new Match(null,null);
		this.MatchListeners = spects;
	}
	
	/**
	 * Create a competition with a specified list of competitors
	 * And a specified list of spectators. 
	 * @param competitors The list of competitors
	 */
	public Competition(List<Competitor> competitors) {
		this.competitors = competitors;
		this.match = new Match(null,null);
	}
	
	
	/** 
	 * Return the match to play in the competition.
	 * @return the match to play in the competition.
	 */ 
	public Match getMatch() {
		return match;
	}

	/**
	 * Set the match to play in the competition.
	 * @param match the match to play in the competition.
	 */
	public void setMatch(Match match) {
		this.match = match;
	}
	
	/*
	 * Make play two teams against each other during a match.
	 * 
	 * @param t1 one of the two teams playing the match.
	 * @param t2 the other that plays the match.
	 * @return the winning team.
	 */
	
	public Competitor playMatch(Competitor t1 , Competitor t2) {
		this.match.setTeam1(t1);
		this.match.setTeam2(t2);
		Competitor winner = this.match.pickWinner();
		winner.addPoints();
		/*this.spectatorsAlert(this.match);*/
		this.fireMatchPlayed(this.match);
		/*System.out.println(this.match.displayMatch() + " -> "+ winner.getName()+" wins !");*/
		return winner;
	}
	
	//Methods
	/**
	 * This method plays the whole competition.
	 */
	public void playCompetition(){
		this.play(this.competitors);
		
	}
		/**
  *This is the function that checks if a number is a multiple of 2.
  *@param n the number on which have checked.
  *@return if it is pow of 2.
  */
	 public boolean isPowerOfTwo(int n){

    return (n != 0) && ((n & (n - 1)) == 0);
  }
/**
  *It is a method which returns the total points of a competition.
  *@param Competitors It is all the competitor of the competition.
  *@return All the points of the competition.
  */
	public int allpoints(List<Competitor> Competitors){
    int allpoints =0;
    for (Competitor c : Competitors){
      allpoints += c.getPoints();
    }
    return allpoints;
  }
	
	/**
	 * This method plays a specific type of competition define by the subclasses.
	 * @param competitors competitors List of teams that compete.
	 */
	protected abstract void play(List<Competitor> competitors);


	/**
	 * This methods plays the whole competition.
	 * @throws PowerOfTwoException Thrown if the number of competitors to play the competition is not a power of two.
	 */
	public void play() throws PowerOfTwoException {
		if(!isPowerOfTwo(this.competitors.size())) {
			throw new PowerOfTwoException("Must be power of Two");
		}else {
			this.play(this.competitors);
		}
	} 


	/**
	 * This create a map, that contains all the competitors of the tournament sort by their numbers of points.
	 * @return a map of competitors and their numbers of points.
	 */
	public Map<Competitor, Integer> ranking(){
		Map<Competitor, Integer> competitorsRanking = new HashMap<>();
		Iterator<Competitor> it = this.competitors.iterator();
		while (it.hasNext()) {
			Competitor c1 = it.next();
			competitorsRanking.put(c1, c1.getPoints());
		}
		competitorsRanking = MapUtil.sortByDescendingValue(competitorsRanking);
		return competitorsRanking;
		
	};
	
	/**
	 * Displays on the console the ranking of the competitors from the winner to the last.
	 */
	public void displayRanking() {
		Map<Competitor, Integer> rank = this.ranking();
		System.out.println("*** RANKING ***");
		for (Map.Entry<Competitor, Integer> entry : rank.entrySet()) {
			System.out.println(entry.getKey().getName() + " - "+ entry.getValue());
		}
	}
	
	/**
	 * This method alerts all the spectators of the competition at the end of the current match.
	 * @param upadatingMatch Match that triggers the alert.
	 */
	/*public void spectatorsAlert(Match upadatingMatch) {
		Iterator<Spectator> it = this.spectators.iterator();
		while(it.hasNext()) {
			Spectator spectator = it.next();
			spectator.update(upadatingMatch);
		}
	}*/
	
	/**
	 * Adds a competition to the subscriber list (CompetitionListener) of the competition.
	 * @param cl The listener to remove.
	 */
	public synchronized void addCompetitionListener(MatchListener cl) {
		if (this.MatchListeners.contains(cl)) { return ; }
		MatchListeners.add(cl);
		}
	
	
	/**
	 * Removes a competition to the subscriber list (CompetitionListener) of the competition.
	 * @param cl The listener to add.
	 */
	public synchronized void removeCompetitionListener(MatchListener cl){
		this.MatchListeners.remove(cl);
		}
	
	
	/**
	 * Alerts all the listener of the competition that the competition a match has been played.
	 */
	private void fireMatchPlayed(Match match) {
		List<MatchListener> tl = new ArrayList<MatchListener>();
		tl = this.MatchListeners; 
		if (tl.size() == 0) { return; }
		MatchEvent event = new MatchEvent(match);
		for (MatchListener listener : tl) {
		listener.matchPalyed(event); 
		}
	}
	
}
