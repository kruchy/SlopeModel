package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.Manager;

import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.TextArea;

public class SlopeFrame extends JFrame implements Runnable {

	private SimulationSplitPane panel;
	private Dimension size = new Dimension(600, 400);
	private SimulationSplitPane splitPane;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SlopeFrame() {
		super("SlopeFrame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSplitPane(new SimulationSplitPane());
	}

	private void init() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		addWindowListener(new CloseWindow());
		setSize(400, 600);
		setLocation(50, 50);
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