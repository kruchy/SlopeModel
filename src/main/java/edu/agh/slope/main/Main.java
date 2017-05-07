package edu.agh.slope.main;


import edu.agh.slope.controller.Manager;
import edu.agh.slope.slope.Slope;
import edu.agh.slope.view.SlopeFrame;
import edu.agh.slope.agent.Agents;

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