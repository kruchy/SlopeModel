package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
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
	private JButton reset;
	private JSlider skiers;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ButtonPanel()
	{
		super();
		init();
	}

	private void init() {
		setStart(new JButton("Start"));
		setExit(new JButton("Exit"));
		setAddSkier(new JButton("Add Skier"));
		setReset(new JButton("Reset"));
		setSkiers(new JSlider(JSlider.HORIZONTAL, 1, 16, 5));
		getSkiers().setSnapToTicks(true);
		getSkiers().setMajorTickSpacing(5);
		getSkiers().setMinorTickSpacing(1);
		getSkiers().setPaintTicks(true);
		getSkiers().setPaintLabels(true);
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel temp = new JPanel(new GridLayout(0,1));
		temp.add(getStart());
		temp.add(getExit());
		temp.add(getAddSkier());
		add(getSkiers());
		add(temp);
		
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
	
}
