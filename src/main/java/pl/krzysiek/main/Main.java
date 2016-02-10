package pl.krzysiek.main;


import pl.krzysiek.agent.Agents;
import pl.krzysiek.controller.Manager;
import pl.krzysiek.slope.Slope;
import pl.krzysiek.view.SlopeFrame;

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

		manager.setRunning(true);
		thread.start();
		while (true) {
//			if(manager.isStep())
//			{
//				try {
//					manager.updateModel();
//					manager.drawSlope();
//
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				finally
//				{
//					manager.setStep(false);
//				}
//			}
//			while(manager.isRunning())
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