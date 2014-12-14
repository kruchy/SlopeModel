package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
<<<<<<< HEAD
=======
import javax.swing.JSlider;
>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b
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
<<<<<<< HEAD
	private JButton loadMap;
	private JTextField mapDir;
	private JTextField heightDir;
=======
	private JButton reset;
	private JSlider skiers;
	private JButton actualize;
>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ButtonPanel()
	{
<<<<<<< HEAD
		super(new BorderLayout());
=======
		super();
>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b
		init();
	}

	private void init() {
<<<<<<< HEAD
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
		//addSkier.addActionListener(manager.new AddSkierListener());
		add(mapDir);
		add(heightDir);
		this.setBorder(new TitledBorder("Opcje symulacji"));
		setVisible(true);
	}
=======
		setStart(new JButton("Start"));
		setExit(new JButton("Exit"));
		setAddSkier(new JButton("Add Skier"));
		setReset(new JButton("Reset"));
		setSkiers(new JSlider(JSlider.HORIZONTAL, 1, 16, 5));
		setActualize(new JButton("Actualize"));
		getSkiers().setSnapToTicks(true);
		getSkiers().setMajorTickSpacing(5);
		getSkiers().setMinorTickSpacing(1);
		getSkiers().setPaintTicks(true);
		getSkiers().setPaintLabels(true);
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel temp = new JPanel();
		temp.add(getStart());
		temp.add(getReset());
		temp.add(getExit());
		temp.add(getAddSkier());
		temp.add(getActualize());
		add(temp);
		add(getSkiers());
		
		this.setBorder(new TitledBorder("Opcje symulacji"));
		setVisible(true);
	}

	public JButton getStart() {
		return start;
	}

	public void setStart(JButton start) {
		this.start = start;
	}

	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
	}

	public JButton getAddSkier() {
		return addSkier;
	}

	public void setAddSkier(JButton addSkier) {
		this.addSkier = addSkier;
	}

	public JButton getReset() {
		return reset;
	}

	public void setReset(JButton reset) {
		this.reset = reset;
	}

	public JSlider getSkiers() {
		return skiers;
	}

	public void setSkiers(JSlider skiers) {
		this.skiers = skiers;
	}

	public JButton getActualize() {
		return actualize;
	}

	public void setActualize(JButton actualize) {
		this.actualize = actualize;
	}
>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b
	
}
