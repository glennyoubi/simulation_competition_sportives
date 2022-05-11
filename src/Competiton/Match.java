package Competiton;


/*
 * This class allows the execution of a match between two teams.
 * 
 * @authors Glenn Youbi Degnon & Mohamed Kouriat
 * @version 1.0
 */

public class Match {
	
	/*First team*/
	private Competitor team1;
	
	/*Second team */
	private Competitor team2;
	
	/**
	 * The match's winning team.
	 */
	private Competitor winner;
	
	/**
	 * The match's losing team.
	 */
	private Competitor loser;


	/*
	 * Constructs a match with two teams that will compete.
	 */
	public Match(Competitor team1,Competitor team2){
			this.team1 = team1;
			this.team2 = team2;
			this.loser = null;
			this.winner = null;
	}
	
	
	
	/**
	 * Returns the team1 of the match.
	 * @return the team1 of the match.
	 */
	public Competitor getTeam1() {
		return team1;
	}



	/**
	 * Set a team to the match as team1.
	 * @param team1
	 */
	public void setTeam1(Competitor team1) {
		this.team1 = team1;
	}



	/**
	 * Returns  the team2 of the match.
	 * @return  the team2 of the match.
	 */
	public Competitor getTeam2() {
		return team2;
	}



	/**
	 * Set a team to the match as team2.
	 * @param team2
	 */
	public void setTeam2(Competitor team2) {
		this.team2 = team2;
	}
	
	/** Returns the winner of the match.
	 * @return the winner of the match.
	 */
	public Competitor getWinner() {
		return winner;
	}



	/**
	 * Set a team to the match as the winner.
	 * @param winner Winning team of the match
	 */
	public void setWinner(Competitor winner) {
		this.winner = winner;
	}



	/** Returns the loser of the match.
	 * @return the loser of the match.
	 */
	public Competitor getLoser() {
		return loser;
	}



	/**
	 * Set a team to the match as the loser.
	 * @param loser Losing team of the match.
	 */
	public void setLoser(Competitor loser) {
		this.loser = loser;
	}




	/*
	 * This methods generate a random integer between 0 and 9.
	 */
	private int generateRandomNumber() {
		int max = 10;
		int min = 0;
		int randomNumber = min + (int)(Math.random()* (max - min)) - max;
		return randomNumber;
	}
	/*
	 * This method return randomly a winner by playing a match between two teams t1 and t2.
	 * @return the team that won the match.
	 */
	
	public Competitor pickWinner() {
		int winNumber = generateRandomNumber();
		if(winNumber % 2 == 0) {
			this.setLoser(this.team2);
			this.setWinner(this.team1);
			return this.team1;
		}
		else {
			this.setLoser(this.team1);
			this.setWinner(this.team2);
			return this.team2;
		}
	}
	
	/**
	 * This methods shows who are the two competitors who facing.
	 * @return A string that describes the match.
	 */
	public String displayMatch() {
		return (this.getTeam1().getName() +" vs "+ this.getTeam2().getName());
	}
	

}
