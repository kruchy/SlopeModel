package controller;

import java.util.ArrayList;

import agent.Agent;
import agent.Agent.Direction;
import agent.Skier;
import slope.Elevator;
import slope.Slope;

public class Manager {
 ArrayList <Agent> agents;
 Elevator elevator;
 
 public Manager()
 {
	 agents = new ArrayList<>();
	 elevator = new  Elevator();
 }
 
 public boolean updateModel()
 {
	 ArrayList<Agent> moved = moveSkiers();
	 addToElevator(moved);
	 moveElevator();
	 try {
		Thread.sleep(100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return true;
	 
 }
 
 public void moveElevator() {
	// TODO Auto-generated method stub
	
}

public void addToElevator(ArrayList<Agent> moved) {
	// TODO Auto-generated method stub
	
}

public ArrayList<Agent> moveSkiers(){
	 ArrayList<Agent> outOfBounds = new ArrayList<>();
	 for (Agent i : agents)
	 {
		int x = i.getLocation().getPosx();
		int y = i.getLocation().getPosy();
		Direction dir = i.getDir();
		if ( x+1 >= Slope.getWidth() || x <= 0 ) i.setDir(Direction.FWD);
		if ( y+1 >= Slope.getHeight() ) i.setLocation(Slope.getWidth(),Slope.getHeight());outOfBounds.add(i);
		i.time  += (double)i.getSpeed()/10.0 + i.time; 
		if(i.time > 1.0 )
		{
			i.move();
			i.time -= 1.0;
		}
		
	 }
	return outOfBounds;
 }
 
 public boolean onSkierCollision() {
	return false;
}
 public boolean onSkierAppear() {
	return false;
}
 public boolean onSkierMoved() {
	return false;
}
 public boolean onSimulationStart() {
	return false;
}
 public boolean onSimulationEnd() {
	return false;
}

public void addSkier(Skier a) {
	agents.add(a);
	
}
 
}
