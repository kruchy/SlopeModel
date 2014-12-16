package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import java.awt.GridLayout;

import javax.swing.border.TitledBorder;

/**
 * Button panel on the frame, manages user interaction 
 */
public class ButtonPanel extends javax.swing.JPanel {

	private JButton start;
	private JButton exit;
	private JButton addSkier;
	private JButton reset;
	private JSlider skiers;
	private JButton actualize;
	private JSlider slopeHeight;
	private JSlider slopeWidth;
	private JLabel  labelHeight;
	private JLabel 	labelWidth;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ButtonPanel() {
		super();
		init();
	}

	/**
	 * Initialization 
	 */
	private void init() {
		setStart(new JButton("Start"));
		setExit(new JButton("Exit"));
		setAddSkier(new JButton("Add Skier"));
		setReset(new JButton("Reset"));
		setSkiers(new JSlider(JSlider.HORIZONTAL, 1, 16, 5));
		setActualize(new JButton("Actualize"));
		setLabelHeight(new JLabel("Slope heigth"));
		setLabelWidth(new JLabel("Slope width"));
		
		setSlopeHeight(new JSlider(JSlider.HORIZONTAL,20,100,50));
		getSlopeHeight().setSnapToTicks(true);
		getSlopeHeight().setMajorTickSpacing(10);
		getSlopeHeight().setMinorTickSpacing(5);
		getSlopeHeight().setPaintLabels(true);
		getSlopeHeight().setPaintTicks(true);
		
		setSlopeWidth(new JSlider(JSlider.HORIZONTAL,20,100,50));
		getSlopeWidth().setSnapToTicks(true);
		getSlopeWidth().setMajorTickSpacing(10);
		getSlopeWidth().setMinorTickSpacing(5);
		getSlopeWidth().setPaintLabels(true);
		getSlopeWidth().setPaintTicks(true);
		
		
		getSkiers().setSnapToTicks(true);
		getSkiers().setMajorTickSpacing(5);
		getSkiers().setMinorTickSpacing(1);
		getSkiers().setPaintTicks(true);
		getSkiers().setPaintLabels(true);
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(0, 1, 0, 0));
		temp.add(getStart());
		temp.add(getAddSkier());
		temp.add(getActualize());
		temp.add(getReset());
		temp.add(getExit());
		add(temp);
		add(getSkiers());
		add(getLabelHeight());
		add(getSlopeHeight());
		add(getLabelWidth());
		add(getSlopeWidth());

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

	public JSlider getSlopeHeight() {
		return slopeHeight;
	}

	public void setSlopeHeight(JSlider slopeHeight) {
		this.slopeHeight = slopeHeight;
	}

	public JSlider getSlopeWidth() {
		return slopeWidth;
	}

	public void setSlopeWidth(JSlider slopeWidth) {
		this.slopeWidth = slopeWidth;
	}

	public JLabel getLabelHeight() {
		return labelHeight;
	}

	public void setLabelHeight(JLabel labelHeight) {
		this.labelHeight = labelHeight;
	}

	public JLabel getLabelWidth() {
		return labelWidth;
	}

	public void setLabelWidth(JLabel labelWidth) {
		this.labelWidth = labelWidth;
	}

}
