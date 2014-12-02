package slope;

import java.util.ArrayList;
import java.util.Random;

import agent.Agent;
import agent.Agent.State;
import agent.Skier;

public class Elevator {
	private int maxSkiers = 20;
	public ArrayList<Skier> skierQueue;

	public boolean lift() {
		if (!skierQueue.isEmpty()) {
			// System.out.println(skierQueue.size());
			Skier out = new Skier();
			for (Skier skier : skierQueue) {
				int x = skier.getLocation().getPosx();
				int y = skier.getLocation().getPosy();
				if (y > 0)
					skier.setLocation(x, y - 1);
				if (y == 0 && skier.getState() == State.ON_LIFT) {
					skier.setLocation(new Random().nextInt(Slope.getWidth()), 0);
					skier.setState(State.ON_TRACK);
					out = skier;
				}
				;
			}
			skierQueue.remove(out);

		}
		return false;
	}

	public Elevator() {
		skierQueue = new ArrayList<>();
	}

	public boolean addSkier(Skier skier) {
		return skierQueue.add(skier);
	}

	public boolean delSkier(Skier skier) {
		return skierQueue.remove(skier);

	}
}