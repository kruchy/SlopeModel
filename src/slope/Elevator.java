package slope;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import agent.Agent.State;
import agent.Skier;

public class Elevator {
	private final int maxSkiers = 3;
	public BlockingQueue<Skier> skierQueue;
	private BlockingQueue<Skier> waitingQueue;
	public Elevator() {
		skierQueue = new ArrayBlockingQueue<Skier>(Skier.numberOfSkiers);
		setWaitingQueue(new ArrayBlockingQueue<Skier>(maxSkiers));
		new Skier();
	

	}

	public synchronized boolean lift() throws InterruptedException {
		// if (!skierQueue.isEmpty()) {
		
		addToWaitingQueue(skierQueue);
	
		for (Skier skier : getWaitingQueue()) {
		  System.out.println(skier.getState());
			int y = skier.getLocation().getPosy();
		
			if (y > 0 && skier.getState() == State.ON_LIFT) {
				skier.setLocation(Slope.getWidth()-3, y - 1);
			}

			if (y == 0 ) {
				skier.setLocation(new Random().nextInt(Slope.getWidth()), 0);
				skier.setState(State.ON_TRACK);
				skier = getWaitingQueue().take();					
				
			}

			;
		}
		//skierQueue.remove(out);

		// out = null;

		// }
		return false;
	}

	public void addToWaitingQueue(BlockingQueue<Skier> skierQ) throws InterruptedException {
		System.out.println("SkierQueue : " + skierQueue.size());
		System.out.println("WaitingQueue : " + getWaitingQueue().size());
		Skier s = null;

		for (int i = 0; i < skierQ.size(); i++) {
			if (skierQ.size() >= maxSkiers)
				for (int j = 0; j < maxSkiers; j++) {
					s = skierQ.take();
					if (getWaitingQueue().offer(s))
						s.setState(State.ON_LIFT);
					else skierQ.offer(s);
				}
			else {
					s = skierQ.take();
					if (getWaitingQueue().offer(s))
						s.setState(State.ON_LIFT);
					else skierQ.offer(s);
				// skierQueue.remove(i);
			}
			

		}
	}

	public boolean addSkier(Skier skier) {
		return skierQueue.offer(skier);
	}

	public boolean delSkier(Skier skier) {
		return skierQueue.remove(skier);

	}


	public synchronized void removeAll() {
	skierQueue.clear();
		
	}

	public BlockingQueue<Skier> getWaitingQueue() {
		return waitingQueue;
	}

	public void setWaitingQueue(BlockingQueue<Skier> waitingQueue) {
		this.waitingQueue = waitingQueue;
	}
}