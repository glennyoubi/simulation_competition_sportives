package Competiton;
import java.util.*;
import java.util.Map;
import java.util.Map.Entry;


/*
 * This class represents a team characterised by her name and her number of points.
 * 
 * @authors Glenn Youbi Degnon & Mohamed Kouriat
 * @version 1.0
 */

public class Competitor {
	
	/**
	 * Name the name of the competitor.
	 */
	private String name;
	/**
	 * Points the number of points of the competitor.
	 */
	private int points;
	 


	/**
	 * Constructs a competitor by setting his name and his number of points.
	 * @param name name the name of the competitor.
	 * @param points the number of points of the competitor.
	 */
	public Competitor( String name, int points ) {
		
		this.name=name; 
		this.points=0;
		
	}
	
	//Getters & Setters 
	
	/**
	 * Constructs a competitor with the name , name.
	 * @param name the name of the competitor.
	 */
	public Competitor(String name) {
		
		this.name=name;
		this.points=0;
	}

	/**
	 * Returns the name of the competitor.
	 * @return the name of competitor.
	 */
	public String getName() {
		return name;
	}


	/**
	 * Set the name of the competitor.
	 * @param name the name of competitor.
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Returns the number of points of the competitor.
	 * @return the number of points of the competitor.
	 */
	public int getPoints() {
		return points;
	}


	/**
	 * Set a number of points to the competitor.
	 * @param points number of points set to the competitor.
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	/**
	 * 	Add one point to the competitor.
	 */
	public void addPoints() {
		this.points = this.points + 1;
	}


}
