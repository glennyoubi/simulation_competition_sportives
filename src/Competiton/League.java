package Competiton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.*;
import java.util.Map;
import java.util.Map.Entry;

import spectateur.MatchListener;
import spectateur.Spectator;


public class League extends Competition 
{
	
	private static final String ArrayList = null;

	/**
	 * Create a League with a specific list of competitors.
	 * @param competitors The list of competitors that will compete.
	 */
	public League(List<Competitor> competitors)
	{
		
		super(competitors);
	}
	
	
	/**
	 * Create a League with a specific list of competitors.
	 * @param competitors The list of competitors that will compete.
	 * @param spects The list of spectators that will follow the tournament.
	 */
	public League(List<Competitor> competitors,List<MatchListener> spects)
	{
		
		super(competitors,spects);
	}

	/**
	 * Play all league by making compete all the team against each other
	 * in two legged-match
	 */
	@Override
	public void play(List<Competitor>Competitors)
	{	for(Competitor c1: competitors){
		for( Competitor c2: competitors){
			if(!(c1.getName().equals(c2.getName()))){
				this.playMatch(c1,c2);
			}
		}
	}

	this.displayRanking();

	}
	
		
}
	
	
	
	
	
	 
	


