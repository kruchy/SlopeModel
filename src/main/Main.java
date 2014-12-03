package main;

import java.awt.*;

import controller.Manager;
import slope.Slope;
import view.SkiPanel;
import view.SlopeFrame;
import agent.Skier;

public class Main {
	public static void main(String[] args) {

	
		new Slope(50,50,400,600);

		Manager manager = new Manager();

		SkiPanel skiPanel = new SkiPanel(manager.getAgentMap());
		SlopeFrame slopeFrame = new SlopeFrame(1, 1, 400, 600,skiPanel);
		for (int i = 1; i <= 7; i++)
		{
			manager.addSkier(new Skier());
		}
		Slope.printHeightmap();
		while (true) {
			manager.updateModel();
			manager.updateAgentMap();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//skiPanel.drawing();

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