package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import slope.Slope;

public class SkiPanel extends JPanel {

	public Image image;
	boolean[][] agent;

	public SkiPanel() {
		super();
		agent = new boolean[Slope.getHeight() + 2][Slope.getWidth() + 2];
		setVisible(true);
	}

	public void drawing(boolean[][] agent) {

		/*
		 * String path = new File("").getAbsolutePath(); image = new
		 * ImageIcon(path + File.pathSeparator + "res" + File.pathSeparator +
		 * "img" + File.pathSeparator + "doge.png").getImage();
		 * System.out.println(image.getHeight(this));
		 */
		this.agent = agent;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setBackground(Color.white);

		try {
			String path = new File("").getAbsolutePath();
			image = new ImageIcon("doge.png").getImage();
		} catch (Exception o) {
			o.printStackTrace();
		}
		g2d.drawLine(0, 0, 0, agent.length * 15);
		g2d.drawLine(0, 0, agent[0].length * 15, 0);
		g2d.drawRect((agent[0].length - 3) * 5, 0, 15, agent.length * 15);

		for (int k = 0; k < Slope.getHeight(); k++) {
			for (int l = 0; l < Slope.getWidth(); l++) {

				g2d.setColor(new Color(0, 0, 0, 1));
				g2d.drawRect(k * 5, l * 15, 30, 30);
			}
			for (int i = 0; i < agent.length; i++) {
				for (int j = 0; j < agent[0].length; j++) {
					g2d.setColor(Color.blue);

					if (agent[i][j]) {
						g2d.drawString("*", i * 5, j * 10);
						g2d.drawImage(image, i * 5, j * 10, null);
					}
				}
			}

			// repaint();

			// revalida

		}
	}
}
