package Competiton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

import Selection.*;
import spectateur.MatchListener;
import spectateur.Spectator;
import util.*;

public class Master extends Competition {
	/*Selection use for the master*/
	private Selection selection;
	
	/*Number of competitors who will compete for the master*/
	private int nbr_competitors;
	
	/*Number of competitors who will compete for the master*/
	private int numberOfHens;
	
	/*Number of hens presents in the master*/
	private List<League> hens;
	
	/*private Map<Integer,<Competitor>> teams;*/
	/*private List<Competitor> PhaseDePoules;*/
	
	/*List of competitors who will compete after the hens has been complete*/
	private List<Competitor> PhaseFinal;

	/**
	 * Create a master with a specific number of hens and competitor.
	 * whose attribute selection defines the selection method of the competitors 
	 * accessing the final phase.
	 * @param Competitors List of competitors present in the master.
	 * @param nbr_competitors Number of competitors present in the master.
	 * @param hens Number of hens in the master.
	 * @param selection Selection method use by the master to choose the competitors who access to the final phase.
	 */
	public Master(List<Competitor> Competitors, int nbr_competitors,int NumberOfhens, Selection selection){
    super(Competitors);
    this.selection = selection;
    this.nbr_competitors = nbr_competitors;
    this.numberOfHens = NumberOfhens;
    try {
		this.hens = buildHens(NumberOfhens, Competitors);
	} catch (HensCompetitorsException e) {
		e.printStackTrace();
	}
    this.PhaseFinal = null;
    /*this.PhaseDePoules= new List<League>();*/
    /*this.teams = new HashMap<Integer,List<Competitor>>();*/
    /*this.PhaseFinal= new List<Competitor>();*/
  }
	
	
	public Master(List<Competitor> Competitors, int nbr_competitors,int NumberOfhens, Selection selection,List<MatchListener> spects){
	    super(Competitors,spects);
	    this.selection = selection;
	    this.nbr_competitors = nbr_competitors;
	    this.numberOfHens = NumberOfhens;
	    try {
			this.hens = buildHens(NumberOfhens, Competitors);
		} catch (HensCompetitorsException e) {
			e.printStackTrace();
		}
	    this.PhaseFinal = null;
	    /*this.PhaseDePoules= new List<League>();*/
	    /*this.teams = new HashMap<Integer,List<Competitor>>();*/
	    /*this.PhaseFinal= new List<Competitor>();*/
	  }
	
	
	/**
	 * Initialize the number hens for the master. By checking if the number of hens and the number 
	 * of competitors are compatible. If they are the method create the number hens with an equal number
	 * competitor per hen.
	 * @param n The number of hens.
	 * @param comp The list of competitors.
	 * @return the list of league that corresponds to the hens.
	 * @throws HensCompetitorsException Exception link to the number of hens and the number of competitors.
	 */
	public List<League> buildHens(int n, List<Competitor> comp) throws HensCompetitorsException {
		List<League> hens = new ArrayList<League>();
		if (comp.size()%n != 0) {
			throw new HensCompetitorsException("The number of hens and the number of competitors are not compatible");
		}
		else {
			int cpt = 1;
			int competitorsPerHens = comp.size() / n;
			Iterator<Competitor> it = comp.iterator();
			while(cpt <= n) {
				List<Competitor> hensCompetitors = new ArrayList<Competitor>();
				for(int i=0; i<competitorsPerHens; i++) {
					Competitor c = it.next();
					hensCompetitors.add(c);
				}
				League hensAdded = new League(hensCompetitors,this.MatchListeners);
				hens.add(hensAdded);
				cpt++;
			}
		}
		this.hens = hens;
		return hens;
	}
	
	/**
	 * This method select all competitors allow to pass the final of the tournament
	 * according to selection type used by the master.
	 * @param comps
	 * @return
	 */
	public List<Competitor> selectionFinalists(List<League> comps) {
		return this.selection.selectionFinalist(comps);
	}
	
	/**
	 * This method allows the execution of all the hens of the master.
	 * By making one hen after an other and choose the final competitor
	 * according to selection type used by the master.
	 * @return List of competitor that will play the final phase of the master.
	 */
	public List<Competitor> playHens() {
		try {
			this.buildHens(this.numberOfHens, this.competitors);
		} catch (HensCompetitorsException e) {
			e.printStackTrace();
		}
		Iterator <League> it = this.hens.iterator();
		int i = 1;
		while(it.hasNext()) {
			System.out.println("Master, Hens "+i+" !");
			League currentLeague = it.next();
			try {
				currentLeague.play();
				i++;
			} catch (PowerOfTwoException e) {
				e.printStackTrace();
			}
			
		}
		this.PhaseFinal =  this.selectionFinalists(this.hens);
		return this.PhaseFinal;
		
	}
	
	/**
	 * This method allows the execution of all the final phase of the master.
	 * By making compete the remaining competitors next to each other after a raffle draw.
	 * @return The winner of the Master.
	 */
	public Competitor playPhaseFinal() {
		Tournament finalPhase = null;
		ArrayList<Competitor> raffleDraw = new ArrayList<Competitor>();
		raffleDraw.addAll(this.PhaseFinal);
		Collections.shuffle(raffleDraw);
		try {
		finalPhase = new Tournament(raffleDraw,this.MatchListeners);
		}
		catch(PowerOfTwoException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Master Final Phase");
			finalPhase.play();
		} catch (PowerOfTwoException e) {
			e.printStackTrace();
		}
		Competitor winner = finalPhase.getTournamentWinner();
		return winner;
		
	}
	
	/**
	 *
	 */
	@Override
	protected void play(List<Competitor> competitors) {
		this.playHens();
		this.playPhaseFinal();
		
	}

}