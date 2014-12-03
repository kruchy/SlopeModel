package controller;

import java.util.ArrayList;

import agent.Agent;
import agent.Agent.Direction;
import agent.Agent.State;
import agent.Algorithm;
import agent.Skier;
import slope.Elevator;
import slope.Slope;
import view.SkiPanel;
import view.SlopeFrame;

public class Manager {
	ArrayList<Skier> agents;
	Elevator elevator;
	boolean[][] agentMap;

	SlopeFrame slopeFrame;
	SkiPanel skiPanel;

	public Manager() {
		agents = new ArrayList<>();
		elevator = new Elevator();
		agentMap = new boolean[Slope.getHeight() + 2][Slope.getWidth() + 2];
		/*
		 * skiPanel = new SkiPanel(agentMap); slopeFrame = new SlopeFrame(50,
		 * 50, 400, 600,skiPanel);
		 */
	}

	public boolean updateModel() {
		ArrayList<Skier> moved = moveSkiers();
		/*
		 * for (int i = 0; i < agents.size(); i++) for (int j = i; j <
		 * agents.size(); j++)
		 * Algorithm.updatePosition(agents.get(i),agents.get(j)); ;
		 */
		foundCollisions();
		addToElevator(moved);
		moved.removeAll(moved);
		moveElevator();

		return true;

	}

	public void updateAgentMap() {
		for (int i = 0; i < agentMap.length; i++)
			for (int j = 0; j < agentMap[0].length; j++) {
				agentMap[i][j] = false;
			}
		for (Skier iter : agents) {
			int x = iter.getLocation().getPosx();
			int y = iter.getLocation().getPosy();
			if (x <= Slope.getWidth() && y <= Slope.getHeight())
				agentMap[x][y] = true;

		}
		System.out.println();

	}

	private boolean foundCollisions() {
		// TODO Finding collisions
		for (Agent iter : agents) {
			int x = iter.getLocation().getPosx();
			int y = iter.getLocation().getPosy();
		}
		return false;
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

	// public void updateTable()
	// {
	// slopeFrame.drawTable(agentMap);
	// }

	public boolean[][] getAgentMap() {
		return agentMap;
	}

	public void simulate() {

	}

	public ArrayList<Skier> moveSkiers() {
		ArrayList<Skier> outOfBounds = new ArrayList<>();
		for (Skier i : agents) {
			int x = i.getLocation().getPosx();
			int y = i.getLocation().getPosy();
			if (y + 1 < Slope.getHeight() && x + 1 < Slope.getWidth()
					&& x - 1 > 0)
				i.findCell();
			if (x + 1 >= Slope.getWidth()) {
				i.setDir(Direction.R);
			}
			if (x <= 0) {
				i.setDir(Direction.L);
			}
			if (y + 1 >= Slope.getHeight()) {
				i.setLocation(Slope.getWidth() - 3, Slope.getHeight() - 4);
				outOfBounds.add(i);
			}
			i.time += (double) i.getSpeed() / 10.0 + i.time;
			if (i.time > 1.0 && i.getState() == State.ON_TRACK) {
				i.move();
				i.time -= 1.0;
			}

		}
		return outOfBounds;
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

	public void addSkier(Skier a) {
		agents.add(a);
		agentMap[a.getLocation().getPosx() + 1][a.getLocation().getPosy() + 1] = true;

	}

}