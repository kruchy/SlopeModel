package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.TextArea;

public class SlopeFrame extends JFrame {

	private JFrame frame;
	private JButton start ;
	private JButton exit;
	private JButton loadHeight;
	private JButton loadMap;
	private JTextField mapDir;
	private JTextField heightDir;
	private JPanel buttons;
	private Dimension size = new Dimension(600,400);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Panel panel;

	public SlopeFrame(int x,int y,int width ,int height )
	{
		setTitle("SlopeFrame");
		initialize(x, y, width, height);
	}

	private void initialize(int x, int y, int width, int height ) {
		frame = new JFrame("SlopeFrame");
		buttons = new JPanel();
		
		addWindowListener(new CloseWindow());
		setSize(800, 600);
		setLocation(x, y);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		frame.getContentPane().setLayout(new GridBagLayout());
		getContentPane().add(buttons);
		start = new JButton("Start");
		exit = new JButton("Exit");
		loadHeight = new JButton("Load HeightMap");
		loadMap = new JButton("Load Map");
		mapDir = new  JTextField("...");
		heightDir = new JTextField("...");
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setEnabled(false);
			}
		});
		loadHeight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		loadMap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser("Wybierz plik mapy");
				int r=file.showOpenDialog(frame);
				if(r==file.APPROVE_OPTION)
				{
					
				}
				
				
			}
		});
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttons.add(start);
		buttons.add(exit);
		buttons.add(loadMap);
		buttons.add(loadHeight);
		buttons.add(mapDir);
		buttons.add(heightDir);
		panel = new Panel();
		panel.setSize(600 , 100); 
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setBackground(new Color(255,255,255));
		//pack();
	}
	
	
	public void drawTable(boolean[][] table)
	{
		Graphics g = getGraphics();
	//	repaint();
		
		for (int i = 0 ; i < table.length; i++)
		{
			for (int j = 0; j < table[0].length; j++)
			{	
				if(table[i][j])
				{
					//g.drawRect(i*30,j*30,30, 30);
					g.drawString("s", i*10, j*10);
				}
			}
		}
		
	}
	@Override public void paint(Graphics g)
	{
		super.paint(g);
	}
	
}
