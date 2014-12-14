package controller;

import java.util.ArrayList;
import java.util.Arrays;

import agent.Agent;
import agent.Agent.Direction;
import agent.Agent.State;
<<<<<<< HEAD
=======
import agent.Agents;
>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b
import agent.Algorithm;
import agent.Skier;
import slope.Elevator;
import slope.Slope;
import view.ButtonPanel;
import view.SkiPanel;
import view.SlopeFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
public class Manager {
	public ArrayList<Skier> agents;
	Elevator elevator;
	boolean[][] agentMap;

	SlopeFrame slopeFrame;
	SkiPanel skiPanel;

	public Manager(SlopeFrame slopeFrame) {
		
		agents = new ArrayList<>();
		agentMap = new boolean[Slope.getHeight() + 2][Slope.getWidth() + 2];
		/*
		 * skiPanel = new SkiPanel(agentMap); slopeFrame = new SlopeFrame(50,
		 * 50, 400, 600,skiPanel);
		 */
		this.slopeFrame = slopeFrame;
		for (int i = 1; i <= 15; i++) {
			addSkier(new Skier());
		}
		elevator = new Elevator();
//		createSlopeFrame();
=======

public class Manager {
	Elevator elevator;
	Agents agents;
	private boolean running;

	private SlopeFrame slopeFrame;
	private SkiPanel skiPanel;

	public Manager(SlopeFrame slope, Agents agents) {
		elevator = new Elevator();
		running = false;
		this.setSlopeFrame(slope);
		this.agents = agents;
		_getButton().getAddSkier()
				.addActionListener(new AddSkierListener());
		_getButton().getStart()
				.addActionListener(new StartListener());
		_getButton().getReset()
				.addActionListener(new ResetListener());
		_getButton().getExit()
				.addActionListener(new ExitListener());
		_getButton().getActualize().addActionListener(new ActualizeListener());
		
	}

	private ButtonPanel _getButton() {
		return getSlopeFrame().getSplitPane().getButtons();
>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b
	}
//
//	private void createSlopeFrame() {
//		slopeFrame = new SlopeFrame(this);
//	}

<<<<<<< HEAD
	public boolean updateModel() throws InterruptedException {
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

=======
	public boolean updateModel() {
		ArrayList<Skier> moved = agents.moveSkiers();
		addToElevator(moved);
		moved.removeAll(moved);
		moveElevator();
		agents.updateAgentMap();
>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b
		return true;

	}

<<<<<<< HEAD
	public void updateAgentMap() {
		for (int i = 0; i < agentMap.length; i++)
			for (int j = 0; j < agentMap[0].length; j++) {
				agentMap[i][j] = false;
			}
		for (Skier iter : agents) {
		//	System.out.println(iter.getLocation().getPosx());
			int x = iter.getLocation().getPosx();
			int y = iter.getLocation().getPosy();
			if (x <= Slope.getWidth() && y <= Slope.getHeight())
				agentMap[x][y] = true;
=======
	public void drawSlope() {
		getSlopeFrame().drawing(agents.getAgentMap());
>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b

		}
	}
		
	public void drawSlope()
	{
		slopeFrame.drawing(agentMap);
	}

<<<<<<< HEAD
	

	private boolean foundCollisions() {
		/*for (Agent iter : agents) {
			int x = iter.getLocation().getPosx();
			int y = iter.getLocation().getPosy();
		}*/
		return false;
	}

	public synchronized void moveElevator() throws InterruptedException {
=======
	public synchronized void moveElevator() {
>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b
		elevator.lift();

	}

	public void addToElevator(ArrayList<Skier> moved) {
		for (Skier skier : moved) {
<<<<<<< HEAD
			skier.setState(State.SAFE_ZONE);
			elevator.addSkier(skier);
		}
	}

	public void pushToRoute() {

	}


	public boolean[][] getAgentMap() {
		return agentMap;
	}

	public void simulate() {

	}

	public ArrayList<Skier> moveSkiers() {
		ArrayList<Skier> outOfBounds = new ArrayList<>();
		for (Skier i : agents) {
			if(i.getState() == State.ON_TRACK){
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
				if (i.time > 1.0 ) {
					i.move();
					i.time -= 1.0;
				}
			}
=======
			skier.setState(State.ON_LIFT);
			elevator.addSkier(skier);
>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b
		}
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

	public void addSkier(Skier skier) {
		agents.addSkier(new Skier());
	}

	public SlopeFrame getSlopeFrame() {
		return slopeFrame;
	}

	public void setSlopeFrame(SlopeFrame slopeFrame) {
		this.slopeFrame = slopeFrame;
	}

	public SkiPanel getSkiPanel() {
		return skiPanel;
	}

	public void setSkiPanel(SkiPanel skiPanel) {
		this.skiPanel = skiPanel;
	}

	private void reset() {
		setRunning(false);
		elevator.removeAll();
		agents.removeAll();
		slopeFrame.repaint();
	}

	
	public void getDataAndActualize() {
		int val = _getButton().getSkiers()
				.getValue();
		if (agents.agents.isEmpty())
			for (int i = 0; i < val; i++) {
				addSkier(new Skier());
			}
	}

	
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public class AddSkierListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			addSkier(new Skier());
		}

	}

	public class ResetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			reset();
		}

	}

	public class StartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			getDataAndActualize();
			setRunning(true);
		}

	}

	public class ExitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			reset();
			slopeFrame.dispose();

		}

	}
	public class ActualizeListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			getDataAndActualize();
		}
		
	}

<<<<<<< HEAD
	public class AddSkierListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			addSkier(new Skier());
		}
		
	}
	
}

=======
}
>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b
