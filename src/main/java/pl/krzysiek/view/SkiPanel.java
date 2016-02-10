package pl.krzysiek.view;

import pl.krzysiek.slope.Slope;

import javax.swing.*;
import java.awt.*;
import java.net.URL;


/**
 * Place to draw data received from model.
 *
 * @author Kruchy
 */
public class SkiPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Dimension dim;
    public Image image;
    boolean[][] agent;
    int height;
    int width;

    /**
     * Default constructor.
     */
    public SkiPanel() {
        super();
        agent = new boolean[Slope.getHeight() + 2][Slope.getWidth() + 2];
        setVisible(true);
        URL url = this.getClass().getClassLoader().getResource("doge.jpg");
        System.out.println(url.toString());
        image = new ImageIcon(url).getImage();
    }

    /**
     * Function to draw given map of agents on the panel.
     *
     * @param agent Rectangle table of agents on the slope
     */
    public void drawing(boolean[][] agent) {

        this.agent = agent;
        repaint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setBackground(Color.white);
        int xDim = (int) (getWidth() / 56);
        int yDim = (int) (getHeight() / 66);
        g2d.drawLine(0, (agent[0].length) * yDim, Slope.getWidth() * xDim,
                (agent[0].length) * yDim);
        g2d.drawRect((Slope.getWidth() - 3) * xDim, 0, 15, Slope.getHeight()
                * yDim);

        for (int k = 0; k < Slope.getHeight(); k++)
            for (int l = 0; l < Slope.getWidth(); l++) {

                g2d.setColor(new Color(0, 0, 0, 1));
                g2d.drawRect(k * getWidth() / 56, l * getHeight() / 66, 30, 30);
            }

        for (int i = 0; i < agent.length; i++) {
            for (int j = 0; j < agent[0].length; j++) {
                g2d.setColor(Color.blue);
                if (agent[i][j]) {
//					 g2d.drawString("*", i*getWidth()/56, j*getHeight()/66);
                    g2d.drawImage(image, i * getWidth() / 56, j * getHeight()
                            / 66, null);
                }
            }
        }
    }


    public Dimension getDim() {
        return dim;
    }

    public void setDimensions(int x, int y) {
        if (dim == null) {
            System.out.println("SET" + x);
            setDim(new Dimension(x, y));
        }
    }

    public void setDim(Dimension dim) {
        this.dim = dim;
    }
}
