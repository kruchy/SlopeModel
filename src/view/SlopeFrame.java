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
		addComponentListener(new WindowSizeListener());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void init() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		addWindowListener(new CloseWindow());
		setSize(800, 700);
		splitPane.simulation.setSizeToDraw(getWidth(), getHeight());
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

	public class WindowSizeListener implements ComponentListener {
		@Override
		public void componentHidden(ComponentEvent arg0) {
		}

		@Override
		public void componentMoved(ComponentEvent arg0) {
		}

		@Override
		public void componentResized(ComponentEvent arg0) {
			splitPane.simulation.setSizeToDraw(getWidth(), getHeight());
		}

		@Override
		public void componentShown(ComponentEvent arg0) {
		}
	}
}