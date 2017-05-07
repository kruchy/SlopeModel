package edu.agh.slope.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

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
    private JButton step;
    private JSlider slopeHeight;
    private JSlider slopeWidth;
    private JLabel labelHeight;
    private JLabel labelWidth;
    private JButton pause;
    private JButton cont;
    private JLabel add;
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
        setStep(new JButton("Step"));
        setPause(new JButton("Pause"));
        setCont(new JButton("Continue"));


        setAdd(new JLabel("Number of skiers"));
        setLabelHeight(new JLabel("Slope heigth"));
        setLabelWidth(new JLabel("Slope width"));


        setSlopeHeight(new JSlider(JSlider.HORIZONTAL, 20, 100, 50));
        getSlopeHeight().setSnapToTicks(true);
        getSlopeHeight().setMajorTickSpacing(10);
        getSlopeHeight().setMinorTickSpacing(5);
        getSlopeHeight().setPaintLabels(true);
        getSlopeHeight().setPaintTicks(true);

        setSlopeWidth(new JSlider(JSlider.HORIZONTAL, 20, 100, 50));
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
        JPanel temp2 = new JPanel();
        JPanel temp3 = new JPanel();
        temp.setLayout(new GridLayout(0, 1, 0, 0));
        temp2.setLayout(new GridLayout(0, 1, 0, 0));
        temp3.setLayout(new GridLayout(1, 0, 0, 0));

        temp.add(getStart());
        temp.add(getCont());
        temp.add(getPause());
        temp2.add(getStep());
        temp2.add(getAddSkier());
        temp2.add(getActualize());
        temp2.add(getReset());
        temp.add(getExit());

        add(temp3);
        temp3.add(temp);
        temp3.add(temp2);
        add(getAdd());
        add(getSkiers());
        add(getLabelHeight());
        add(getSlopeHeight());
        add(getLabelWidth());
        add(getSlopeWidth());

        this.setBorder(new TitledBorder("Options"));
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

    public JButton getStep() {
        return step;
    }

    public void setStep(JButton step) {
        this.step = step;
    }

    public JButton getPause() {
        return pause;
    }

    public void setPause(JButton pause) {
        this.pause = pause;
    }

    public JButton getCont() {
        return cont;
    }

    public void setCont(JButton cont) {
        this.cont = cont;
    }

    public JLabel getAdd() {
        return add;
    }

    public void setAdd(JLabel add) {
        this.add = add;
    }

}
