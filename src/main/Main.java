package main;

import controller.Manager;
import slope.Slope;
import view.SlopeFrame;
import agent.Agents;

public class Main {

	public static void main(String[] args) {

		new Slope(50, 50, 100, 100);
		SlopeFrame slope = new SlopeFrame();
		Thread thread = new Thread(slope);
		Agents agents = new Agents();
		Manager manager = new Manager(slope, agents);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {

			}
		});

		manager.setRunning(false);
		thread.start();
		while (true) {
			if(manager.isStep())
			{
				try {
					manager.updateModel();
					manager.drawSlope();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					manager.setStep(false);
				}
			}
			while(manager.isRunning())
			try {
				
				manager.updateModel();
				manager.drawSlope();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}