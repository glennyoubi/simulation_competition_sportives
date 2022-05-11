/**
 * This selection class allow you to select the first two competitor of
 * each hens in the master and the two best third of the all competition.
 */

package Selection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Competiton.Competitor;
import Competiton.League;

public class SelectionBestThird implements Selection {

	
	
	/**
	 * This methods returns a list of competitor. Those competitors are chosen in each league presents in the attribute PhaseDePoules
	 * The number of the competitors it is specified during the method's implementation.
	 * @param PhaseDePoules List of league in which the competitor are chosen.
	 * @return List of competitor.
	 */
	@Override
	public List<Competitor> selectionFinalist(List<League> PhaseDePoules) {
		List<Competitor> Finalists = new ArrayList<Competitor>();
		List<Competitor> bestThird = new ArrayList<Competitor>();
		Iterator<League> it = PhaseDePoules.iterator();
		int competitorToChoosePerLeague = 3;
		while(it.hasNext()) {
			League currentLeague = it.next();
			Map<Competitor, Integer> rankedCurrentLeague = currentLeague.ranking();
			int i =0;
			for (Map.Entry<Competitor, Integer> entry : rankedCurrentLeague.entrySet()) {
				if(i<competitorToChoosePerLeague) {
					if(i==2) {
						Competitor competitorChoosen = entry.getKey();
						bestThird.add(competitorChoosen);
						i++;
					}
					else {
						Competitor competitorChoosen = entry.getKey();
						Finalists.add(competitorChoosen);
						i++;
					}
					
				}
			}
	}
		League bestThirdLeague = new League(bestThird);
		Map<Competitor, Integer> rankedBestThird = bestThirdLeague.ranking();
		int y =0;
		for (Map.Entry<Competitor, Integer> entry : rankedBestThird.entrySet()) {
			if(y<2) {
				Competitor competitorThirdChoosen = entry.getKey();
				Finalists.add(competitorThirdChoosen);
				y++;
			}
		}
		
		return Finalists;
	}

}
