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
<<<<<<< HEAD
	public static void main(String[] args) throws InterruptedException {
=======

	public static void main(String[] args) {
>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b

		new Slope(50, 50, 100, 100);

		SlopeFrame slope = new SlopeFrame();
<<<<<<< HEAD
		Manager manager = new Manager(slope);
//		for (int i = 1; i <= 15; i++) {
//			manager.addSkier(new Skier());
//		}
		SwingUtilities.invokeLater(slope);
		Slope.printHeightmap();
		while (true) {
			manager.updateModel();
			manager.updateAgentMap();
			manager.drawSlope();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
=======
		Thread thread = new Thread(slope);
		Agents agents = new Agents();
		Manager manager = new Manager(slope, agents);

	/*	for (int i = 1; i <= 7; i++) {
			manager.addSkier(new Skier());
		}
	*/	Slope.printHeightmap();
		thread.start();
		while (true) {
			while (manager.isRunning()) {
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

>>>>>>> cd5a7da44903c0a3f4b1828b8406de938c46a02b
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