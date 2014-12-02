package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import controller.Manager;

public class SkiPanel extends JPanel {
	

	boolean[][] agent;
	public SkiPanel(boolean[][] agent){
		this.agent = agent;
	}
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
	
		for (int i = 0 ; i < agent.length; i++)
		{
			for (int j = 0; j < agent[0].length; j++)
			{	
				g2d.setColor(Color.gray);
				g2d.drawRect(i*15,j*15,30, 30);
				g2d.setColor(Color.blue);
				if(agent[i][j])
				{
					g2d.drawString("s", i*5, j*10);
				}
			}
		}
		
	    //revalidate();
		repaint();
		
	}

	
	
}
