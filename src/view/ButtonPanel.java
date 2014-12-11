package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.Manager;

public class ButtonPanel extends javax.swing.JPanel {

	private JButton start;
	private JButton exit;
	private JButton addSkier;
	private JButton loadMap;
	private JTextField mapDir;
	private JTextField heightDir;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ButtonPanel(Manager manager)
	{
		super(new BorderLayout());
		init(manager);
	}

	private void init(Manager manager) {
		start = new JButton("Start");
		exit = new JButton("Exit");
		addSkier = new JButton("Add Skier");
		loadMap = new JButton("Load Map");
		mapDir = new JTextField("...");
		heightDir = new JTextField("...");
		setLayout(new GridLayout(1, 0, 0, 0));
		add(start);
		add(exit);
		add(loadMap);
		add(addSkier);
		addSkier.addActionListener(manager.new AddSkierListener());
		add(mapDir);
		add(heightDir);
		this.setBorder(new TitledBorder("Opcje symulacji"));
		setVisible(true);
	}
	
}
