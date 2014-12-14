package agent;

import java.util.ArrayList;

import agent.Agent.Direction;
import agent.Agent.State;
import slope.Slope;

public class Agents {

	public ArrayList<Skier> agents;
	private boolean[][] agentMap;

	
	public Agents(){
		init();

	}

	private void init() {
		agents = new ArrayList<>();
		setAgentMap(new boolean[Slope.getHeight() + 2][Slope.getWidth() + 2]);
		
	}

	public void updateAgentMap() {
		for (int i = 0; i < agentMap.length; i++)
			for (int j = 0; j < agentMap[0].length; j++) {
				agentMap[i][j] = false;
			}
		for (Skier iter : agents) {
			int x = iter.getLocation().getPosx();
			int y = iter.getLocation().getPosy();
			if (x <= Slope.getWidth() && y <= Slope.getHeight())
				agentMap[x][y] = true;
				
		}
	}
	
	public boolean[][] getAgentMap() {
		return agentMap;
	}


	public void setAgentMap(boolean[][] agentMap) {
		this.agentMap = agentMap;
	}

	private boolean foundCollisions() {
		/*for (Agent iter : agents) {
			int x = iter.getLocation().getPosx();
			int y = iter.getLocation().getPosy();
		}*/
		return false;
		
		

	}
	public synchronized ArrayList<Skier> moveSkiers() {
		ArrayList<Skier> outOfBounds = new ArrayList<>();
		for (Skier i : agents) {
			if(i.getState() == State.ON_TRACK){
				int x = i.getLocation().getPosx();
				int y = i.getLocation().getPosy();
				if (y + 1 < Slope.getHeight() && x + 1 < Slope.getWidth()
						&& x - 1 > 0)
					i.findCell();
				if (x + 1 >= Slope.getWidth()-5) {
					i.setDir(Direction.R);
				}
				if (x <= 0) {
					i.setDir(Direction.L);
				}
				if (y + 1 >= Slope.getHeight()) {
					i.setLocation(Slope.getWidth() +3, Slope.getHeight() - 4);
					outOfBounds.add(i);
				}
				i.time += (double) i.getSpeed() / 10.0 + i.time;
				if (i.time > 1.0 ) {
					i.move();
					i.time -= 1.0;
				}
			}
		}
		return outOfBounds;
	}

	public void addSkier(Skier skier) {
		agents.add(skier);
		
	}

	public void removeAll() {
		init();
	}
	
	
}

