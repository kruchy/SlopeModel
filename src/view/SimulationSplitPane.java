package view;

import javax.swing.JSplitPane;

import controller.Manager;

public class SimulationSplitPane extends javax.swing.JSplitPane{

	ButtonPanel buttons;
	SkiPanel simulation;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimulationSplitPane(Manager manager) {
		super(JSplitPane.VERTICAL_SPLIT);
		this.setResizeWeight(0);
		init(manager);
	}

	private void init(Manager manager) {
		buttons = new ButtonPanel(manager);
		simulation = new SkiPanel();
		simulation.setSize(getWidth() - 50, getHeight() - 100);
		this.setTopComponent(buttons);
		this.setBottomComponent(simulation);
		setVisible(true);
	}

	public void drawing(boolean[][] agent) {
		simulation.drawing(agent);
		repaint();
	}

	
	
	

}
