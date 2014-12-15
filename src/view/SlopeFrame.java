package view;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.*;

public class SlopeFrame extends JFrame implements Runnable {

	private SimulationSplitPane splitPane;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SlopeFrame() {
		super("SlopeFrame");
		splitPane = new SimulationSplitPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void init() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		//addWindowListener(new CloseWindow());
		setSize(800, 700);
		splitPane.simulation.setSizeToDraw(getHeight(), getWidth());
		setLocation(25, 25);
		setVisible(true);
		add(getSplitPane());
		setVisible(true);

	}

	public void drawing(boolean[][] agent) {
		getSplitPane().drawing(agent);
	}

	@Override
	public void run() {
		init();

		this.setVisible(true);

	}

	public SimulationSplitPane getSplitPane() {
		return splitPane;
	}

	public void setSplitPane(SimulationSplitPane splitPane) {
		this.splitPane = splitPane;
	}


}