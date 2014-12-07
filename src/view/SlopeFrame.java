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

import controller.Manager;

import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.TextArea;

public class SlopeFrame extends JFrame {

	private JFrame frame;
	private ButtonPanel buttons;
	private SkiPanel panel;
	private Dimension size = new Dimension(600, 400);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SlopeFrame(int x, int y, int width, int height, SkiPanel sp) {
		setTitle("SlopeFrame");
		panel = sp;
		initialize(x, y, width, height);
	}

	private void initialize(int x, int y, int width, int height) {
		frame = new JFrame("SlopeFrame");
		buttons = new ButtonPanel();
		addWindowListener(new CloseWindow());
		setSize(350, 600);
		setLocation(x, y);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		frame.getContentPane().setLayout(new GridBagLayout());
		add(buttons);
		
	
		/*loadMap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser("Wybierz plik mapy");
				int r = file.showOpenDialog(frame);
				if (r == file.APPROVE_OPTION) {

				}

			}
		});
*/		
		

		panel.setSize(600, 100);
		add(panel, BorderLayout.CENTER);
		panel.setBackground(new Color(255, 255, 255));
		
		setVisible(true);

	}

}