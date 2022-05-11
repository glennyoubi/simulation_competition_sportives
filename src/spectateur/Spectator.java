package spectateur;
import Competiton.Match;

public interface Spectator {
	
	/**
	 * This method modified the behavior of the soectator
	 * Due to the match result.
	 * @param match Match that modified the behavior of the spectator.
	 */
	public void update(Match match);
}
