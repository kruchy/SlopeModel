package slope;

import java.util.ArrayList;
import java.util.Random;

import agent.Agent;
import agent.Agent.State;
import agent.Skier;

public class Elevator {
	private int maxSkiers = 20;
	public ArrayList<Skier> skierQueue;
	private Skier out;

	public Elevator() {
		skierQueue = new ArrayList<>();
		out = new Skier();
	}

	public synchronized boolean lift() {
		if (!skierQueue.isEmpty()) {
			for (Skier skier : skierQueue) {
				int x = skier.getLocation().getPosx();
				int y = skier.getLocation().getPosy();
				if (y > 0)
					skier.setLocation(Slope.getWidth()-3, y - 1);
				if (y == 0 && skier.getState() == State.ON_LIFT) {
					skier.setLocation(new Random().nextInt(Slope.getWidth()), 0);
					skier.setState(State.ON_TRACK);
					out = skier;
				}
				;
			}
			skierQueue.remove(out);
			out = null;

		}
		return false;
	}

	public boolean addSkier(Skier skier) {
		return skierQueue.add(skier);
	}

	public boolean delSkier(Skier skier) {
		return skierQueue.remove(skierQueue.size()) != null;
		

	}

	public synchronized void removeAll() {
	skierQueue.clear();
		
	}
}