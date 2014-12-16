package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JSplitPane;

public class SimulationSplitPane extends javax.swing.JSplitPane{

	private ButtonPanel buttons;
	private SkiPanel simulation;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimulationSplitPane() {
		super(JSplitPane.HORIZONTAL_SPLIT);
		this.setResizeWeight(1);
		init();
	}

	private void init() {
		setButtons(new ButtonPanel());
		setSimulation(new SkiPanel());
		getSimulation().setBackground(new Color(1.0f,1.0f,1.0f));
		int x = (int) Math.round(0.8*getHeight());
		int y = (int) Math.round(0.99*getHeight());
		getSimulation().setPreferredSize(new Dimension(x,y));
		this.setRightComponent(getButtons());
		this.setLeftComponent(getSimulation());
		setVisible(true);
		
	}

	public void drawing(boolean[][] agent) {
		getSimulation().drawing(agent);
	}

	public ButtonPanel getButtons() {
		return buttons;
	}

	void setButtons(ButtonPanel buttons) {
		this.buttons = buttons;
		repaint();
	}

	public SkiPanel getSimulation() {
		return simulation;
	}

	public void setSimulation(SkiPanel simulation) {
		this.simulation = simulation;
	}

	
	
	

}
