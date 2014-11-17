package main;

import controller.Manager;
import slope.Slope;
import agent.Skier;

public class Main {
	public static void main(String[] args) {
		Slope slope = new Slope(30, 30, 100, 5);
		Skier a = new Skier();
		Skier b = new Skier();
		Manager manager = new Manager();
		manager.addSkier(a);
		manager.addSkier(b);
		while (true) {
			for (int i = 0; i < Slope.getHeight(); i++) {
				for (int j = 0; j < Slope.getWidth(); j++) {
					if (a.getLocation().getPosx() == j
							&& a.getLocation().getPosy() == i
							|| b.getLocation().getPosx() == j
							&& b.getLocation().getPosy() == i)
						System.out.print('*');
					else
						System.out.print('.');
				}
				System.out.println();

			}
			for (int j = 0; j < 11; j++)
				System.out.print('_');
		//	System.out.print(a.getSpeed()/15.0+a.time);
			System.out.println();
			manager.updateModel();
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