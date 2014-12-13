package controller;

import java.util.ArrayList;
import java.util.Arrays;

import agent.Agent;
import agent.Agent.Direction;
import agent.Agent.State;
import agent.Agents;
import agent.Algorithm;
import agent.Skier;
import slope.Elevator;
import slope.Slope;
import view.SkiPanel;
import view.SlopeFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Manager {
	Elevator elevator;
	Agents agents;

	SlopeFrame slopeFrame;
	SkiPanel skiPanel;

	public Manager() {
		elevator = new Elevator();
		agents = new Agents();
	}

	
	public boolean[][] getAgentMap()
	{
		return agents.getAgentMap();
	}
	
	public void initSlope(SlopeFrame slp)
	{
		this.slopeFrame = slp;
	}

	public boolean updateModel() {
		ArrayList<Skier> moved = agents.moveSkiers();
		addToElevator(moved);
		moved.removeAll(moved);
		moveElevator();
		agents.updateAgentMap();
		return true;

	}

	
		
	public void drawSlope()
	{
		slopeFrame.drawing(agents.getAgentMap());

	}

	public synchronized void moveElevator() {
		elevator.lift();

	}

	public void addToElevator(ArrayList<Skier> moved) {
		for (Skier skier : moved) {
			skier.setState(State.ON_LIFT);
			elevator.addSkier(skier);
		}
	}

	public void pushToRoute() {

	}



	public void simulate() {

	}

	

	public boolean onSkierCollision() {
		return false;
	}

	public boolean onSkierAppear() {
		return false;
	}

	public boolean onSkierMoved() {
		return false;
	}

	public boolean onSimulationStart() {
		return false;
	}

	public boolean onSimulationEnd() {
		return false;
	}

	public void addSkier(Skier skier)
	{
		agents.addSkier(new Skier());
	}

	public class AddSkierListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			addSkier(new Skier());
		}
		
	}
	
}

