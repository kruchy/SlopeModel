package slope;

import java.util.ArrayList;
import java.util.Random;

import agent.Agent;
import agent.Agent.State;
import agent.Skier;

public class Elevator implements Runnable{
	private int maxSkiers = 20;
	public ArrayList<Skier> skierQueue;
	private Skier out;
	private boolean running;
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public Elevator() {
		skierQueue = new ArrayList<>();
		out = new Skier();
		setRunning(true);
	}

	public boolean lift() {
		while(isRunning())
		if (!skierQueue.isEmpty() && isRunning()) {
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

	public boolean delSkier() {
		return skierQueue.remove(skier);

	}

	public boolean removeAll()
	{
		skierQueue.clear();
		setRunning(true);
		return skierQueue.isEmpty();
	}
	
	@Override
	public void run() {
		
	}
}