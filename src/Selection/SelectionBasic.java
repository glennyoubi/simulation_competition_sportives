/**
 * This selection class allow you to  only select the n competitor of
 * each hens in the master.
 */


package Selection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Competiton.Competitor;
import Competiton.League;

public abstract class SelectionBasic implements Selection{
	
	/**
	 * This methods returns a list of competitor. Those competitors are chosen in each league presents in the attribute PhaseDePoules
	 * The number of the competitors it is specified by the method competitorToChoosePerLeague.
	 * @param PhaseDePoules List of league in which the competitor are chosen.
	 * @return List of competitor.
	 */
	@Override
	public List<Competitor> selectionFinalist(List<League> PhaseDePoules) {
		List<Competitor> Finalists = new ArrayList<Competitor>();
		Iterator<League> it = PhaseDePoules.iterator();
		int competitorToChoosePerLeague = this.competitorToChoosePerLeague();
		while(it.hasNext()) {
			League currentLeague = it.next();
			Map<Competitor, Integer> rankedCurrentLeague = currentLeague.ranking();
			int i =0;
			for (Map.Entry<Competitor, Integer> entry : rankedCurrentLeague.entrySet()) {
				if(i<competitorToChoosePerLeague) {
					Competitor competitorChoosen = entry.getKey();
					Finalists.add(competitorChoosen);
					i++;
				}
			}
	}
		return Finalists;

}
	
	/**
	 * This methods return the number of competitors
	 * that will be choose by selection method
	 */
	public abstract int competitorToChoosePerLeague();
}
