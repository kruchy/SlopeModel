package edu.agh.slope.view;

import javax.swing.*;

/**
 * Main GUI frame, implements Runnable to give the ability to run as new thread to optimalize.
 *
 * @author Kruchy
 */
public class SlopeFrame extends JFrame implements Runnable {

    private SimulationSplitPane splitPane;

    private static final long serialVersionUID = 1L;

    public SlopeFrame() {
        super("SlopeFrame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSplitPane(new SimulationSplitPane());
    }

    private void init() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        //addWindowListener(new CloseWindow());
        setSize(800, 700);
        //splitPane.getSimulation().setSizeToDraw(getWidth(), getHeight());
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