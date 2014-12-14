package main;

import java.awt.*;

import javax.swing.SwingUtilities;

import controller.Manager;
import slope.Slope;
import view.SkiPanel;
import view.SlopeFrame;
import agent.Agent;
import agent.Agents;
import agent.Skier;

public class Main {

	public static void main(String[] args) {

		new Slope(50, 50, 100, 100);
		SlopeFrame slope = new SlopeFrame();
		Thread thread = new Thread(slope);
		Agents agents = new Agents();
		Manager manager = new Manager(slope, agents);

		thread.start();
		while (true) {
			while (true) {
				manager.updateModel();
				manager.drawSlope();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			// Handle any exceptions.
		}
	}
}