package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.prefs.BackingStoreException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import slope.Slope;
import controller.Manager;

public class SkiPanel extends JPanel {

	public Image image;
	boolean[][] agent;

	public SkiPanel() {
		super();
		agent= new boolean[Slope.getHeight() + 2][Slope.getWidth() + 2];
		setVisible(true);
		}

	public void drawing(boolean[][] agent) {
		
		/*	String path = new File("").getAbsolutePath();
			image = new ImageIcon(path + File.pathSeparator + "res"
					+ File.pathSeparator + "img" + File.pathSeparator
					+ "doge.png").getImage();
			System.out.println(image.getHeight(this));
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
		
		for (int i = 0; i < agent.length; i++) {
			for (int j = 0; j < agent[0].length; j++) {
				g2d.setColor(new Color(0,0, 0,1));
				 g2d.drawRect(i*15,j*15,30, 30);
				g2d.setColor(Color.blue);

				if (agent[i][j]) {
					//g2d.drawString("*", i * 5, j * 10);
					g2d.drawImage(image, i * 5, j * 10,null);
				}
			}
		}

	//	repaint();

		// revalida

	}

}
