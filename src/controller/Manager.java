package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import slope.Slope;
import view.ButtonPanel;
import view.SlopeFrame;
import agent.Agent.State;
import agent.Agents;
import agent.Skier;

/**
 * Controller class in MVC, manages data flow.
 * 
 * @author Kruchy
 * 
 */
public class Manager {
	Agents agents;
	private boolean running;
	private boolean step;
	private SlopeFrame slopeFrame;
	
	
	/**
	 * Sets current model and viev in controller.
	 * 
	 * @param slope
	 * @param agents
	 */
	public Manager(SlopeFrame slope, Agents agents) {
		running = false;
		step = false;
		this.agents = agents;
		this.slopeFrame = slope;
		slopeFrame.addComponentListener(new WindowSizeListener());
		_getButton().getAddSkier().addActionListener(new AddSkierListener());
		_getButton().getStart().addActionListener(new StartListener());
		_getButton().getReset().addActionListener(new ResetListener());
		_getButton().getExit().addActionListener(new ExitListener());
		_getButton().getActualize().addActionListener(new ActualizeListener());
		_getButton().getStep().addActionListener(new StepListener());
		_getButton().getPause().addActionListener(new PauseListener());
		_getButton().getCont().addActionListener(new ContinueListener());

	}

	/**
	 * Helper function to manage code.
	 * 
	 * @return
	 */
	private ButtonPanel _getButton() {
		return getSlopeFrame().getSplitPane().getButtons();
	}

	/**
	 * Updates everything in model class.
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean updateModel() throws InterruptedException {
		ArrayList<Skier> moved = agents.moveSkiers();
		foundCollisions();
		addToElevator(moved);
		moved.removeAll(moved);
		moveElevator();
		agents.updateAgentMap();

		return true;

	}

	/**
	 * Updates view from current model.
	 */
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

	/**
	 * Lifts given agents upward the slope.
	 * 
	 * @throws InterruptedException
	 */
	public synchronized void moveElevator() throws InterruptedException {
		agents.getElevator().lift();

	}

	/**
	 * Adds to elevator those agents, who have reached the end of the slope.
	 * 
	 * @param moved
	 */
	public void addToElevator(ArrayList<Skier> moved) {
		for (Skier skier : moved) {
			skier.setState(State.SAFE_ZONE);
			agents.getElevator().addSkier(skier);
		}
	}

	/**
	 * Adds skier to agents queue in model
	 * 
	 * @param skier
	 */
	public void addSkier(Skier skier) {
		agents.addSkier(new Skier());
	}

	/**
	 * Resets everything and sets to default.
	 */
	private void reset() {
		setRunning(false);
		agents.getElevator().removeAll();
		agents.removeAll();
		slopeFrame.revalidate();
	}

	/**
	 * Gets data from view and passes it to model
	 */
	public void getDataAndActualize() {
		int val = _getButton().getSkiers().getValue();
		int height = _getButton().getSlopeHeight().getValue();
		int width = _getButton().getSlopeWidth().getValue();
		new Slope(width, height, 100, 10);
		agents = new Agents();
		if (agents.agents.isEmpty())
			for (int i = 0; i < val; i++) {

				addSkier(new Skier());
			}
	}

	/**
	 * Getter function for running.
	 * 
	 * @return
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * Setter function for running.
	 * 
	 * @param running
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	/**
	 * Getter function for view.
	 */
	public SlopeFrame getSlopeFrame() {
		return slopeFrame;
	}

	/**
	 * Setter function for view.
	 * 
	 * @param slopeFrame
	 */
	public void setSlopeFrame(SlopeFrame slopeFrame) {
		this.slopeFrame = slopeFrame;
	}

	public boolean isStep() {
		return step;
	}

	public void setStep(boolean step) {
		this.step = step;
	}

	/**
	 * Custom listener class for adding button in view
	 * 
	 * @author Kruchy
	 * 
	 */
	public class AddSkierListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			addSkier(new Skier());
		}

	}

	/**
	 * Custom listener class for step button in view.
	 */
	public class StepListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setRunning(false);
			setStep(true);
		}
		
	}
	
	/**
	 * Custom listener class for reset button in view.
	 * 
	 * @author Kruchy
	 * 
	 */
	public class ResetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			reset();
			slopeFrame.repaint();
		}

	}

	/**
	 * Custom listener class for start button in view.
	 * 
	 * @author Kruchy
	 * 
	 */
	public class StartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			getDataAndActualize();
			setRunning(true);
		}

	}

	/**
	 * Custom listener class for exit button in view.
	 * 
	 * @author Kruchy
	 * 
	 */
	public class ExitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			reset();
			slopeFrame.dispose();
			System.exit(0);
		}

	}

	/**
	 * Custom listener class for actualize button in view.
	 * 
	 * @author Kruchy
	 * 
	 */
	public class ActualizeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			reset();
			getDataAndActualize();
		}

	}
	
	/**
	 * Custom listener class to implement pause. 
	 */
	public class PauseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setRunning(false);
		}
		
	}

	/**
	 * Custom listener class to implement pause. 
	 */
	public class ContinueListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setRunning(true);
		}
		
	}
	/**
	 * Custom listener class for listening to change size events in view.
	 * 
	 * @author Kruchy
	 * 
	 */
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
			// new
			// Slope((int)slopeFrame.getWidth()/16,(int)slopeFrame.getHeight()/14
			// ,100, 10);
			// slopeFrame.getSplitPane().getSimulation().update();
		}

		@Override
		public void componentShown(ComponentEvent arg0) {
		}
	}
}
