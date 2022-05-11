package spectateur;

import Competiton.Match;
import Competiton.Competitor;

public class Journalist implements Spectator, CompetitionListener, MatchListener {
	
	/**
	 * The name of the journalist.
	 */
	private String name;
	
	public Journalist(String name) {
		this.name = name;
	}

	/**
	 * This method modified the behavior of the soectator
	 * Due to the match result.
	 * @param match Match that modified the behavior of the spectator.
	 */
	@Override
	public void update(Match match) {
		System.out.println("Game Broadcast to you by the Journalist "+this.name+" !");
		System.out.println("\\ "+match.getTeam1().getName()+" vs "+match.getTeam2().getName() +" -> "+match.getWinner().getName()+" wins ! /");
	}

	/**
	 * This methods updates the behavior of the journalist by
	 * Displaying the following match and his winner
	 */
	@Override
	public void matchPalyed(MatchEvent e) {
		Match updatingMatch = (Match) e.getSource();
		Competitor team1 = updatingMatch.getTeam1();
		Competitor team2 = updatingMatch.getTeam2();
		Competitor winner = updatingMatch.getWinner(); 
		Competitor loser = updatingMatch.getLoser(); 
		System.out.println("|----------------------------------------------------------------------------|");
		System.out.println("Game Broadcast to you by the Journalist "+this.name+" !");
		System.out.println("");
		System.out.println("| "+team1.getName()+" vs "+team2.getName() +" -> "+winner.getName()+" wins ! /");
		System.out.println("");
		System.out.println("|----------------------------------------------------------------------------|");
		
		
	}

	/**
	 * This methods display the start of the competition by the journalist.
	 */
	@Override
	public void competitionStarted(CompetitionEvent e) {
		System.out.println("|--------------------------------------------------------------------|");
		System.out.println("");
		System.out.println("| The following competition will be broadcast to you by "+this.name+"|");
		System.out.println("");
		System.out.println("|--------------------------------------------------------------------|");
		
	}

	/**
	 * This methods display the end of the competition by the journalist.
	 */
	@Override
	public void competitionFinished(CompetitionEvent e) {
		System.out.println("|--------------------------------------------------------------------------------------|");
		System.out.println("");
		System.out.println("| This competition is coming to an end, "+this.name+" was happy to be with you bye bye!|");
		System.out.println("");
		System.out.println("|--------------------------------------------------------------------------------------|");
		
	}

}
