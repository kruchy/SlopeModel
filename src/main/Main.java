package main;

import slope.Slope;
import agent.Agent;
import agent.Skiier;

public class Main {
	public static void main(String[] args){
		Skiier s = new Skiier();
		s.createSkiier(Slope.getSlopeTable());
		
	}
}
