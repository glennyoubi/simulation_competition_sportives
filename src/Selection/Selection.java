package Selection;
import java.util.List;
import Competiton.*;


/**
 * @author Glenn YOUBI DEGNON & Mohamed KOURIAT
 * An interface that allows the user to choose to implements every of selection he wants 
 * for a specific competition.
 */

public interface Selection {

/**
 * This methods returns a list of competitor. Those competitors are chosen in each league presents in the attribute PhaseDePoules
 * The number of the competitors it is specified during the method's implementation.
 * @param PhaseDePoules List of league in which the competitor are chosen.
 * @return List of competitor.
 */
public List<Competitor> selectionFinalist(List<League> PhaseDePoules);


}