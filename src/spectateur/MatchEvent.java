package spectateur;
import Competiton.Match;

public class MatchEvent extends java.util.EventObject{
	
	/**
	 * This methods updates the behavior of the listener according to
	 * his behavior.
	 * @param source The match that affects the behavior of the listener.
	 */
	public MatchEvent(Match source) { 
		super(source);
	}

}
