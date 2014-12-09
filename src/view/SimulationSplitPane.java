package view;

import javax.swing.JSplitPane;

public class SimulationSplitPane extends javax.swing.JSplitPane{

	ButtonPanel buttons;
	SkiPanel simulation;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimulationSplitPane() {
		super(JSplitPane.VERTICAL_SPLIT);
		this.setResizeWeight(0);
		init();
	}

	private void init() {
		buttons = new ButtonPanel();
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
