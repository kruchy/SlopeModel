package controller;

import java.util.ArrayList;

import agent.Agent.State;
import agent.Agents;
import agent.Skier;
import slope.Elevator;
import slope.Slope;
import view.ButtonPanel;
import view.SkiPanel;
import view.SlopeFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Manager {
	Agents agents;
	private boolean running;

	private SlopeFrame slopeFrame;

	public Manager(SlopeFrame slope, Agents agents) {
		running = false;
		this.agents = agents;
		this.slopeFrame = slope;
		slopeFrame.addComponentListener(new WindowSizeListener());
		_getButton().getAddSkier().addActionListener(new AddSkierListener());
		_getButton().getStart().addActionListener(new StartListener());
		_getButton().getReset().addActionListener(new ResetListener());
		_getButton().getExit().addActionListener(new ExitListener());
		_getButton().getActualize().addActionListener(new ActualizeListener());

	}

	private ButtonPanel _getButton() {
		return getSlopeFrame().getSplitPane().getButtons();
	}

	public boolean updateModel() throws InterruptedException {
		ArrayList<Skier> moved = agents.moveSkiers();
		foundCollisions();
		addToElevator(moved);
		moved.removeAll(moved);
		moveElevator();
		agents.updateAgentMap();

		return true;

	}

	public void drawSlope() {
		getSlopeFrame().drawing(agents.getAgentMap());

	}

	private boolean foundCollisions() {
		/*
		 * for (Agent iter : agents) { int x = iter.getLocation().getPosx(); int
		 * y = iter.getLocation().getPosy(); }
		 */
		return false;
	}

	public synchronized void moveElevator() throws InterruptedException {
		agents.getElevator().lift();

	}

	public void addToElevator(ArrayList<Skier> moved) {
		for (Skier skier : moved) {
			skier.setState(State.SAFE_ZONE);
			agents.getElevator().addSkier(skier);
		}
	}

	public void addSkier(Skier skier) {
		agents.addSkier(new Skier());
	}

	private void reset() {
		setRunning(false);
		agents.getElevator().removeAll();
		agents.removeAll();
		slopeFrame.revalidate();
	}

	public void getDataAndActualize() {
		int val = _getButton().getSkiers().getValue();
		int height = _getButton().getSlopeHeight().getValue();
		int width = _getButton().getSlopeWidth().getValue();
		new Slope(width,height,100,10);
		agents = new Agents();
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


	public SlopeFrame getSlopeFrame() {
		return slopeFrame;
	}

	public void setSlopeFrame(SlopeFrame slopeFrame) {
		this.slopeFrame = slopeFrame;
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
			System.exit(0);
		}

	}

	public class ActualizeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			reset();
			getDataAndActualize();
		}

	}

	public class WindowSizeListener implements ComponentListener {
		@Override
		public void componentHidden(ComponentEvent arg0) {
		}

		@Override
		public void componentMoved(ComponentEvent arg0) {
		}

		@Override
		public void componentResized(ComponentEvent arg0) {
			reset();
			//new Slope((int)slopeFrame.getWidth()/16,(int)slopeFrame.getHeight()/14 ,100, 10);
			//slopeFrame.getSplitPane().getSimulation().update();
		}

		@Override
		public void componentShown(ComponentEvent arg0) {
		}
	}
}