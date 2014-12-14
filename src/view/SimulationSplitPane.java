package view;

import javax.swing.JSplitPane;

import controller.Manager;

public class SimulationSplitPane extends javax.swing.JSplitPane{

<<<<<<< HEAD
	ButtonPanel buttons;
=======
	private ButtonPanel buttons;
>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b
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
<<<<<<< HEAD
		buttons = new ButtonPanel();
		simulation = new SkiPanel();
		simulation.setSize(getWidth() - 50, getHeight() - 100);
		this.setTopComponent(buttons);
=======
		setButtons(new ButtonPanel());
		simulation = new SkiPanel();
		simulation.setSize(getWidth() - 50, getHeight() - 100);
		this.setTopComponent(getButtons());
>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b
		this.setBottomComponent(simulation);
		setVisible(true);
	}

	public void drawing(boolean[][] agent) {
		simulation.drawing(agent);
		repaint();
	}

<<<<<<< HEAD
=======
	public ButtonPanel getButtons() {
		return buttons;
	}

	void setButtons(ButtonPanel buttons) {
		this.buttons = buttons;
	}

>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b
	
	
	

}
