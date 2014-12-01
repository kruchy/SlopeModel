package main;

import java.awt.*;

import controller.Manager;
import slope.Slope;
import view.SlopeFrame;
import agent.Skier;

public class Main {
	public static void main(String[] args) {
		Slope slope = new Slope(100, 100, 100, 5);
		Skier a = new Skier();
		Skier b = new Skier();
		Manager manager = new Manager();
		new SlopeFrame(50,50 ,600, 400);
		/*EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SlopeFrame(50,50,400,600);
			}
		});*/
		manager.addSkier(a);
		manager.addSkier(b);
		slope.printHeightmap();
		while(true)
		{
			manager.updateModel();
			manager.updateAgentMap();

		//	manager.updateTable();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
		/*while (true) {
			for (int i = 1; i < Slope.getHeight()+1; i++) {
				for (int j = 1; j < Slope.getWidth()+1; j++) {
			
						if (manager.agentMap[i][j])
						System.out.print('*');
					else
						System.out.print('.');
				}
				System.out.println();*/
			
				/*for (int i = 0; i < Slope.getHeightmap().length; i++)
					{
						for (int j = 0; j < Slope.getHeightmap().length; j++ )
						{
							System.out.print(Slope.getHeightmap()[i][j]);
							System.out.print(' ');
						}
						System.out.println();
					}*/
	/*		for (int j = 0; j < 11; j++)
				System.out.print('_');
	*/	//	System.out.print(a.getSpeed()/15.0+a.time);
			/*System.out.println();
			manager.updateModel();
	}*/
	

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