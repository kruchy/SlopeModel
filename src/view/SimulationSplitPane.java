package view;

import javax.swing.JSplitPane;

import controller.Manager;

public class SimulationSplitPane extends javax.swing.JSplitPane{

	private ButtonPanel buttons;
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
		setButtons(new ButtonPanel());
		simulation = new SkiPanel();
		simulation.setSize(getWidth() - 50, getHeight() - 100);
		this.setTopComponent(getButtons());
		this.setBottomComponent(simulation);
		setVisible(true);
	}

	public void drawing(boolean[][] agent) {
		simulation.drawing(agent);
	}

	public ButtonPanel getButtons() {
		return buttons;
	}

	void setButtons(ButtonPanel buttons) {
		this.buttons = buttons;
	}

	
	
	

}
